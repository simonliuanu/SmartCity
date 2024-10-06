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

    public List<Restaurant> search(String query) {
        List<String> tokens = tokenizer.tokenize(query);
        List<String> parsedTokens = parser.parse(tokens);
        String correctedQuery = String.join(" ", parsedTokens);

        List<Restaurant> results = new ArrayList<>();
        for (String token : parsedTokens) {
            Restaurant exactMatch = restaurantTree.searchExact(token);
            if (exactMatch != null) {
                results.add(exactMatch);
            } else {
                results.addAll(restaurantTree.searchByPrefix(token));
            }
        }

        return results;
    }


    public AvlTree<Restaurant> getRestaurantTree() {
        return restaurantTree;
    }
}