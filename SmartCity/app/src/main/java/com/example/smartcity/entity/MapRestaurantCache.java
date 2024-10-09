package com.example.smartcity.entity;

import com.google.android.gms.maps.model.MarkerOptions;
import java.util.HashMap;
import java.util.List;

// This cache class is used for the subsequent loading of restaurants near the current location
public class MapRestaurantCache {
    private static MapRestaurantCache instance; // 单例实例
    private HashMap<String, List<MarkerOptions>> cachedRestaurants;

    // 私有构造函数
    private MapRestaurantCache() {
        cachedRestaurants = new HashMap<>();
    }

    // 获取单例实例
    public static MapRestaurantCache getInstance() {
        if (instance == null) {
            instance = new MapRestaurantCache();
        }
        return instance;
    }

    // 获取缓存的餐馆
    public HashMap<String, List<MarkerOptions>> getCachedRestaurants() {
        return cachedRestaurants;
    }
}