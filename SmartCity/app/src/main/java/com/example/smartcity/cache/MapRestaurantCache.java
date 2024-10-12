package com.example.smartcity.cache;

import com.example.smartcity.entity.Restaurant;
import com.google.android.gms.maps.model.MarkerOptions;
import android.util.Pair;
import java.util.HashMap;
import java.util.List;

// This cache class is used for the subsequent loading of restaurants near the current location
public class MapRestaurantCache {
    private static MapRestaurantCache instance;
    private HashMap<String, List<Pair<MarkerOptions, Restaurant>>> cachedRestaurants;

    private MapRestaurantCache() {
        cachedRestaurants = new HashMap<>();
    }

    public static MapRestaurantCache getInstance() {
        if (instance == null) {
            instance = new MapRestaurantCache();
        }
        return instance;
    }

    public HashMap<String, List<Pair<MarkerOptions, Restaurant>>> getCachedRestaurants() {
        return cachedRestaurants;
    }

    public void cacheRestaurants(String locationKey, List<Pair<MarkerOptions, Restaurant>> restaurantMarkers) {
        cachedRestaurants.put(locationKey, restaurantMarkers);
    }
}