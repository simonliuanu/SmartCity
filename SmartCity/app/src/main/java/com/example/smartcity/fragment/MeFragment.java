package com.example.smartcity.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.smartcity.R;
import com.example.smartcity.activity.LoginActivity;

public class MeFragment extends Fragment {


    View meView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        meView = inflater.inflate(R.layout.fragment_me, container, false);

        Button logoutBtn = meView.findViewById(R.id.me_logout_btn);

        // back to the login page
        logoutBtn.setOnClickListener(v -> {
            Intent intent = new Intent(meView.getContext(), LoginActivity.class);
            startActivity(intent);
        });

        return meView;
    }
}
