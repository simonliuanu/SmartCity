package com.example.smartcity.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartcity.R;
import com.example.smartcity.dataStructure.AvlTree;
import com.example.smartcity.entity.Restaurant;
import com.example.smartcity.entity.RestaurantManager;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Comparator;

public class HomeFragment extends Fragment {

    private View homeView;
    private EditText editTextSearch;
    private Button buttonSearch;
    private RecyclerView recyclerViewRestaurants;
    private AvlTree<Restaurant> restaurantTree;
    private RestaurantManager restaurantManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        homeView = inflater.inflate(R.layout.fragment_home, container, false);

        editTextSearch = homeView.findViewById(R.id.editTextSearch);
        buttonSearch = homeView.findViewById(R.id.buttonSearch);
        recyclerViewRestaurants = homeView.findViewById(R.id.recyclerViewRestaurants);

        recyclerViewRestaurants.setLayoutManager(new LinearLayoutManager(getContext()));


        Comparator<Restaurant> byNameComparator = new Comparator<Restaurant>() {
            @Override
            public int compare(Restaurant r1, Restaurant r2) {
                return r1.getName().compareTo(r2.getName());
            }
        };
        restaurantTree = new AvlTree<>();

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

    private void fetchRestaurantData() {

    }
}
