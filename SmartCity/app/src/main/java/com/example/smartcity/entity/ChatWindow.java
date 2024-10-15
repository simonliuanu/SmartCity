// ChatWindow.java
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

import java.util.List;

public class ChatWindow {
    String chatWindowId;
    List<String> userNames;
    Timestamp timestamp;
    String lastMessageUserName;
    String lastMessage;


    public ChatWindow(){}

    public ChatWindow(String chatWindowId, List<String> userNames, Timestamp timestamp, String lastMessageUserName) {
        this.chatWindowId = chatWindowId;
        this.userNames = userNames;
        this.timestamp = timestamp;
        this.lastMessageUserName = lastMessageUserName;
    }

    public String getChatWindowId() {
        return chatWindowId;
    }

    public List<String> getUserNames() {
        return userNames;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public String getLastMessageUserName() {
        return lastMessageUserName;
    }

    public String getLastMessage() {
        return lastMessage;
    }
    public void setChatWindowId(String chatWindowId) {
        this.chatWindowId = chatWindowId;
    }

    public void setUserNames(List<String> userIds) {
        this.userNames = userIds;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public void setLastMessageUserName(String lastMessageUserName) {
        this.lastMessageUserName = lastMessageUserName;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }
}
