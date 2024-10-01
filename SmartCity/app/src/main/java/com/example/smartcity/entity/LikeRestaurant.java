package com.example.smartcity.entity;

import java.util.ArrayList;

public class LikeRestaurant extends ArrayList<Restaurant> {

    private static LikeRestaurant singleton = new LikeRestaurant();

    private LikeRestaurant() {}

    public static LikeRestaurant getInstance() {
        return singleton;
    }
}
