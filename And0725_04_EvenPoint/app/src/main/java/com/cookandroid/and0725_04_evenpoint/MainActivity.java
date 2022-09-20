package com.cookandroid.and0725_04_evenpoint;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edt_num1, edt_num2;
    Button btn_even, btn_pointer;
    TextView txt_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("[이혜령]실습 5");

        edt_num1 = findViewById(R.id.edt_num1);
        edt_num2 = findViewById(R.id.edt_num2);
        btn_even = findViewById(R.id.btn_even);
        btn_pointer = findViewById(R.id.btn_pointer);
        txt_result = findViewById(R.id.txt_result);

        btn_even.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num1 = Integer.parseInt(edt_num1.getText().toString());
                int num2 = Integer.parseInt(edt_num2.getText().toString());
                int sum = 0;

                for(int i = num1; i <= num2; i++) {
                    if(i%2==0) {
                        sum += i;
                    }
                }
                txt_result.setText(num1+"부터 "+num2+"까지의 짝수들의 합: "+sum);
            }
        });

        btn_pointer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num1 = Integer.parseInt(edt_num1.getText().toString());
                int num2 = Integer.parseInt(edt_num2.getText().toString());
                int res = 0;
                res = num2-(num2%num1);
                if(res>0) {
                    txt_result.setText("가용 포인터는 "+res);
                } else {
                    txt_result.setText("가용할 포인트가 부족합니다.");
                }
            }
        });
    }
}