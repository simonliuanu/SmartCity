package com.example.smartcity.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.smartcity.R;
import com.example.smartcity.activity.CommentActivity;
import com.example.smartcity.activity.LoginActivity;
import com.example.smartcity.adapter.ItemListAdapter;
import com.example.smartcity.entity.LikeRestaurant;
import com.example.smartcity.entity.Restaurant;

public class MeFragment extends Fragment {
    View meView;
    private ItemListAdapter itemListAdapter;
    private TextView emptyTips;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        meView = inflater.inflate(R.layout.fragment_me, container, false);

        ListView likeList = meView.findViewById(R.id.me_like_list);
        emptyTips = meView.findViewById(R.id.me_empty_tips);

        // 设置点击事件
        likeList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 获取被点击的餐厅对象
                Restaurant selectedRestaurant = itemListAdapter.getItem(position);
                // 启动新的活动
                Intent intent = new Intent(getContext(), CommentActivity.class);
                intent.putExtra("restaurant", selectedRestaurant);
                startActivity(intent);
            }
        });

        LikeRestaurant likeRes = LikeRestaurant.getInstance();

        itemListAdapter = new ItemListAdapter(getContext(), likeRes);

        likeList.setAdapter(itemListAdapter);

        Button logoutBtn = meView.findViewById(R.id.me_logout_btn);

        // back to the login page
        logoutBtn.setOnClickListener(v -> {
            Intent intent = new Intent(meView.getContext(), LoginActivity.class);
            startActivity(intent);
        });


        // TODO: when user empty the favor, this tip won't appear in time
        // have some potential bug, consider to keep or refine
        if(likeRes.isEmpty()) {
            emptyTips.setVisibility(View.VISIBLE);
        } else {
            emptyTips.setVisibility(View.GONE);
        }
        return meView;
    }

}
