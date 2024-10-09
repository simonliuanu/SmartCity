package com.example.smartcity.dao;

import androidx.annotation.NonNull;

import com.example.smartcity.entity.Restaurant;
import com.example.smartcity.util.DataCallback;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ItemDaoImpl implements ItemDao{

    private static final int PER_PAGE_LIMITS = 12;
    private final DatabaseReference restaurantRef;
    private final FirebaseDatabase database;

    public ItemDaoImpl() {
        database = FirebaseDatabase.getInstance();
        restaurantRef = database.getReference().child("restaurants");
    }

    public void initialItemList(DataCallback<List<Restaurant>> callback) {
        // to get the initial data from firebase
        Query resQuery = restaurantRef.orderByKey().limitToFirst(PER_PAGE_LIMITS);

        resQuery.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                List<Restaurant> resList = new ArrayList<>();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Restaurant value = snapshot.getValue(Restaurant.class);
                    resList.add(value);
                }
                callback.onSuccess(resList);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                callback.onFailure(error.getMessage());
            }
        });
    }
}
