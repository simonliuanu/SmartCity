package com.example.smartcity.dao;


import static android.content.ContentValues.TAG;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.smartcity.entity.LoginUser;
import com.example.smartcity.entity.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class UserDaoImpl implements UserDao {

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    CollectionReference usersRef = db.collection("users");

    @Override
    public boolean checkUser(User user) {
        Query query = usersRef.whereEqualTo("name", user.getName()).whereEqualTo("pwd", user.getPwd());

        query.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    System.out.println("task successful");
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        System.out.println("the login info is: " + document.getData());
                        LoginUser.setLoginUser(document.toObject(User.class));
                        System.out.println("LoginUser info update");
                    }
                } else {
                    Log.d(TAG, "Error getting documents: ", task.getException());
                }
            }
        });

        boolean successful = query.get().isSuccessful();
        System.out.println("The state of query test " + successful );


        return !LoginUser.isEmpty();
    }
}

