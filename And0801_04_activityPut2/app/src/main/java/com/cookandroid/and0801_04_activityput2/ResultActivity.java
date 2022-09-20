package com.cookandroid.and0801_04_activityput2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {
    TextView txtResult;
    Person p;
    String name, gender, tel, address;
    Button btnResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        txtResult = findViewById(R.id.txtResult);
        btnResult = findViewById(R.id.btnReturn);
        Intent in = getIntent();
        p = (Person)in.getSerializableExtra("person");
        name = p.getName();
        gender = p.getGender();
        tel = p.getTel();
        address = p.getAddress();
        //txtResult.setText("이름: "+name+"\n성별: "+gender+"\n전화번호: "+tel+"\n주소: "+address);
        String str = "이름: "+name+"\n성별: "+gender+"\n전화번호: "+tel+"\n주소: "+address;
        txtResult.setText(str);
        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}