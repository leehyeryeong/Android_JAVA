package com.cookandroid.and0830_loginsql;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    private EditText RgEdtID, RgEdtPW, edtName, edtAge;
    private Button btnRegister;
    SQLiteDatabase sqlDB;
    MyDBHelper myHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        RgEdtID = findViewById(R.id.RgEdtID);
        RgEdtPW = findViewById(R.id.RgEdtPW);
        edtName = findViewById(R.id.edtName);
        edtAge = findViewById(R.id.edtAge);
        btnRegister = findViewById(R.id.btnRegister);
        myHelper = new MyDBHelper(this);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userID = RgEdtID.getText().toString().trim();
                String userPW = RgEdtPW.getText().toString().trim();
                String userName = edtName.getText().toString().trim();
                int userAge = Integer.parseInt(edtAge.getText().toString().trim());
                
                try { //DB에 insert 처리
                    if(!userID.isEmpty() && !userPW.isEmpty()) {
                        sqlDB = myHelper.getWritableDatabase();
                        sqlDB.execSQL("INSERT INTO user(userID, userPW, userName, userAge) VALUES ( '"+ userID + "', "+ "'" + userPW + "', " + "'"+ userName + "', "+userAge + ");");
                        sqlDB.close();
                        Toast.makeText(getApplicationContext(), "회원 등록 성공", Toast.LENGTH_SHORT).show();
                        Intent in = new Intent(RegisterActivity.this, MainActivity.class);
                        startActivity(in);
                    }
                } catch(Exception e) {
                    Toast.makeText(getApplicationContext(), "입력 실패(아이디 중복)", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}