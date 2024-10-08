package com.example.smartcity.Service;

import java.util.Iterator;

public class RestaurantRepository implements Container{



    @Override
    public RestaurantIterator getIterator() {
        return new RestaurantIterator();
    }
}
