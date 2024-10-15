// RecentChatAdapter.java
/*
 * This file is part of the chat functionality implementation,
 * which is adapted from the tutorial series by Bimal Kafle.
 *
 * Sources:
 * YouTube Playlist: https://www.youtube.com/playlist?list=PLgpnJydBcnPB-aQ6P5hWCHBjy8LWZ9x4w
 * GitHub Repository: https://github.com/bimalkaf/Android_Chat_Application
 */

package com.example.smartcity.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartcity.R;
import com.example.smartcity.activity.ChatActivity;
import com.example.smartcity.cache.UserCache;
import com.example.smartcity.entity.ChatWindow;
import com.example.smartcity.util.FirebaseUtil;
import com.example.smartcity.util.UserUtil;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class RecentChatAdapter extends FirestoreRecyclerAdapter<ChatWindow, RecentChatAdapter.ChatWindowView> {

    Context context;

    public RecentChatAdapter(@NonNull FirestoreRecyclerOptions<ChatWindow> options, Context context) {
        super(options);
        this.context = context;
    }

    @Override
    protected void onBindViewHolder(@NonNull ChatWindowView chatWindowView, int position, @NonNull ChatWindow chatWindow) {
        String receiverUserName;

        // Determine the receiver's username based on the current user's name
        if(chatWindow.getUserNames().get(0).equals(UserCache.getInstance().getCurrentUserName())){
            receiverUserName = chatWindow.getUserNames().get(1);
        }else{
            receiverUserName = chatWindow.getUserNames().get(0);
        }

        // Bind data to the views
        chatWindowView.username.setText(receiverUserName);
        chatWindowView.lastMessage.setText(chatWindow.getLastMessage());
        chatWindowView.lastMessageTime.setText(FirebaseUtil.timestampToString(chatWindow.getTimestamp()));

        // Set a click listener to open the chat activity when a chat item is clicked
        chatWindowView.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, ChatActivity.class);
            UserUtil.passUserNameAsIntent(intent,receiverUserName);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        });
    }

    @NonNull
    @Override
    public ChatWindowView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recent_chat_view,parent,false);
        return new ChatWindowView(view);
    }

    class ChatWindowView extends RecyclerView.ViewHolder{
        TextView username;
        TextView lastMessage;
        TextView lastMessageTime;

        public ChatWindowView(@NonNull View itemView) {
            super(itemView);
            username = itemView.findViewById(R.id.user_name_text);
            lastMessage = itemView.findViewById(R.id.last_message);
            lastMessageTime = itemView.findViewById(R.id.last_message_time);
        }
    }
}
