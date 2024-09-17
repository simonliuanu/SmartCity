package com.example.smartcity.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.smartcity.R;

/**
 * This activity
 */
public class LoginActivity extends AppCompatActivity {

    private EditText loginAccount;
    private EditText loginPwd;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        loginAccount = findViewById(R.id.login_account);
        loginPwd = findViewById(R.id.login_pwd);
        btnLogin = findViewById(R.id.login_btn);
        btnLogin.setOnClickListener(v -> {
            String account = loginAccount.getText().toString().trim();
            String pwd = loginPwd.getText().toString().trim();
            login(account,pwd);
        });
    }

    /**
     * used to implement user login function
     * @param account user's account
     * @param pwd user's password
     * @author Shengzong Dai
     * @uid u7811526
     */
    private void login(String account, String pwd) {
        // if the account or password is null, this user won't be allowed to login
        if(account.isEmpty()) {
            Toast.makeText(this,"Account can't be null",Toast.LENGTH_SHORT).show();
            return;
        }
        if(pwd.isEmpty()) {
            Toast.makeText(this,"Password can't be null",Toast.LENGTH_SHORT).show();
            return;
        }

        // jump to main page
        // TODO hard code, need to refine later
        if(userExist(account,pwd)) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(this,"Account or password wrong",Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * used to check if the user exist
     * @param account user's account
     * @param pwd user's password
     * @author Shengzong Dai
     * @uid u7811526
     */
    private boolean userExist(String account, String pwd) {
        // TODO need refine when implement database
        if(account.equals("comp2100@anu.edu.au") && pwd.equals("comp2100")
         || account.equals("comp6442@anu.edu.au") && pwd.equals("comp6442")) return true;
        return false;
    }
}