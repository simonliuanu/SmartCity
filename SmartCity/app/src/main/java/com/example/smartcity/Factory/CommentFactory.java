package com.example.smartcity.Factory;

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
