package com.cookandroid.and0801_02_activityone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    RadioGroup rg;
    RadioButton rbSecond, rbThird;
    Button btnOpen;
    EditText edtContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("[이혜령]실습 10-1");
        rg = findViewById(R.id.rg);
        rbSecond = findViewById(R.id.rbSecond);
        rbThird = findViewById(R.id.rbThird);
        btnOpen = findViewById(R.id.btnOpen);
        edtContent = findViewById(R.id.edtContent);

        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = edtContent.getText().toString();
                switch (rg.getCheckedRadioButtonId()) {
                    case R.id.rbSecond:
                        Intent in2 = new Intent(getApplicationContext(), SecondActivity.class);
                        in2.putExtra("Content", str);
                        startActivity(in2);
                        break;
                    case R.id.rbThird:
                        Intent in3 = new Intent(getApplicationContext(), ThirdActivity.class);
                        in3.putExtra("Content", str);
                        startActivity(in3);
                        break;
                }
            }
        });
    }
}