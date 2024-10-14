package com.example.smartcity.factory;

public class UsernameInComment implements CommentItem{
    @Override
    public String getItem() {
        return randomUserName[(int) (Math.random() * randomUserName.length)];
    }
    String[] randomUserName = {"Mike Smith", "Simon", "Lily Brown", "Emma", "Noah Wilson", "Lucas Lee",
            "Sophia", "Ava Anderson", "Oliver Thomas", "Ethan", "Mia White",
            "Isabella Harris", "Liam", "Amelia Thompson", "Jackson Garcia", "Harper",
            "Aiden Robinson", "Charlotte Clark", "Caleb", "Grace Walker"};
}
