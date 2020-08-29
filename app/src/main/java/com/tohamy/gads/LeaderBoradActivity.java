package com.tohamy.gads;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import com.google.android.material.tabs.TabLayout;
import com.tohamy.gads.taps.LearningFragment;
import com.tohamy.gads.taps.SkillFragment;

public class LeaderBoradActivity extends AppCompatActivity implements View.OnClickListener{
    TabLayout tabLayout ;
    ViewPager viewPager ;
    Button SubmitButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leader_borad);
        findId();
        SubmitButton.setOnClickListener(this);




    }
    public void findId () {
        tabLayout = findViewById(R.id.tapLayout);
        viewPager = findViewById(R.id.viewPaged);
        SubmitButton = findViewById(R.id.submitbtn);

        getTaps ();
    }

    public void getTaps () {
        final ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                viewPagerAdapter.addFrag(LearningFragment.getInstance() , "LEARNING LEADERS");
                viewPagerAdapter.addFrag(SkillFragment.getInstance() , "SKILL IQ LEADERS");
                viewPager.setAdapter(viewPagerAdapter);
                tabLayout.setupWithViewPager(viewPager);

            }
        });
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.submitbtn:
                Intent open = new Intent(LeaderBoradActivity.this , Submit.class);
                startActivity(open);
                finish();
                break;}
    }
}