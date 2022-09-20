package com.cookandroid.and0725_03_keylisn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("[이혜령]EditText로 입력받고 출력하기");
        edt = findViewById(R.id.edt);
        edt.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if(keyEvent.getAction()==KeyEvent.ACTION_UP) {
                    Toast.makeText(getApplicationContext(), edt.getText().toString(), Toast.LENGTH_SHORT).show();
                }
                if(keyEvent.getAction()==KeyEvent.KEYCODE_ENTER) {


                    Toast.makeText(getApplicationContext(), edt.getText().toString(), Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
    }
}