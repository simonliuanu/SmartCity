package com.example.smartcity.Service;

import androidx.annotation.NonNull;

import com.example.smartcity.dataStructure.AvlTree;
import com.example.smartcity.dataStructure.AvlTreeManager;
import com.example.smartcity.entity.Restaurant;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class RestaurantIterator implements Iterator<List<Restaurant>> {

    private int curPage = 1;
    private static final int PER_PAGE_LIMITS = 12;
    // TODO: hard core
    private static final int TOTAL_DATA = 3502;
    private DatabaseReference restaurantRef;
    AvlTree<Restaurant> instance;

    public RestaurantIterator() {
        restaurantRef = FirebaseDatabase.getInstance().getReference().child("restaurants");
        instance = AvlTreeManager.getInstance();
    }

    @Override
    public boolean hasNext() {
        return curPage * PER_PAGE_LIMITS <= TOTAL_DATA;
    }

    @Override
    public List<Restaurant> next() {
        List<Restaurant> nextPageRes = instance.toList().subList(curPage * PER_PAGE_LIMITS, ++curPage * PER_PAGE_LIMITS);
        curPage++;
        return nextPageRes;
    }

    // 定义回调接口，用于通知结果
    public interface DataCallback<T> {
        void onSuccess(T result);

        void onFailure(String error);
    }
}
