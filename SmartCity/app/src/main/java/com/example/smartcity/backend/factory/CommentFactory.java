package com.example.smartcity.backend.factory;

public class CommentFactory {
    public CommentItem getItem(String item){
        if (item == null){
            return null;
        }
        if (item.equalsIgnoreCase("Comment")){
            return new ContentInComment();
        } else if (item.equalsIgnoreCase("username")) {
            return new UsernameInComment();
        }
        return null;
    }
}
