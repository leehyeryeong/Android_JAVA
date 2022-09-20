package com.cookandroid.and0830_loginsql;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    private EditText edtID, edtPW;
    private Button btnLogin, btnJoin;
    SQLiteDatabase sqlDB;
    MyDBHelper myHelper;

    private BottomAppBar bottomAppBar;
    private int bottomAppBarState = 0;
    FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomAppBar = findViewById(R.id.bottom_app_bar);
        setSupportActionBar(bottomAppBar);
        bottomAppBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomAppBarState = bottomAppBar.getFabAlignmentMode();
                if(bottomAppBarState==0) {
                    bottomAppBar.setFabAlignmentMode(bottomAppBar.FAB_ALIGNMENT_MODE_END);
                } else {
                    bottomAppBar.setFabAlignmentMode(bottomAppBar.FAB_ALIGNMENT_MODE_CENTER);
                }
            }
        });
        bottomAppBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.app_bar_menu1:
                        Toast.makeText(getApplicationContext(), "메뉴 1", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.app_bar_menu2:
                        Toast.makeText(getApplicationContext(), "메뉴 2", Toast.LENGTH_SHORT).show();
                        return true;
                }
                return false;
            }
        });
        fab = findViewById(R.id.fab_btn);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(in);
            }
        }); //여기까지
        edtID = findViewById(R.id.edtID);
        edtPW = findViewById(R.id.edtPW);
        btnLogin = findViewById(R.id.btnLogin);
        btnJoin = findViewById(R.id.btnJoin);
        myHelper = new MyDBHelper(this);
        btnJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(in);
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userID = edtID.getText().toString().trim();
                String userPW = edtPW.getText().toString().trim();
                sqlDB = myHelper.getReadableDatabase();
                Cursor cursor;
                cursor = sqlDB.rawQuery("SELECT userID, userPW FROM user where userID='"+userID+"' and userPW='"+userPW+"';", null);
                if(cursor.moveToFirst()) {
                    Intent in = new Intent(MainActivity.this, LoginOkActivity.class);
                    in.putExtra("userID", userID);
                    in.putExtra("userPW", userPW);
                    startActivity(in);
                } else {
                    Toast.makeText(getApplicationContext(), "로그인 실패(id, pw 확인)", Toast.LENGTH_SHORT).show();
                }
                cursor.close();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.bottom_menu, menu);
        return true;
    }
}