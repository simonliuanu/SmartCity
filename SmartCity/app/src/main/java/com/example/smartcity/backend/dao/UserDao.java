package com.example.smartcity.backend.dao;

import com.example.smartcity.backend.entity.User;
import com.example.smartcity.util.FirestoreCallback;

public interface UserDao {

    /**
     * This method used to check if the user exist
     * in data base
     * @param user login user
     * @param callback callback function, use to asynchronously process firebase callback data
     * @author Shengzong Dai (u7811526)
     */
    void checkUser(User user, FirestoreCallback callback);
}
