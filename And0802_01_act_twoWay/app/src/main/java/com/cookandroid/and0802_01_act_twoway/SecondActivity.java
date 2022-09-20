package com.cookandroid.and0802_01_act_twoway;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {
    Button btnBack;
    int total = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        btnBack = findViewById(R.id.btnBack);
        Intent in = getIntent();
        int x = in.getIntExtra("Num1", 0);
        int y = in.getIntExtra("Num2", 0);
        String op = in.getStringExtra("op");
        switch (op) {
            case "+" : total = x + y; break;
            case "-" : total = x - y; break;
            case "*" : total = x * y; break;
            case "/" : total = x / y; break;
            default: total = 0;
        }
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent out = new Intent(getApplicationContext(), MainActivity.class);
                out.putExtra("total", total);
                setResult(RESULT_OK, out);
                finish();
            }
        });
    }
}