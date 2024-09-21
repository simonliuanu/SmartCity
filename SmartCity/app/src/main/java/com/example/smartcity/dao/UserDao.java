package com.example.smartcity.dao;

import com.example.smartcity.entity.User;
import com.example.smartcity.util.FirestoreCallback;

public interface UserDao {
    void checkUser(User user, FirestoreCallback callback);
}
