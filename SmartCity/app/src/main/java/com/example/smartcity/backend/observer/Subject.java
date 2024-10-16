package com.example.smartcity.backend.observer;

/**
 * author: Shengzong Dai (u7811526)
 */
public interface Subject {

    /**
     * Attach an observer
     * @param observer
     */
    void attach(LikeRestaurantObserver observer);

    /**
     * Detach an observer
     * @param observer
     */
    void detach(LikeRestaurantObserver observer);

    /**
     * Notify all attached observers of a change in the subject's state.
     */
    void notifyAllObservers();
}