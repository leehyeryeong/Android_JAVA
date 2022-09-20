package com.cookandroid.and0801_03_activityput;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    Button btn2;
    TextView txtContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        setTitle("[이혜령]두 번째 화면");
        btn2 = findViewById(R.id.btn2);
        txtContent = findViewById(R.id.txtContent);
        Intent in = getIntent();
        String name = in.getStringExtra("name");
        int age = in.getIntExtra("age", 0);
        ArrayList<String> hobby = in.getStringArrayListExtra("hobby");
        txtContent.setText("이름: "+name+"\n나이: "+age+"\n취미: ");
        for(String h:hobby) {
            txtContent.setText(txtContent.getText().toString()+h+" ");
        }
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}