package com.cookandroid.project7_1_optionmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    LinearLayout linear;
    Button btn;
    EditText edt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("이혜령[옵션메뉴실습]");
        linear = findViewById(R.id.linear);
        btn = findViewById(R.id.btn);
        edt = findViewById(R.id.edt);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int nedt = Integer.parseInt(edt.getText().toString());
                btn.setRotation(nedt);
            }
        });
    } //end of onCreate

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater mInf = getMenuInflater();
        mInf.inflate(R.menu.menu1, menu);
        return true;
    } //end of onCreateOptionMenu

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itemGreen:
                linear.setBackgroundColor(Color.GREEN); break;
            case R.id.itemBlue:
                linear.setBackgroundColor(Color.BLUE); break;
            case R.id.itemWhite:
                linear.setBackgroundColor(Color.WHITE); break;
            case R.id.itemRotation:
                int nedt = Integer.parseInt(edt.getText().toString());
                btn.setRotation(nedt); break;
            case R.id.itemSizeup:
                btn.setScaleX(2); btn.setScaleY(2); break;
            case R.id.itemReturn:
                btn.setRotation(0); btn.setScaleX(1); btn.setScaleX(1); break;
        } //end of switch
        return false;
    } //end of onOptionItemSelected
} //end of MainActivity