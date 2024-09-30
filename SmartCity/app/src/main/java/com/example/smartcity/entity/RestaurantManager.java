/*
package com.example.smartcity.entity;

import android.content.Context;

import com.example.smartcity.reader.JsonReader;
import com.example.smartcity.dataStructure.AvlTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class RestaurantManager {
    private static RestaurantManager instance;
    private Context context;
    private JsonReader jsonReader = new JsonReader();
    private AvlTree<Restaurant> restaurantTree = new AvlTree<>();

    // Private constructor to prevent instantiation
    private RestaurantManager(Context context) {
        this.context = context;
        loadRestaurantData();
    }

    // Static method to provide access to the singleton instance
    public static synchronized RestaurantManager getInstance(Context context) {
        if (instance == null) {
            instance = new RestaurantManager(context.getApplicationContext());
        }
        return instance;
    }

    // Load and parse the restaurant data
    private void loadRestaurantData() {
        try {
            // Read JSON file from assets
            InputStream inputStream = context.getAssets().open("RES_dataSet.json");
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            StringBuilder jsonStringBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonStringBuilder.append(line);
            }
            reader.close();

            String jsonString = jsonStringBuilder.toString();

            // Parse JSON data into Restaurant objects
            List<Restaurant> restaurants = jsonReader.parseJsonToRestaurantList(jsonString);

            int count = 0;
            // Insert all restaurants into the AVL tree
            for (Restaurant restaurant : restaurants) {
                restaurantTree.insert(restaurant);
                count++;
            }

            System.out.println("一共有多少数据： "+count);

        } catch (IOException e) {
            e.printStackTrace();
            // Handle file read errors
        }
    }

    // Retrieve the AVL tree containing all restaurants
    public AvlTree<Restaurant> getRestaurantTree() {
        return restaurantTree;
    }
}
*/
