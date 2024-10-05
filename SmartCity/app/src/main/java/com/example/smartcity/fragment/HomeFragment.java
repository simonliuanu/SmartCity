package com.example.smartcity.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.smartcity.R;
import com.example.smartcity.activity.CommentActivity;
import com.example.smartcity.adapter.ItemListAdapter;
import com.example.smartcity.dataStructure.AvlTree;
import com.example.smartcity.dataStructure.AvlTreeManager;
import com.example.smartcity.entity.Restaurant;
import com.example.smartcity.entity.RestaurantManager;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HomeFragment extends Fragment {

    private View homeView;
    private EditText editTextSearch;
    private Button buttonSearch;
    private ListView listViewRestaurants;
    private AvlTree<Restaurant> restaurantTree;
    private RestaurantManager restaurantManager;
    private ItemListAdapter itemListAdapter;
    private Spinner spinnerFilter, spinnerSortBy;

    private List<Restaurant> restaurantList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        homeView = inflater.inflate(R.layout.fragment_home, container, false);

        editTextSearch = homeView.findViewById(R.id.editTextSearch);
        buttonSearch = homeView.findViewById(R.id.buttonSearch);
        listViewRestaurants = homeView.findViewById(R.id.listViewRestaurants);

        spinnerFilter = homeView.findViewById(R.id.spinnerFilter);
        spinnerSortBy = homeView.findViewById(R.id.spinnerSortBy);

        itemListAdapter = new ItemListAdapter(getContext(), restaurantList);
        listViewRestaurants.setAdapter(itemListAdapter);

        restaurantTree = AvlTreeManager.getInstance();

        if (restaurantTree.countNodes() == 0) {
            fetchRestaurantDataFromFirebase();
        } else {
            restaurantManager = new RestaurantManager(restaurantTree);
        }

        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performSearch();
            }
        });

        spinnerFilter.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selected = parent.getItemAtPosition(position).toString();
                if (!selected.equals("All")) {
                    buttonSearch.performClick();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        spinnerSortBy.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selected = parent.getItemAtPosition(position).toString();
                if (!selected.equals("Sort By")) {
                    buttonSearch.performClick();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        listViewRestaurants.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Restaurant restaurant = restaurantList.get(i);
                Intent intent = new Intent(getContext(), CommentActivity.class);
                intent.putExtra("restaurant", restaurant);
                startActivity(intent);
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

        String query = editTextSearch.getText().toString().trim();
        String filterType = spinnerFilter.getSelectedItem().toString();

        if (!query.isEmpty()) {
            List<Restaurant> results = restaurantManager.search(query);
            if (!results.isEmpty()) {
                results = filterResultsByType(results, filterType);
                sortResults(results);
                updateSearchResults(results);
            } else {
                updateSearchResults(new ArrayList<>());
                Toast.makeText(getContext(), "No matching restaurants found.", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(getContext(), "Please enter a search query.", Toast.LENGTH_SHORT).show();
        }
    }

    private List<Restaurant> filterResultsByType(List<Restaurant> results, String filterType) {
        if (filterType.equals("All")) {
            return results;
        }

        List<Restaurant> filteredResults = new ArrayList<>();

        for (Restaurant restaurant : results) {
            if (restaurant.getTypes().contains(filterType.toLowerCase())) {
                filteredResults.add(restaurant);
            }
        }

        return filteredResults;
    }

    private void sortResults(List<Restaurant> results) {
        String sortBy = spinnerSortBy.getSelectedItem().toString();
        switch (sortBy) {
            case "Price: Low to High":
                Collections.sort(results, Comparator.comparingDouble(Restaurant::getPrice));
                break;
            case "Price: High to Low":
                Collections.sort(results, Comparator.comparingDouble(Restaurant::getPrice).reversed());
                break;
            case "Rating: High to Low":
                Collections.sort(results, Comparator.comparingDouble(Restaurant::getRating).reversed());
                break;
            case "Rating: Low to High":
                Collections.sort(results, Comparator.comparingDouble(Restaurant::getRating));
                break;
            default:
                break;
        }
    }

    private void updateSearchResults(List<Restaurant> results) {
        restaurantList.clear();
        restaurantList.addAll(results);
        itemListAdapter.notifyDataSetChanged();
        listViewRestaurants.setSelection(0);
    }
}
