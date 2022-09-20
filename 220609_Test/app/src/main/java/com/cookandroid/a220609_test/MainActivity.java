package com.cookandroid.a220609_test;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtID, edtPW;
    Button btnLogin;
    TextView txtResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("이혜령");
        edtID = findViewById(R.id.edtID);
        edtPW = findViewById(R.id.edtPW);
        btnLogin = findViewById(R.id.btnLogin);
        txtResult = findViewById(R.id.txtResult);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edtID.getText().toString();
                String str = name+"님 로그인 되었습니다.";
                Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
                String pw = edtPW.getText().toString();
                String str1 = "입력결과: 아이디("+name+"), 비밀번호("+pw+")";
                txtResult.setText(str1);
            } //end of onClick
        });
    } //end of onCreate
} //end of MainActivity