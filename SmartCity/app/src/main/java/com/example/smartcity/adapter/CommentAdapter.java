package com.example.smartcity.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartcity.R;
import com.example.smartcity.entity.Comment;

import java.util.List;

/**
 * @author Yuheng Li
 */
public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.CommentViewHolder> {

    private List<Comment> commentList;
    private String currentUsername;
    public CommentAdapter(List<Comment> commentList, String currentUsername) {
        this.commentList = commentList;
        this.currentUsername = currentUsername;
    }

    @NonNull
    @Override
    public CommentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.comment_item, parent, false);
        return new CommentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentViewHolder holder, int position) {
        Comment comment = commentList.get(position);
        String usernameToDisplay = comment.getUsername().equals(currentUsername) ? "Me" : comment.getUsername();
        holder.textViewUserName.setText(usernameToDisplay);
        holder.textViewComment.setText(comment.getContent());
        holder.textViewDate.setText(comment.getDate());
    }

    @Override
    public int getItemCount() {
        return commentList.size();
    }

    static class CommentViewHolder extends RecyclerView.ViewHolder {
        TextView textViewComment;
        TextView textViewUserName;
        TextView textViewDate;

        public CommentViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewUserName = itemView.findViewById(R.id.textView_username);
            textViewComment = itemView.findViewById(R.id.textView_comment);
            textViewDate = itemView.findViewById(R.id.textView_date);
        }
    }
}
