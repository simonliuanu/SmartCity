// FirebaseUtil.java
/*
 * This file is part of the chat functionality implementation,
 * which is adapted from the tutorial series by Bimal Kafle.
 *
 * Sources:
 * YouTube Playlist: https://www.youtube.com/playlist?list=PLgpnJydBcnPB-aQ6P5hWCHBjy8LWZ9x4w
 * GitHub Repository: https://github.com/bimalkaf/Android_Chat_Application
 */

package com.example.smartcity.util;

import com.google.firebase.Timestamp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;
import java.util.Arrays;

public class FirebaseUtil {

    // Returns a reference to the "restaurants" node in Firebase Realtime Database
    public static DatabaseReference getRestaurantReference() {
        return FirebaseDatabase.getInstance().getReference().child("restaurants");
    }

    // Returns a reference to the "users" collection in Firestore
    public static CollectionReference allUserCollectionReference(){
        return FirebaseFirestore.getInstance().collection("users");
    }

    // Returns a reference to the "chatWindows" collection in Firestore
    public static CollectionReference allChatWindowCollectionReference(){
        return FirebaseFirestore.getInstance().collection("chatWindows");
    }

    // Converts a Firestore Timestamp to a formatted string
    public static String timestampToString(Timestamp timestamp){
        return new SimpleDateFormat("MM-dd HH:MM").format(timestamp.toDate());
    }

    // Returns a reference to a specific chat window document in Firestore
    public static DocumentReference getChatWindows(String chatWindowId){
        return FirebaseFirestore.getInstance().collection("chatWindows").document(chatWindowId);
    }

    // Generates a unique chat window ID based on two user IDs
    public static String getChatWindowId(String userId1, String userId2) {
        String[] users = {userId1, userId2};
        Arrays.sort(users);
        return users[0] + "_" + users[1];
    }

    // Returns a reference to the "Messages" subcollection of a specific chat window
    public static CollectionReference getChatMessages(String chatWindowId){
        return getChatWindows(chatWindowId).collection("Messages");
    }


}
