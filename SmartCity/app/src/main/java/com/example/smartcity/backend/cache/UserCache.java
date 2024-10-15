package com.example.smartcity.backend.cache;

// This cache class is used for the store of current user
public class UserCache {
    private static UserCache instance;
    private String currentUserName;

    private UserCache() {
    }

    public static UserCache getInstance() {
        if (instance == null) {
            instance = new UserCache();
        }
        return instance;
    }

    public String getCurrentUserName() {
        return currentUserName;
    }

    public void setCurrentUserName(String userName) {
        this.currentUserName = userName;
    }

    public void clearUserName() {
        this.currentUserName = null;
    }
}
