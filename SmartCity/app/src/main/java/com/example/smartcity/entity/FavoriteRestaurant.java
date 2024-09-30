package com.example.smartcity.entity;

import java.util.ArrayList;

public class FavoriteRestaurant extends ArrayList<Restaurant> {

    private static FavoriteRestaurant singleton = new FavoriteRestaurant();

    private FavoriteRestaurant() {}

    public static FavoriteRestaurant getInstance() {
        return singleton;
    }
}
