package com.cookandroid.and0801_02_activityone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    Button btnSecond;
    TextView txtContent2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        setTitle("[이혜령]두 번째 화면");
        btnSecond = findViewById(R.id.btnSecond);
        txtContent2 = findViewById(R.id.txtContent2);
        Intent in = getIntent();
        String str = in.getStringExtra("Content");
        txtContent2.setText("넘겨받은 내용: "+str);
        btnSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}