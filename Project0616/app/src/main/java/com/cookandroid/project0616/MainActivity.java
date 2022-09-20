package com.cookandroid.project0616;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtNum1, edtNum2;
    TextView result;
    Button[] btnNums = new Button[10]; //버튼 객체 배열
    Integer[] ids = {R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3,
            R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7,
            R.id.btn8, R.id.btn9};
    Button[] btns = new Button[3];
    Integer[] btnIDs = {R.id.btnAdd, R.id.btnSub, R.id.btnMul, R.id.btnDiv};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("[이혜령]계산기");
        edtNum1 = findViewById(R.id.edtNum1);
        edtNum2 = findViewById(R.id.edtNum2);
        result = findViewById(R.id.result);
        for(int i = 0; i<btnNums.length; i++) {
            btnNums[i] = findViewById(ids[i]);
            final int index = i;
            btnNums[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(edtNum1.isFocused()) {
                        String s = edtNum1.getText().toString()+index;
                        edtNum1.setText(s);
                    } else if(edtNum2.isFocused()) {
                        String s = edtNum2.getText().toString()+index;
                        edtNum2.setText(s);
                    } else {
                        Toast.makeText(getApplicationContext(), "에디터부터 선택하세요.", Toast.LENGTH_SHORT);
                    } //end of if
                } //end of onClick
            });
        } //end of for 0~9 버튼 findViewById
        for(int i = 0; i<btns.length; i++) {
            btns[i] = findViewById(btnIDs[i]);
//            btns[i].setOnClickListener(new View.OnClickListener() {
//                int num1 = Integer.parseInt(edtNum1.getText().toString());
//                int num2 = Integer.parseInt(edtNum2.getText().toString());
//                @Override
//                public void onClick(View view) {
//                    switch (btnIDs) {
//                        case R.id.btnAdd: result.setText("계산 결과: "+(num1+num2));
//                        case R.id.btnSub:
//                        case R.id.btnMul:
//                    }
//                } //end of onClick
//            });
        } //end of for 더하기 빼기 곱하기 나누기 버튼 findViewById
    } //end of onCreate

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.option, menu); //xml을 메뉴로 등록
        return true;
    } //end of onCreateOptionsMenu

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int num1 = Integer.parseInt(edtNum1.getText().toString());
        int num2 = Integer.parseInt(edtNum2.getText().toString());
        switch (item.getItemId()) {
            case R.id.itemAdd:
                result.setText("계산 결과: "+(num1+num2)); break;
            case R.id.itemMul:
                result.setText("계산 결과: "+(num1*num2)); break;
            case R.id.itemExit:
                finish();
        } //end of switch
        return true;
    }
} //end of MainActivity