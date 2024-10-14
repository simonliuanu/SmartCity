package com.example.smartcity.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartcity.R;
import com.example.smartcity.adapter.MessageAdapter;
import com.example.smartcity.cache.UserCache;
import com.example.smartcity.entity.ChatMessage;
import com.example.smartcity.entity.ChatWindow;
import com.example.smartcity.entity.User;
import com.example.smartcity.util.FirebaseUtil;
import com.example.smartcity.util.UserUtil;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.Query;

import java.util.Arrays;

public class ChatActivity extends AppCompatActivity {

    User receiverUser;
    String chatWindowId;
    ChatWindow chatWindow;
    MessageAdapter adapter;


    EditText messageInput;
    ImageButton sendBt;
    ImageButton backBt;
    TextView receiverUserName;
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        receiverUser = UserUtil.getUserFromIntent(getIntent());
        chatWindowId = FirebaseUtil.getChatWindowId(UserCache.getInstance().getCurrentUserName(), receiverUser.getName());

        messageInput = findViewById(R.id.message_input);
        sendBt = findViewById(R.id.send_btn);
        backBt = findViewById(R.id.back_btn);
        receiverUserName = findViewById(R.id.receiver_user_name);
        recyclerView = findViewById(R.id.chat_view);

        backBt.setOnClickListener((v -> {
            Intent intent = new Intent(ChatActivity.this, MainActivity.class);
            intent.putExtra("targetFragment", "ChatFragment");
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        }));
        receiverUserName.setText(receiverUser.getName());

        getChatWindow();

        sendBt.setOnClickListener((v -> {
            String message = messageInput.getText().toString().trim();
            if(message.isEmpty())
                return;
            seedMessage(message);
        }));

        getMessageView();
    }

    void getChatWindow(){
        FirebaseUtil.getChatWindows(chatWindowId).get().addOnCompleteListener(task ->{
            if(task.isSuccessful()){
                chatWindow = task.getResult().toObject(ChatWindow.class);
                if(chatWindow == null){
                    chatWindow = new ChatWindow(
                            chatWindowId,
                            Arrays.asList(UserCache.getInstance().getCurrentUserName(), receiverUser.getName()),
                            Timestamp.now(),
                            ""
                    );
                    FirebaseUtil.getChatWindows(chatWindowId).set(chatWindow);
                }
            }
        });
    }

    void seedMessage(String message){

        chatWindow.setTimestamp(Timestamp.now());
        chatWindow.setLastMessageUserName(UserCache.getInstance().getCurrentUserName());
        chatWindow.setLastMessage(message);
        FirebaseUtil.getChatWindows(chatWindowId).set(chatWindow);

        ChatMessage chatMessage = new ChatMessage(message, UserCache.getInstance().getCurrentUserName(),Timestamp.now());
        FirebaseUtil.getChatMessages(chatWindowId).add(chatMessage).addOnCompleteListener(new OnCompleteListener<DocumentReference>(){
            public void onComplete(@NonNull Task<DocumentReference> task) {
                if(task.isSuccessful()){
                    messageInput.setText("");
                }
            }
        });
    }

    void getMessageView(){
        Query query = FirebaseUtil.getChatMessages(chatWindowId)
                .orderBy("timestamp", Query.Direction.DESCENDING);


        FirestoreRecyclerOptions<ChatMessage> options = new FirestoreRecyclerOptions.Builder<ChatMessage>()
                .setQuery(query,ChatMessage.class).build();

        adapter = new MessageAdapter(options,getApplicationContext());
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setReverseLayout(true);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        adapter.startListening();
        adapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onItemRangeInserted(int positionStart, int itemCount) {
                super.onItemRangeInserted(positionStart, itemCount);
                recyclerView.smoothScrollToPosition(0);
            }
        });
    }
}

