package com.example.smartcity.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.smartcity.R;
//import com.example.smartcity.Service.RestaurantIterator;
import com.example.smartcity.Iterator.RestaurantIterator;
import com.example.smartcity.Iterator.RestaurantRepository;
import com.example.smartcity.activity.CommentActivity;
import com.example.smartcity.adapter.ItemListAdapter;
import com.example.smartcity.entity.Restaurant;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ItemFragment extends Fragment implements AbsListView.OnScrollListener, AdapterView.OnItemClickListener {

    View itemView;
    private int curPage = 1;
    private static final int PER_PAGE_LIMITS = 12;
    private List<Restaurant> resList = new ArrayList<>();
    private ItemListAdapter itemListAdapter;
    private View moreDataView;
    private ProgressBar morePg;
    private Button moreBtn;
    private RestaurantRepository restaurantRepository;
    private RestaurantIterator iterator;
    //private RestaurantIterator restaurantItr = new RestaurantIterator();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        itemView = inflater.inflate(R.layout.fragment_item, container, false);


        ListView listView = itemView.findViewById(R.id.item_list);

        //set listener for every item in the list
        listView.setOnItemClickListener(this);

        // Implement the load more data page
        moreDataView = getLayoutInflater().inflate(R.layout.moredata, null);

        moreBtn = moreDataView.findViewById(R.id.more_data_btn);
        morePg = moreDataView.findViewById(R.id.more_data_progress);

        // TODO : here is a deprecated class
        Handler handler = new Handler();

        // Initialize the page
        itemListAdapter = new ItemListAdapter(getContext(), resList);
        listView.addFooterView(moreDataView);
        listView.setAdapter(itemListAdapter);
        listView.setOnScrollListener(this);

        Query resQuery = FirebaseDatabase.getInstance().
                getReference()
                .child("restaurants")
                .orderByKey()
                .limitToFirst(PER_PAGE_LIMITS);

        resQuery.addValueEventListener(new ValueEventListener() {
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

        restaurantRepository = new RestaurantRepository();
        iterator = restaurantRepository.getIterator();

        // once user click the more button, it will load more restaurant
        moreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                morePg.setVisibility(View.VISIBLE);
                moreBtn.setVisibility(View.GONE);

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(iterator.hasNext()) {
                            loadMoreData();
                            morePg.setVisibility(View.GONE);
                            moreBtn.setVisibility(View.VISIBLE);
                        } else {
                            Toast.makeText(getContext(), "No more data", Toast.LENGTH_SHORT).show();
                            morePg.setVisibility(View.GONE);
                            moreBtn.setVisibility(View.GONE);
                        }
                        itemListAdapter.notifyDataSetChanged();
                    }
                }, 2000);
            }
        });

        return itemView;
    }

    @Override
    public void onScrollStateChanged(AbsListView absListView, int i) {

    }

    @Override
    public void onScroll(AbsListView absListView, int i, int i1, int i2) {
    }

    public void loadMoreData() {
            resList.addAll(iterator.next());
    }

    /**@author Yuheng Li
     * go to comment page
     * @param adapterView
     * @param view
     * @param i
     * @param l
     */
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(this.getContext(), CommentActivity.class);
        Restaurant selectedRestaurant = resList.get(i);
        intent.putExtra("restaurant", selectedRestaurant);
        startActivity(intent);
    }
}

