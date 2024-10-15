// UserUtil.java
/*
 * This file is part of the chat functionality implementation,
 * which is adapted from the tutorial series by Bimal Kafle.
 *
 * Sources:
 * YouTube Playlist: https://www.youtube.com/playlist?list=PLgpnJydBcnPB-aQ6P5hWCHBjy8LWZ9x4w
 * GitHub Repository: https://github.com/bimalkaf/Android_Chat_Application
 */

package com.example.smartcity.util;

import android.content.Intent;

import com.example.smartcity.backend.entity.User;

public class UserUtil {
    // Passes a User object's name as an extra in the intent
    public static void passUserAsIntent(Intent intent, User user){
        intent.putExtra("name",user.getName());
    }

    // Passes a username string as an extra in the intent
    public static void passUserNameAsIntent(Intent intent, String userName){
        intent.putExtra("name",userName);
    }

    // Retrieves a User object from the intent using the name extra
    public static User getUserFromIntent(Intent intent){
        User user = new User();
        user.setName(intent.getStringExtra("name"));
        return user;
    }
}
