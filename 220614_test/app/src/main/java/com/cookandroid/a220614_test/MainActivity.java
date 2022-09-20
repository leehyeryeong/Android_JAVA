package com.cookandroid.a220614_test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnCheck, btnCancel, btnAct;
    RadioGroup rg;
    RadioButton rd2, rd3;
    CheckBox chkAct;
    String grade;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("[이혜령]project0614");
        btnCheck = findViewById(R.id.btnCheck);
        btnCancel = findViewById(R.id.btnCancel);
        btnAct = findViewById(R.id.btnAct);
        rg = findViewById(R.id.rg);
        rd2 = findViewById(R.id.rd2);
        rd3 = findViewById(R.id.rd3);
        chkAct = findViewById(R.id.chkAct);
        chkAct.setChecked(true);
        chkAct.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b==true) {
                    btnAct.setEnabled(true);
                } else {
                    btnAct.setEnabled(false);
                } //end of if
            } //end of onCheckedChanged
        });
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i==0) grade="2학년";
                else grade="3학년";
                //////////////////////////////////////////////////////
                if(radioGroup.getCheckedRadioButtonId()==R.id.rd2) {
                    grade = rd2.getText().toString();
                } else {
                    grade = rd3.getText().toString();
                } //end of if
            } //end of onCheckedChanged
        });
        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "선택한 학년: "+grade, Toast.LENGTH_SHORT).show();
            } //end of onClick
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rg.clearCheck();
                Toast.makeText(getApplicationContext(),"선택 취소함", Toast.LENGTH_SHORT).show();
            } //end of onClick
        });
    } //end of onCreate
} //end of MainActivity