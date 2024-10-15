package com.example.smartcity.backend.dao;

import com.example.smartcity.backend.entity.User;
import com.example.smartcity.util.FirestoreCallback;

public interface UserDao {
    void checkUser(User user, FirestoreCallback callback);
}
