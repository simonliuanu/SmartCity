package com.example.smartcity.Factory;

public class ContentInComment implements CommentItem{
    @Override
    public String getItem() {
        return randomComments[(int) (Math.random() * randomComments.length)];
    }
    String[] randomComments = {"Great food!", "Amazing service!", "Would definitely come again!", "A bit expensive.","I love it!"};
}
