package com.f.mygithub;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.f.mygithub.fragments.LoginFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, LoginFragment.class, null)
                    .commit();
        }
    }
}