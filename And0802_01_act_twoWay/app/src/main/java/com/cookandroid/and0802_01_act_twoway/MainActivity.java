package com.cookandroid.and0802_01_act_twoway;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtNum1, edtNum2;
    RadioGroup rgCal;
    RadioButton rbSum, rbSub, rbMul, rbDiv;
    Button btnCal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("[이혜령]");
        edtNum1 = findViewById(R.id.edtNum1);
        edtNum2 = findViewById(R.id.edtNum2);
        rgCal = findViewById(R.id.rgCal);
        rbSum = findViewById(R.id.rbSum);
        rbSub = findViewById(R.id.rbSub);
        rbMul = findViewById(R.id.rbMul);
        rbDiv = findViewById(R.id.rbDiv);
        btnCal = findViewById(R.id.btnCal);
        btnCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getApplicationContext(), SecondActivity.class);
                in.putExtra("Num1", Integer.parseInt(edtNum1.getText().toString()));
                in.putExtra("Num2", Integer.parseInt(edtNum2.getText().toString()));
                switch (rgCal.getCheckedRadioButtonId()) {
                    case R.id.rbSum:
                        in.putExtra("op", "+");
                        break;
                    case R.id.rbSub:
                        in.putExtra("op", "-");
                        break;
                    case R.id.rbMul:
                        in.putExtra("op", "*");
                        break;
                    case R.id.rbDiv:
                        in.putExtra("op", "/");
                        break;
                }
                startActivityForResult(in, 0); //requestCode는 세컨 액티비티 번호
                //세컨 액티비티에 return 값이 있을 때 사용(세컨에서 puExtra() 해서 되돌려 받는 경우)
            }
        });
    } //end of onCreate()
    //메서드로 onActivityResult() 함수 구현
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK) {
            int total = data.getIntExtra("total", 0);
            Toast.makeText(getApplicationContext(), "결과: "+total, Toast.LENGTH_SHORT).show();
        }
    }
}