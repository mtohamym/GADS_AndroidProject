package com.tohamy.gads;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {
    private final int SPLASH_DISPLAY_LENGTH = 1500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent LeaderBoard = new Intent(SplashActivity.this, LeaderBoradActivity.class);
                startActivity(LeaderBoard);
                finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }

}