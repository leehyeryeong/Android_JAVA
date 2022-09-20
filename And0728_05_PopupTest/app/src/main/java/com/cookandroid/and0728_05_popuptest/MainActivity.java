package com.cookandroid.and0728_05_popuptest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtID, edtPW;
    Button btnLogin, btnCancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("[이혜령]로그인");
        edtID = findViewById(R.id.edtID);
        edtPW = findViewById(R.id.edtPW);
        btnLogin = findViewById(R.id.btnLogin);
        btnCancel = findViewById(R.id.btnCancel);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("로그인 정보");
                dlg.setIcon(R.mipmap.ic_launcher_round);
                dlg.setMessage("아이디: "+edtID.getText()+"\n"+"비밀번호: "+edtPW.getText());
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "로그인이 완료되었습니다.", Toast.LENGTH_SHORT).show();
                    }
                });
                dlg.show();
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu p = new PopupMenu(getApplicationContext(), view);
                getMenuInflater().inflate(R.menu.menu_popup, p.getMenu());
                p.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()){
                            case R.id.popup_clear:
                                edtID.setText("");
                                edtPW.setText("");
                                return true;
                            case R.id.popup_finish:
                                finish();
                                return true;
                            default:
                                Toast.makeText(getApplicationContext(), "선택하지 않으셨습니다.",Toast.LENGTH_SHORT).show();
                                return false;
                        }
                    }
                });
                p.show();
            }
        });
    }
}