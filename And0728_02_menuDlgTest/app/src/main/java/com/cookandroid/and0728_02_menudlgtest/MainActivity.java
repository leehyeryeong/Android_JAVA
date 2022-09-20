package com.cookandroid.and0728_02_menudlgtest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnTel, btnGender, btnJoin;
    EditText edtTel, edtGender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("[이혜령]다이얼로그 메뉴 정리 실습");
        btnTel = findViewById(R.id.btnTel);
        btnGender = findViewById(R.id.btnGender);
        btnJoin = findViewById(R.id.btnJoin);
        edtTel = findViewById(R.id.edtTel);
        edtGender = findViewById(R.id.edtGender);

        btnGender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu p = new PopupMenu(getApplicationContext(), view);
                getMenuInflater().inflate(R.menu.menu_popup, p.getMenu());

                p.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.popup_man:
                                edtGender.setText("남자");
                                return true;
                            case R.id.popup_woman:
                                edtGender.setText("여자");
                                return true;
                            default:
                                Toast.makeText(getApplicationContext(), "선택하지 않았습니다.", Toast.LENGTH_SHORT).show();
                                return false;
                        }
                    }
                });
                p.show();
            }
        });
        btnJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("가입 정보 확인");
                dlg.setIcon(R.mipmap.ic_launcher_round);
                dlg.setMessage("전화번호: "+edtTel.getText()+"\n"+"성별: "+edtGender.getText());
                dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "가입이 취소되었습니다.", Toast.LENGTH_SHORT).show();
                    }
                });
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "가입이 완료되었습니다.", Toast.LENGTH_SHORT).show();
                    }
                });
                dlg.show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater minflater = getMenuInflater();
        minflater.inflate(R.menu.menu_option, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.option_clear:
                edtTel.setText("");
                edtGender.setText("");
                return true;
            case R.id.option_finish:
                finish();
                return true;
            default:
                return false;
        }
    }
}