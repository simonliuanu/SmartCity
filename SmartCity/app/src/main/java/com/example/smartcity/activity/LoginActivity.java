package com.example.smartcity.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.smartcity.R;
import com.example.smartcity.dao.UserDao;
import com.example.smartcity.dao.UserDaoImpl;
import com.example.smartcity.db.SQLiteUtil;

/**
 * This activity use to implement login function
 * @author: u7811526
 */
public class LoginActivity extends AppCompatActivity {

    private EditText loginAccount;
    private EditText loginPwd;
    private Button btnLogin;
    private SQLiteUtil sqLiteUtil;
    private boolean showPwd = false;
    private ImageView btnShowPwd;

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

        // initialize the SQLite database and get the connection of this database
        // once finished in onCreate(), the dao layer is able to operate the database
        sqLiteUtil = new SQLiteUtil(this);
        SQLiteUtil.connected = sqLiteUtil.getWritableDatabase();
        loginAccount = findViewById(R.id.login_account);
        loginPwd = findViewById(R.id.login_pwd);
        btnLogin = findViewById(R.id.login_btn);
        btnShowPwd = findViewById(R.id.login_show_btn);
        btnLogin.setOnClickListener(v -> {
            String account = loginAccount.getText().toString().trim();
            String pwd = loginPwd.getText().toString().trim();
            login(account,pwd);
        });

        /* the image from www.iconfont.cn */
        // set the state of show/hide pwd button
        btnShowPwd.setImageResource(R.mipmap.login_hide_pwd);
        btnShowPwd.setOnClickListener(v -> {
            showPassword();
        });
    }

    /**
     * used to implement user login function
     * @param account user's account
     * @param pwd user's password
     * @author u7811526
     */
    private void login(String account, String pwd) {
        // if the account or password is null, this user won't be allowed to login
        if(account.isEmpty()) {
            Toast.makeText(this,"Username can't be null",Toast.LENGTH_SHORT).show();
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
            Toast.makeText(this,"Wrong username or password",Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * used to show/hide the password test
     */
    public void showPassword() {
        if(!showPwd) {
            btnShowPwd.setImageResource(R.mipmap.login_show_pwd);
            HideReturnsTransformationMethod show = HideReturnsTransformationMethod.getInstance();
            loginPwd.setTransformationMethod(show);
            showPwd = true;
        } else {
            /* the image from www.iconfont.cn */
            btnShowPwd.setImageResource(R.mipmap.login_hide_pwd);
            PasswordTransformationMethod hide = PasswordTransformationMethod.getInstance();
            loginPwd.setTransformationMethod(hide);
            showPwd = false;
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
        // call the dao to check database
        UserDao userDao = new UserDaoImpl();
        return userDao.checkUser(account, pwd);
    }
}