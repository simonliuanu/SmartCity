package com.example.smartcity.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.smartcity.R;
import com.example.smartcity.adapter.ItemListAdapter;
import com.example.smartcity.entity.Restaurant;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ItemFragment extends Fragment {

    View itemView;
    private int curPage = 0;
    private static final int PER_PAGE_LIMITS = 12;
    private boolean isLoading = false;
    private boolean isLastPage = false;
    private List<Restaurant> resList;
    private ItemListAdapter itemListAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        itemView = inflater.inflate(R.layout.fragment_item, container, false);

        // get the food list
        ListView listView = itemView.findViewById(R.id.item_list);


        // for restaurant test
        // TODO need optimize later, it's a hard code
        List<Restaurant> resList = new ArrayList<>();
        ItemListAdapter itemListAdapter = new ItemListAdapter(getContext(), resList);
        Query resReference = FirebaseDatabase.getInstance().getReference().child("restaurants").limitToFirst(25);

        listView.setAdapter(itemListAdapter);

        resReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                resList.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Restaurant value = snapshot.getValue(Restaurant.class);
                    resList.add(value);
                }
                itemListAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("FirebaseError", "Database error: " + error.getMessage());
            }
        });

        return itemView;
    }
}
