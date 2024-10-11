package com.example.smartcity.entity;

import com.example.smartcity.observer.LikeRestaurant;

public class User {

    private static User loginUser = new User();
    private String name;
    private String pwd;

    private User() {
    }

    public User(String name, String pwd) {
        this.name = name;
        this.pwd = pwd;
    }

    public static User getInstance() {
        return loginUser;
    }

    public void updateLoginUserState(String name) {
        loginUser.setName(name);
    }

    public String getLoginUserName() {
        return loginUser.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
