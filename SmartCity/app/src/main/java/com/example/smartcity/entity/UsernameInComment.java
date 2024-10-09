package com.example.smartcity.entity;

public class UsernameInComment implements CommentItem{
    @Override
    public String getItem() {
        return randomUserName[(int) (Math.random() * randomUserName.length)];
    }
    String[] randomUserName = {"Mike","Simon","Jack","James","Jordan"};
}
