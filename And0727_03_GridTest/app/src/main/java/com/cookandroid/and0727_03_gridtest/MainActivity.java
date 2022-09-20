package com.cookandroid.and0727_03_gridtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView image;
    RadioGroup rg;
    RadioButton rbSeafood, rbTomato, rbCream;
    Button btnOK;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("[이혜령]주문하기");
        image = findViewById(R.id.image);
        rg = findViewById(R.id.rg);
        rbSeafood = findViewById(R.id.rbSeafood);
        rbTomato = findViewById(R.id.rbTomato);
        rbCream = findViewById(R.id.rbCream);
        btnOK = findViewById(R.id.btnOK);

        image.setVisibility(View.INVISIBLE);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rbSeafood:
                        image.setVisibility(View.VISIBLE);
                        image.setImageResource(R.drawable.seafood);
                        break;
                    case R.id.rbTomato:
                        image.setVisibility(View.VISIBLE);
                        image.setImageResource(R.drawable.tomato);
                        break;
                    case R.id.rbCream:
                        image.setVisibility(View.VISIBLE);
                        image.setImageResource(R.drawable.cream);
                        break;
                }
            }
        });
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (rg.getCheckedRadioButtonId()) {
                    case R.id.rbSeafood:
                        Toast.makeText(getApplicationContext(), "해물 파스타(9,500원)", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rbTomato:
                        Toast.makeText(getApplicationContext(), "토마토 파스타(9,000원)", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rbCream:
                        Toast.makeText(getApplicationContext(), "까르보나라(9,500원)", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}