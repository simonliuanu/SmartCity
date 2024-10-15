package com.example.smartcity.backend.entity;

import com.google.firebase.Timestamp;

public class ChatMessage {
    private String message;
    private String userName;
    private Timestamp timestamp;

    public ChatMessage(){}

    public ChatMessage(String message, String userName, Timestamp timestamp) {
        this.message = message;
        this.userName = userName;
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getUserName() {
        return userName;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
