package com.example.smartcity.entity;

public class UserState {

    private static boolean userState = false;

    private UserState() {
    }

    public static void setLoginUser(boolean state) {
        userState = state;
    }

}
