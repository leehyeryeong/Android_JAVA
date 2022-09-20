package com.cookandroid.and0725_02_sum;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btn_Sum;
    EditText edt_Num;
    TextView txt_Insert, txt_Total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("[이혜령]입력한 수의 1부터 누적합 계산");

        btn_Sum = findViewById(R.id.btn_Sum);
        edt_Num = findViewById(R.id.edt_Num);
        txt_Insert = findViewById(R.id.txt_Insert);
        txt_Total = findViewById(R.id.txt_Total);

        btn_Sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num = Integer.parseInt(edt_Num.getText().toString());
                int sum = 0;
                for(int i = 1; i <= num; i++) {
                    sum += i;
                } //end of for
                txt_Total.setText("결과: 1~"+num+"까지의 합 "+sum);
            }
        });
    }
}