package com.example.smartcity.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.smartcity.R;
import com.example.smartcity.activity.LoginActivity;
import com.example.smartcity.adapter.ItemListAdapter;
import com.example.smartcity.entity.LikeRestaurant;

public class MeFragment extends Fragment {


    View meView;
    private ItemListAdapter itemListAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        meView = inflater.inflate(R.layout.fragment_me, container, false);

        ListView likeList = meView.findViewById(R.id.me_like_list);

        LikeRestaurant likeRes = LikeRestaurant.getInstance();

        itemListAdapter = new ItemListAdapter(getContext(), likeRes);

        likeList.setAdapter(itemListAdapter);

        Button logoutBtn = meView.findViewById(R.id.me_logout_btn);

        // back to the login page
        logoutBtn.setOnClickListener(v -> {
            Intent intent = new Intent(meView.getContext(), LoginActivity.class);
            startActivity(intent);
        });

        return meView;
    }
}
