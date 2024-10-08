package com.example.smartcity.dataStructure;

import com.example.smartcity.entity.Restaurant;

public class AvlTreeManager {
    private static AvlTree<Restaurant> instance;

    private AvlTreeManager() {
    }

    public static AvlTree<Restaurant> getInstance() {
        if (instance == null) {
            instance = new AvlTree<>();
        }
        return instance;
    }
}
