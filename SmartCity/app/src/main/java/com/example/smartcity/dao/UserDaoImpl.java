package com.example.smartcity.dao;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.smartcity.db.SQLiteUtil;


public class UserDaoImpl implements UserDao{

    private SQLiteDatabase db = SQLiteUtil.connected;

    /**
     * Use to check if the user account and pwd correct or not, the account and pwd must fit
     * @param account
     * @param pwd
     * @return if the input parameters are correct, the table will get 1 message, else 0
     */
    @Override
    public boolean checkUser(String account, String pwd) {
        @SuppressLint("Recycle") Cursor cursor = db.rawQuery("select * from user_info where user_account = ? and user_pwd = ?", new String[]{account, pwd});
        return cursor.getCount() > 0;
    }
}
