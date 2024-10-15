package com.example.smartcity.util;

import com.google.firebase.Timestamp;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;
import java.util.Arrays;

public class FirebaseUtil {

    public static CollectionReference allUserCollectionReference(){
        return FirebaseFirestore.getInstance().collection("users");
    }

    public static CollectionReference allChatWindowCollectionReference(){
        return FirebaseFirestore.getInstance().collection("chatWindows");
    }

    public static String timestampToString(Timestamp timestamp){
        return new SimpleDateFormat("HH:MM").format(timestamp.toDate());
    }

    public static DocumentReference getChatWindows(String chatWindowId){
        return FirebaseFirestore.getInstance().collection("chatWindows").document(chatWindowId);
    }

    public static String getChatWindowId(String userId1, String userId2) {
        String[] users = {userId1, userId2};
        Arrays.sort(users);
        return users[0] + "_" + users[1];
    }

    public static CollectionReference getChatMessages(String chatWindowId){
        return getChatWindows(chatWindowId).collection("Messages");
    }


}
