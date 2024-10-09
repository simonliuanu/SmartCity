package com.example.smartcity.util;

/**
 * This call back function used to implement
 * the restaurant list initializing
 * @param <T>
 */
public interface DataCallback<T> {
    void onSuccess(T result);

    void onFailure(String error);
}