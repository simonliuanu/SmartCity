package com.example.smartcity.entity;

import android.content.Context;

import com.example.smartcity.dataStructure.Parser;
import com.example.smartcity.dataStructure.Tokenizer;
import com.example.smartcity.dataStructure.AvlTree;
import java.util.List;

public class RestaurantManager {
    private static RestaurantManager instance;
    private Context context;
    private AvlTree<Restaurant> restaurantTree = new AvlTree<>();
    private Tokenizer tokenizer;
    private Parser parser;

    public RestaurantManager(AvlTree<Restaurant> tree) {
        this.restaurantTree = tree;
        this.tokenizer = new Tokenizer();
        this.parser = new Parser();
    }

    public List<Restaurant> search(String query) {
        String[] tokens = tokenizer.tokenize(query);

        String searchTerm = tokens[0];

        Restaurant exactMatch = restaurantTree.searchExact(searchTerm);

        if (exactMatch != null) {
            return List.of(exactMatch);
        }

        return restaurantTree.serachByPrefix(searchTerm);
    }

    // Static method to provide access to the singleton instance
//    public static synchronized RestaurantManager getInstance(Context context) {
//        if (instance == null) {
//            instance = new RestaurantManager();
//        }
//        return instance;
//    }

    // Retrieve the AVL tree containing all restaurants
    public AvlTree<Restaurant> getRestaurantTree() {
        return restaurantTree;
    }
}