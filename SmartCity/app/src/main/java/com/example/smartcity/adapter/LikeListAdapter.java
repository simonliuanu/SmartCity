package com.example.smartcity.adapter;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

import com.example.smartcity.R;
import com.example.smartcity.entity.Restaurant;

import java.util.List;

public class LikeListAdapter extends ArrayAdapter<Restaurant> {

    private List<Restaurant> likeList;

    private Context context;

    public LikeListAdapter(@NonNull Context context, List<Restaurant> likeList) {
        super(context, R.layout.item_list,likeList);
        this.context = context;
        this.likeList = likeList;
    }


}
