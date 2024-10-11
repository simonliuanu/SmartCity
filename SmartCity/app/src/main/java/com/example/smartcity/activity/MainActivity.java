package com.example.smartcity.activity;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.smartcity.R;
import com.example.smartcity.fragment.HomeFragment;
import com.example.smartcity.fragment.MapFragment;
import com.example.smartcity.fragment.ItemFragment;
import com.example.smartcity.fragment.MeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set WindowInsets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Get BottomNavigationView
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            Fragment selectedFragment = null;

            switch (item.getItemId()) {
                case R.id.navi_home:
                    selectedFragment = new HomeFragment();
                    break;

                case R.id.navi_map:
                    selectedFragment = new MapFragment();
                    break;

                case R.id.navi_item:
                    selectedFragment = new ItemFragment();
                    break;

                case R.id.navi_me:
                    selectedFragment = new MeFragment();
                    break;

                default:
                    return false;
            }

            // Replace the current Fragment
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, selectedFragment)
                    .commit();
            return true;
        });

        if (savedInstanceState == null) {
            bottomNavigationView.setSelectedItemId(R.id.navi_home); // Default to HomeFragment
        }
    }
}
