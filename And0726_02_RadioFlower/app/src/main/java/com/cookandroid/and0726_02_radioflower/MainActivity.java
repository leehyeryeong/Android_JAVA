package com.cookandroid.and0726_02_radioflower;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioGroup rg;
    RadioButton rbRose, rbPansy, rbLily;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("[이혜령]실습 1");
        rg = findViewById(R.id.rg);
        rbRose = findViewById(R.id.rbRose);
        rbPansy = findViewById(R.id.rbPansy);
        rbLily = findViewById(R.id.rbLily);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rbRose:
                        Toast.makeText(getApplicationContext(), "장미", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rbPansy:
                        Toast.makeText(getApplicationContext(), "팬지", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rbLily:
                        Toast.makeText(getApplicationContext(), "백합", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }
}