package com.example.smartcity.observer;

public interface Subject {
    void attach(LikeRestaurantObserver observer);

    void detach(LikeRestaurantObserver observer);

    void notifyAllObservers();
}