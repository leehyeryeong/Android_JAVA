package com.cookandroid.and0726_03_radioidol;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioGroup rg;
    RadioButton rbWJSN, rbBTS, rbSVT;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("[이혜령]실습 2");
        rg = findViewById(R.id.rg);
        rbWJSN = findViewById(R.id.rbWJSN);
        rbBTS = findViewById(R.id.rbBTS);
        rbSVT = findViewById(R.id.rbSVT);
        btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (rg.getCheckedRadioButtonId()) {
                    case R.id.rbWJSN:
                        Toast.makeText(getApplicationContext(), "우주소녀를 선택하였습니다.", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rbBTS:
                        Toast.makeText(getApplicationContext(), "방탄소년단을 선택하였습니다.", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rbSVT:
                        Toast.makeText(getApplicationContext(), "세븐틴을 선택하였습니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}