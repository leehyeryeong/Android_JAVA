package com.cookandroid.and0830_loginsql;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginOkActivity extends AppCompatActivity {
    private TextView txtID, txtPW;
    private Button btnFinish;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_ok);
        txtID = findViewById(R.id.txtID);
        txtPW = findViewById(R.id.txtPW);
        btnFinish = findViewById(R.id.btnFinish);

        Intent in = getIntent();
        String userID = in.getStringExtra("userID");
        String userPW = in.getStringExtra("userPW");
        txtID.setText(userID);
        txtPW.setText(userPW);

        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}