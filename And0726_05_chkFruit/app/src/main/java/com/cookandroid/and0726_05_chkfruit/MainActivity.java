package com.cookandroid.and0726_05_chkfruit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    CheckBox[] chk = new CheckBox[4];
    Integer[] chkText = {R.id.chkStraw, R.id.chkGrape, R.id.chkKiwi, R.id.chkGrfruit};
    Button btnChk;
    TextView txtRes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("[이혜령]과일 체크 실습");
        btnChk = findViewById(R.id.btnChk);
        txtRes = findViewById(R.id.txtRes);
        for(int i = 0; i<chk.length; i++) {
            chk[i] = findViewById(chkText[i]);
        }
        btnChk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = "";
                for(int i = 0; i<chk.length; i++) {
                    if(chk[i].isChecked()==true) {
                        str += chk[i].getText().toString();
                    }
                }
                txtRes.setText(str);
            }
        });
        for(int i = 0; i<chk.length; i++) {
            final int k = i;
            chk[i].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    btnChk.performClick(); //btn의 Onclick 함수 호출
                }
            });
        }
    }
}