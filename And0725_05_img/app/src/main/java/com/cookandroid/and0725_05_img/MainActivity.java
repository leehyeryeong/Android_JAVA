package com.cookandroid.and0725_05_img;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Button btn_change, btn_hidden;
    ImageView img;
    int imgType = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("[이혜령]실습 7");
        btn_change = findViewById(R.id.btn_change);
        btn_hidden = findViewById(R.id.btn_hidden);
        img = findViewById(R.id.img);

        btn_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(imgType==1) {
                    img.setImageResource(R.drawable.cat); imgType=2;
                } else {
                    img.setImageResource(R.drawable.dog); imgType=1;
                }
            }
        });
        btn_hidden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(img.getVisibility()==View.VISIBLE) {
                    img.setVisibility(View.INVISIBLE);
                    btn_hidden.setText("보이기");
                } else {
                    img.setVisibility(View.VISIBLE);
                    btn_hidden.setText("숨기기");
                }
            }
        });
    }
}