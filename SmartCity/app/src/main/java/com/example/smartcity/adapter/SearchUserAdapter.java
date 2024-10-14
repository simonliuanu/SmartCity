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
import com.example.smartcity.entity.User;
import com.example.smartcity.util.UserUtil;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class SearchUserAdapter extends FirestoreRecyclerAdapter<User, SearchUserAdapter.UserView> {

    Context context;

    public SearchUserAdapter(@NonNull FirestoreRecyclerOptions<User> options, Context context) {
        super(options);
        this.context = context;
    }

    @Override
    protected void onBindViewHolder(@NonNull UserView userView, int position, @NonNull User user) {
        userView.username.setText(user.getName());

        if (user.getName().equals(UserCache.getInstance().getCurrentUserName())){
            userView.username.setText(user.getName() + "(Me)");
        }

        userView.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, ChatActivity.class);
            UserUtil.passUserAsIntent(intent,user);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        });
    }

    @NonNull
    @Override
    public UserView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.search_user_view,parent,false);
        return new UserView(view);
    }

    class UserView extends RecyclerView.ViewHolder{
        TextView username;

        public UserView(@NonNull View itemView) {
            super(itemView);
            username = itemView.findViewById(R.id.user_name_text);
        }
    }
}