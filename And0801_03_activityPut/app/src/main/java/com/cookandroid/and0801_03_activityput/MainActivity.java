package com.cookandroid.and0801_03_activityput;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edtName, edtAge;
    CheckBox chkGame, chkMusic, chkSports;
    Button btnOpen;
    String name;
    int age;
    ArrayList<String> hobby = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("[이혜령]ActivityPro01");
        edtName = findViewById(R.id.edtName);
        edtAge = findViewById(R.id.edtAge);
        chkGame = findViewById(R.id.chkGame);
        chkMusic = findViewById(R.id.chkMusic);
        chkSports = findViewById(R.id.chkSports);
        btnOpen = findViewById(R.id.btnOpen);

        chkGame.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    hobby.add(chkGame.getText().toString());
                } else {
                    hobby.remove(hobby.indexOf(chkGame.getText().toString()));
                }
            }
        });
        chkMusic.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    hobby.add(chkMusic.getText().toString());
                } else {
                    hobby.remove(hobby.indexOf(chkMusic.getText().toString()));
                }
            }
        });
        chkSports.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    hobby.add(chkSports.getText().toString());
                } else {
                    hobby.remove(hobby.indexOf(chkSports.getText().toString()));
                }
            }
        });
        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = edtName.getText().toString();
                age = Integer.parseInt(edtAge.getText().toString());
                Intent in = new Intent(getApplicationContext(), SecondActivity.class);
                in.putExtra("name", name);
                in.putExtra("age", age);
                in.putExtra("hobby", hobby);
                startActivity(in);
            }
        });
    }
}