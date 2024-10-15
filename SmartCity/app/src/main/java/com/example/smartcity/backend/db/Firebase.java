package com.example.smartcity.backend.db;

import com.example.smartcity.backend.entity.User;
import com.google.firebase.firestore.FirebaseFirestore;


public class Firebase {

    FirebaseFirestore db = FirebaseFirestore.getInstance();


    public void setupUser() {
        User comp6442 = new User("comp6442@anu.edu.au", "comp6442");
        User comp2100 = new User("comp2100@anu.edu.au", "comp2100");

        db.collection("users").document("comp2100").set(comp2100);
        db.collection("users").document("comp6442").set(comp6442);
    }
}
