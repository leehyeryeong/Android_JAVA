package com.cookandroid.ex01_checktest;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    CheckBox chkEnable, chkVisible, chkRotation;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("이혜령");
        chkEnable = findViewById(R.id.chkEnable);
        chkVisible = findViewById(R.id.chkVisible);
        chkRotation = findViewById(R.id.chkRotation);
        btn = findViewById(R.id.btn);
        chkEnable.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) btn.setEnabled(true);
                else btn.setEnabled(false);
            } //end of onCheckedChanged
        });
        chkVisible.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) btn.setVisibility(View.VISIBLE);
                else btn.setVisibility(View.INVISIBLE);
            } //end of onCheckedChanged
        });
        chkRotation.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) btn.setRotation(45);
                else btn.setRotation(0);
            } //end of onCheckedChanged
        });
    } //end of onCreate
} //end of MainActivity