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
import com.example.smartcity.dataStructure.Tokenizer;
import com.example.smartcity.dataStructure.Parser;
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
            List<String> validTokens = getValidTokens();
            restaurantManager = new RestaurantManager(restaurantTree, validTokens);
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

                List<String> validTokens = getValidTokens();
                restaurantManager = new RestaurantManager(restaurantTree, validTokens);
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
            List<Restaurant> results = restaurantManager.search(query, filterType);

            if (!results.isEmpty()) {
                Restaurant exactMatch = null;
                for (Restaurant restaurant : results) {
                    if (restaurant.getName().toLowerCase().equalsIgnoreCase(query)) {
                        exactMatch = restaurant;
                        break;
                    }
                }

                sortResults(results);

                if (exactMatch != null) {
                    results.remove(exactMatch);
                    results.add(0, exactMatch);
                }

                updateSearchResults(results);
            } else {
                updateSearchResults(new ArrayList<>());
                Toast.makeText(getContext(), "No matching restaurants found.", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(getContext(), "Please enter a search query.", Toast.LENGTH_SHORT).show();
        }
    }

    private List<String> getValidTokens() {
        List<String> validTokens = new ArrayList<>();
        collectValidTokens(restaurantTree.getRoot(), validTokens);
        return validTokens;
    }

    private void collectValidTokens(AvlTree.Node<Restaurant> node, List<String> validTokens) {
        if (node == null) {
            return;
        }

        Tokenizer tokenizer = new Tokenizer();
        List<String> tokens = tokenizer.tokenize(node.getData().getName());
        for (String token : tokens) {
            if (!validTokens.contains(token)) {
                validTokens.add(token);
            }
        }

        collectValidTokens(node.getLeft(), validTokens);
        collectValidTokens(node.getRight(), validTokens);
    }

    private void sortResults(List<Restaurant> results) {
        List<Restaurant> filteredResults = new ArrayList<>();
        List<Restaurant> unknownPrice = new ArrayList<>();
        for (Restaurant restaurant : results) {
            if (restaurant.getPrice() != 5) {
                filteredResults.add(restaurant);
            } else {
                unknownPrice.add(restaurant);
            }
        }

        String sortBy = spinnerSortBy.getSelectedItem().toString();
        switch (sortBy) {
            case "Price: Low to High":
                Collections.sort(filteredResults, Comparator.comparingDouble(Restaurant::getPrice));
                break;
            case "Price: High to Low":
                Collections.sort(filteredResults, Comparator.comparingDouble(Restaurant::getPrice).reversed());
                break;
            case "Rating: High to Low":
                Collections.sort(filteredResults, Comparator.comparingDouble(Restaurant::getRating).reversed());
                break;
            case "Rating: Low to High":
                Collections.sort(filteredResults, Comparator.comparingDouble(Restaurant::getRating));
                break;
            default:
                break;
        }

        results.clear();
        results.addAll(filteredResults);
        results.addAll(unknownPrice);
    }

    private void updateSearchResults(List<Restaurant> results) {
        restaurantList.clear();
        restaurantList.addAll(results);
        itemListAdapter.notifyDataSetChanged();
        listViewRestaurants.setSelection(0);
    }
}
