// ChatMessage.java
/*
 * This file is part of the chat functionality implementation,
 * which is adapted from the tutorial series by Bimal Kafle.
 *
 * Sources:
 * YouTube Playlist: https://www.youtube.com/playlist?list=PLgpnJydBcnPB-aQ6P5hWCHBjy8LWZ9x4w
 * GitHub Repository: https://github.com/bimalkaf/Android_Chat_Application
 */

package com.example.smartcity.entity;

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
