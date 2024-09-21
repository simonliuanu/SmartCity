package com.example.smartcity.entity;

public class LoginUser {

    private static User loginUser = null;

    private LoginUser() {
    }

    public static User getInstance() {
        return loginUser;
    }

    public static void setLoginUser(User user) {
        loginUser = user;

    }

    public static boolean isEmpty() {
        if(loginUser != null) {
            System.out.println("The info of login user = " + loginUser.getName() + loginUser.getPwd());
        } else {
            System.out.println("LoginUser is null");
        }

        return loginUser == null;
    }
}
