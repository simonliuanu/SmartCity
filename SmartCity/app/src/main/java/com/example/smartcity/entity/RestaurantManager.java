package com.example.smartcity.entity;

import android.content.Context;
import com.example.smartcity.reader.GsonJsonReader; // import GsonJsonReader
import com.example.smartcity.dataStructure.AvlTree;
import java.util.List;

public class RestaurantManager {
    private static RestaurantManager instance;
    private Context context;
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
        // 使用 GsonJsonReader 读取 JSON 数据
        List<Restaurant> restaurants = GsonJsonReader.readJsonFromFile(context, "RES_dataSet_one_line.json");

        if (restaurants != null) {
            // Insert all restaurants into the AVL tree
            for (Restaurant restaurant : restaurants) {
                restaurantTree.insert(restaurant);
            }
            System.out.println("the number of data： " + restaurants.size());
        } else {
            System.err.println("Not read any data.");
        }
    }

    // Retrieve the AVL tree containing all restaurants
    public AvlTree<Restaurant> getRestaurantTree() {
        return restaurantTree;
    }
}