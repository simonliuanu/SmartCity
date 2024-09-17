package com.example.smartcity.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLiteUtil extends SQLiteOpenHelper {

    private static final String DBNAME = "smart_city.db";
    // evert time when change the structure of data table, the version should ++
    private static final int VERSION = 2;

    public static SQLiteDatabase connected;

    public SQLiteUtil(@Nullable Context context) {
        super(context, DBNAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.delete("user_info",null,null);

        db.execSQL("insert into user_info (user_account, user_pwd) values (?,?)",
                new String[] {"comp6442@anu.edu.au","comp6442"});

        db.execSQL("insert into user_info (user_account, user_pwd) values (?,?)",
                new String[] {"comp2100@anu.edu.au","comp2100"});
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        onCreate(db);
    }
}
