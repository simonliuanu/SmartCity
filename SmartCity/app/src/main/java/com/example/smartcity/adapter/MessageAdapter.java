package com.example.smartcity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartcity.R;
import com.example.smartcity.cache.UserCache;
import com.example.smartcity.entity.ChatMessage;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class MessageAdapter extends FirestoreRecyclerAdapter<ChatMessage, MessageAdapter.ChatView> {

    Context context;

    public MessageAdapter(@NonNull FirestoreRecyclerOptions<ChatMessage> options, Context context) {
        super(options);
        this.context = context;
    }

    @Override
    protected void onBindViewHolder(@NonNull ChatView chatView, int position, @NonNull ChatMessage message) {
        if(message.getUserName().equals(UserCache.getInstance().getCurrentUserName())){
            chatView.leftChatLayout.setVisibility(View.GONE);
            chatView.rightChatLayout.setVisibility(View.VISIBLE);
            chatView.rightChatTextview.setText(message.getMessage());
        }else{
            chatView.rightChatLayout.setVisibility(View.GONE);
            chatView.leftChatLayout.setVisibility(View.VISIBLE);
            chatView.leftChatTextview.setText(message.getMessage());
        }
    }

    @NonNull
    @Override
    public ChatView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.message_view,parent,false);
        return new ChatView(view);
    }

    class ChatView extends RecyclerView.ViewHolder{
        LinearLayout leftChatLayout,rightChatLayout;
        TextView leftChatTextview,rightChatTextview;

        public ChatView(@NonNull View itemView) {
            super(itemView);
            leftChatLayout = itemView.findViewById(R.id.left_chat_layout);
            rightChatLayout = itemView.findViewById(R.id.right_chat_layout);
            leftChatTextview = itemView.findViewById(R.id.left_chat_textview);
            rightChatTextview = itemView.findViewById(R.id.right_chat_textview);
        }
    }
}