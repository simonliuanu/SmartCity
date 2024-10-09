package com.example.smartcity.Iterator;

public class RestaurantRepository implements Container{



    @Override
    public RestaurantIterator getIterator() {
        return new RestaurantIterator();
    }
}
