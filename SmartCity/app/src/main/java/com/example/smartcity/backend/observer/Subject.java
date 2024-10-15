package com.example.smartcity.backend.observer;

public interface Subject {
    void attach(LikeRestaurantObserver observer);

    void detach(LikeRestaurantObserver observer);

    void notifyAllObservers();
}