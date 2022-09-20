package com.cookandroid.and0801_04_activityput2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    EditText edtName, edtTel, edtAddress;
    RadioGroup rgGender;
    RadioButton rbMan, rbWoman;
    Button btnInput;
    String name, gender, tel, address;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("[이혜령]Intent 실습 4");
        edtName = findViewById(R.id.edtName);
        edtTel = findViewById(R.id.edtTel);
        edtAddress = findViewById(R.id.edtAddress);
        rgGender = findViewById(R.id.rgGender);
        rbMan = findViewById(R.id.rbMan);
        rbWoman = findViewById(R.id.rbWoman);
        btnInput = findViewById(R.id.btnInput);

        btnInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = edtName.getText().toString();
                tel = edtTel.getText().toString();
                address = edtAddress.getText().toString();

                switch (rgGender.getCheckedRadioButtonId()) {
                    case R.id.rbMan:
                        gender = "남자";
                        break;
                    case R.id.rbWoman:
                        gender = "여자";
                        break;
                }

                Person p = new Person(name, gender, tel, address);
                Intent in = new Intent(getApplicationContext(), ResultActivity.class);
                in.putExtra("person", p);
                startActivity(in);
            }
        });
    }
}