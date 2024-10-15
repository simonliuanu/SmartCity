// ChatFragment.java
/*
 * This file is part of the chat functionality implementation,
 * which is adapted from the tutorial series by Bimal Kafle.
 *
 * Sources:
 * YouTube Playlist: https://www.youtube.com/playlist?list=PLgpnJydBcnPB-aQ6P5hWCHBjy8LWZ9x4w
 * GitHub Repository: https://github.com/bimalkaf/Android_Chat_Application
 */

package com.example.smartcity.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartcity.R;
import com.example.smartcity.activity.SearchUserActivity;
import com.example.smartcity.adapter.RecentChatAdapter;
import com.example.smartcity.cache.UserCache;
import com.example.smartcity.entity.ChatWindow;
import com.example.smartcity.util.FirebaseUtil;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.Query;

public class ChatFragment extends Fragment {

    RecyclerView recyclerView;
    RecentChatAdapter adapter;
    ImageButton searchButton;

    // Inflate the layout and set up the RecyclerView
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)  {
        View view = inflater.inflate(R.layout.fragment_chat, container, false);
        recyclerView = view.findViewById(R.id.user_view);
        searchButton = view.findViewById(R.id.search_user_btn);

        // Call method to configure RecyclerView
        setupChatRecyclerView();

        // Set up click listener for the search button
        searchButton.setOnClickListener((v)->{
            Intent intent = new Intent(this.getContext(), SearchUserActivity.class);
            startActivity(intent);
        });

        return view;
    }

    // Configure RecyclerView to display recent chat windows
    void setupChatRecyclerView(){
        Query query = FirebaseUtil.allChatWindowCollectionReference()
                .whereArrayContains("userNames", UserCache.getInstance().getCurrentUserName())
                .orderBy("timestamp", Query.Direction.DESCENDING);

        FirestoreRecyclerOptions<ChatWindow> options = new FirestoreRecyclerOptions.Builder<ChatWindow>()
                .setQuery(query,ChatWindow.class).build();
        adapter = new RecentChatAdapter(options,getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        adapter.startListening();

    }

    @Override
    public void onStart() {
        super.onStart();
        if(adapter!=null)
            adapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        if(adapter!=null)
            adapter.stopListening();
    }

    @Override
    public void onResume() {
        super.onResume();
        if(adapter!=null)
            adapter.startListening();
    }

}
