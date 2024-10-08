package com.example.smartcity.entity;

import android.content.Context;

import com.example.smartcity.dataStructure.Parser;
import com.example.smartcity.dataStructure.Tokenizer;
import com.example.smartcity.dataStructure.AvlTree;

import java.util.ArrayList;
import java.util.List;

public class RestaurantManager {
    private static RestaurantManager instance;
    private Context context;
    private AvlTree<Restaurant> restaurantTree = new AvlTree<>();
    private Tokenizer tokenizer;
    private Parser parser;

    public RestaurantManager(AvlTree<Restaurant> tree, List<String> validTokens) {
        this.restaurantTree = tree;
        this.tokenizer = new Tokenizer();
        this.parser = new Parser(validTokens);
    }

    public List<Restaurant> search(String query, String filterType) {
        List<String> tokens = tokenizer.tokenize(query);
        List<String> parsedTokens = parser.parse(tokens);

        List<Restaurant> results = new ArrayList<>();
        for (String token : parsedTokens) {
            Restaurant exactMatch = restaurantTree.searchExact(token);
            if (exactMatch != null) {
                results.add(exactMatch);
            } else {
                results.addAll(restaurantTree.searchByContains(token));
            }
        }

        return filterResultsByType(results, filterType);
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

    public AvlTree<Restaurant> getRestaurantTree() {
        return restaurantTree;
    }
}
