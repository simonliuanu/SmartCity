package com.example.smartcity.entity;

import com.google.android.gms.maps.model.MarkerOptions;
import java.util.HashMap;
import java.util.List;

// This cache class is used for the subsequent loading of restaurants near the current location
public class MapRestaurantCache {
    private static MapRestaurantCache instance;
    private HashMap<String, List<MarkerOptions>> cachedRestaurants;

    private MapRestaurantCache() {
        cachedRestaurants = new HashMap<>();
    }

    public static MapRestaurantCache getInstance() {
        if (instance == null) {
            instance = new MapRestaurantCache();
        }
        return instance;
    }

    public HashMap<String, List<MarkerOptions>> getCachedRestaurants() {
        return cachedRestaurants;
    }
}