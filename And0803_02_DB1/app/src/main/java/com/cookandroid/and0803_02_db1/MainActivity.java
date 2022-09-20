package com.cookandroid.and0803_02_db1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtName, edtNumber;
    TextView txtGroup, txtNumber;
    Button btnReset, btnIn, btnSelect, btnEdit, btnDelete;

    MyDBHelper myHelper;
    SQLiteDatabase sqlDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("[이혜령]가수그룹관리DB실습");
        edtName = findViewById(R.id.edtName);
        edtNumber = findViewById(R.id.edtNumber);
        txtGroup = findViewById(R.id.txtGroup);
        txtNumber = findViewById(R.id.txtNumber);

        btnReset = findViewById(R.id.btnReset);
        btnIn = findViewById(R.id.btnIn);
        btnSelect = findViewById(R.id.btnSelect);
        btnEdit = findViewById(R.id.btnEdit);
        btnDelete = findViewById(R.id.btnDelete);

        myHelper = new MyDBHelper(this);

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqlDB = myHelper.getWritableDatabase(); //수정모드 오픈
                myHelper.onUpgrade(sqlDB, 1, 2); //숫자는 버전 의미로 아무거나
                sqlDB.close();
            }
        });
        btnIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String name = edtName.getText().toString().trim();
                    int num = Integer.parseInt(edtNumber.getText().toString().trim());
                    if(name.isEmpty()) {
                        Toast.makeText(getApplicationContext(), "이름 입력 필수", Toast.LENGTH_SHORT).show();
                    } else {
//                      String s = "이름: "+name+"나이: "+num;
                        sqlDB = myHelper.getWritableDatabase(); //수정모드 오픈
                        sqlDB.execSQL("insert into groupTBL(gName, gNumber) values('"+name+"', "+num+");");
                        sqlDB.close();
                        Toast.makeText(getApplicationContext(), "입력 성공", Toast.LENGTH_SHORT).show();
                        edtName.setText("");
                        edtNumber.setText("");
                        btnSelect.callOnClick(); //btnSelect() 함수 호출
                    }
                } catch(Exception e) {
                    Toast.makeText(getApplicationContext(), "입력 실패", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqlDB = myHelper.getReadableDatabase();
                Cursor cursor = sqlDB.rawQuery("select *from groupTBL;", null);
                String strNames = "그룹 이름\r\n"+"------------\r\n";
                String strNums = "인원수\r\n"+"------------\r\n";
                while(cursor.moveToNext()) {
                    strNames += cursor.getString(0)+"\n";
                    strNums += cursor.getString(1)+"\n";
                }
                txtGroup.setText(strNames);
                txtNumber.setText(strNums);
                cursor.close();
                sqlDB.close();
                Toast.makeText(getApplicationContext(), "조회 성공", Toast.LENGTH_SHORT).show();
            }
        });
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final View dlgView = (View)View.inflate(MainActivity.this, R.layout.update_dlg, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("그룹 정보 변경");
                dlg.setView(dlgView);

                final EditText edtChName = dlgView.findViewById(R.id.edtChName);
                final EditText edtChNum = dlgView.findViewById(R.id.edtChNum);
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        try {
                            sqlDB = myHelper.getWritableDatabase();
                            String name = edtChName.getText().toString();
                            int num = Integer.parseInt(edtChNum.getText().toString());
                            if(!name.isEmpty()) {
                                String sql ="UPDATE groupTBL SET gNumber= "+ num +" WHERE gName = '"+name+"'";
                                sqlDB.execSQL(sql);
                                sqlDB.close();
                                Toast.makeText(getApplicationContext(), "변경 완료", Toast.LENGTH_SHORT).show();
                                btnSelect.callOnClick();
                            }
                        } catch(Exception e) {
                            Toast.makeText(getApplicationContext(), "변경 실패", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                dlg.setNegativeButton("취소", null);
                dlg.show();
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final View dlgView = View.inflate(getApplicationContext(), R.layout.delete_dlg, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("그룹 정보 삭제");
                dlg.setView(dlgView);

                final EditText edtDelName = dlgView.findViewById(R.id.edtDelName);
                dlg.setPositiveButton("삭제", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        try {
                            sqlDB = myHelper.getWritableDatabase();
                            String name = edtDelName.getText().toString().trim();
                            if(!name.isEmpty()) {
                                sqlDB.execSQL("DELETE FROM groupTBL WHERE gName = '"+name+"';");
                                sqlDB.close();
                                Toast.makeText(getApplicationContext(), "삭제됨", Toast.LENGTH_SHORT).show();
                                btnSelect.callOnClick();
                            } else {
                                Toast.makeText(getApplicationContext(), "이름을 입력하세요.", Toast.LENGTH_SHORT).show();
                            }
                        } catch(Exception e) {
                            Toast.makeText(getApplicationContext(), "삭제 실패", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                dlg.setNegativeButton("취소", null);
                dlg.show();
            }
        });
    }
}