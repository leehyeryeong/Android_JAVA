package com.cookandroid.androidproject_accountbook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    public class Mainpage extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            tablay = findViewById(R.id.tabLay);
            viewPager = findViewById(R.id.viewPager);
            fragAdt = new FragmentAdapter(getSupportFragmentManager());
            viewPager.setAdapter(fragAdt);
            tabLay.setupWithViewPager(viewPager);
            tabLay.getTabAt(1).setText("입금 내역");
            tabLay.getTabAt(2).setText("지출 내역");
        }
    }
}