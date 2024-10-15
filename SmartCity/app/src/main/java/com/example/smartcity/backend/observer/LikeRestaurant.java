package com.example.smartcity.backend.observer;

import android.util.Log;

import com.example.smartcity.backend.entity.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class LikeRestaurant extends ArrayList<Restaurant> implements Subject {

    private static LikeRestaurant singleton = new LikeRestaurant();
    private List<LikeRestaurantObserver> observers = new ArrayList<>(); // 用于存储观察者

    private LikeRestaurant() {}

    public static LikeRestaurant getInstance() {
        return singleton;
    }

    public void attach(LikeRestaurantObserver observer) {
        observers.add(observer);
    }

    public void detach(LikeRestaurantObserver observer) {
        observers.remove(observer);
    }

    /**
     *
     */
    @Override
    public void notifyAllObservers() {
        for (LikeRestaurantObserver observer : observers) {
            observer.update();
            Log.v("Observer","observer state update");
        }
    }

    /**
     * override add() from ArrayList
     * when add new restaurant, notice all observer to update
     * @param restaurant
     * @return
     */
    @Override
    public boolean add(Restaurant restaurant) {
        boolean added = super.add(restaurant);
        if (added) {
            notifyAllObservers();
        }
        return added;
    }

    /**
     * override remove() from ArrayList
     * when remove(unlike) restaurant, notice all observer to update
     * @param restaurant
     * @return
     */
    @Override
    public boolean remove(Object restaurant) {
        boolean removed = super.remove(restaurant);
        if (removed) {
            notifyAllObservers();
        }
        return removed;
    }

}
