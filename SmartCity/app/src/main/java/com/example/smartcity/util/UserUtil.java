package com.example.smartcity.util;

import android.content.Intent;

import com.example.smartcity.entity.User;

public class UserUtil {
    public static void passUserAsIntent(Intent intent, User user){
        intent.putExtra("name",user.getName());
    }

    public static void passUserNameAsIntent(Intent intent, String userName){
        intent.putExtra("name",userName);
    }


    public static User getUserFromIntent(Intent intent){
        User user = new User();
        user.setName(intent.getStringExtra("name"));
        return user;
    }
}
