package com.example.smartcity.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartcity.R;
import com.example.smartcity.adapter.ItemListAdapter;
import com.example.smartcity.dataStructure.AvlTree;
import com.example.smartcity.entity.Restaurant;
import com.example.smartcity.entity.RestaurantManager;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class HomeFragment extends Fragment {

    private View homeView;
    private EditText editTextSearch;
    private Button buttonSearch;
    private ListView listViewRestaurants;
    private RecyclerView recyclerViewRestaurants;
    private AvlTree<Restaurant> restaurantTree;
    private RestaurantManager restaurantManager;
    private ItemListAdapter itemListAdapter;

    private List<Restaurant> restaurantList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        homeView = inflater.inflate(R.layout.fragment_home, container, false);

        editTextSearch = homeView.findViewById(R.id.editTextSearch);
        buttonSearch = homeView.findViewById(R.id.buttonSearch);
        listViewRestaurants = homeView.findViewById(R.id.listViewRestaurants);

        itemListAdapter = new ItemListAdapter(getContext(), restaurantList);
        listViewRestaurants.setAdapter(itemListAdapter);

        Comparator<Restaurant> byNameComparator = new Comparator<Restaurant>() {
            @Override
            public int compare(Restaurant r1, Restaurant r2) {
                return r1.getName().compareTo(r2.getName());
            }
        };
        restaurantTree = new AvlTree<>();

        fetchRestaurantDataFromFirebase();

        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performSearch();
            }
        });

        return homeView;
    }

    private void fetchRestaurantDataFromFirebase() {
        Query query = FirebaseDatabase.getInstance()
                .getReference()
                .child("restaurants")
                .orderByKey();

        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot child : snapshot.getChildren()) {
                    Restaurant restaurant = child.getValue(Restaurant.class);
                    restaurantTree.insert(restaurant);
                }

                restaurantManager = new RestaurantManager(restaurantTree);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                System.out.println("Error loading data: " + databaseError.getMessage());
            }
        });
    }

    private void performSearch() {
        if (restaurantManager == null) {
            Toast.makeText(getContext(), "Please wait for the data to load.", Toast.LENGTH_SHORT).show();
            return;
        }

        String query = editTextSearch.getText().toString();
        if (!query.isEmpty()) {
            List<Restaurant> results = restaurantManager.search(query);
            if (!results.isEmpty()) {
                updateSearchResults(results);
            } else {
                Toast.makeText(getContext(), "No matching restaurants found.", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(getContext(), "Please enter a search query.", Toast.LENGTH_SHORT).show();
        }
    }

    private void updateSearchResults(List<Restaurant> results) {
        restaurantList.clear();
        restaurantList.addAll(results);
        itemListAdapter.notifyDataSetChanged();
    }
}
