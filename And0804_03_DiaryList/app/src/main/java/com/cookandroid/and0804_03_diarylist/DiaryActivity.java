package com.cookandroid.and0804_03_diarylist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Calendar;

public class DiaryActivity extends AppCompatActivity {
    DatePicker dp;
    EditText edtDiary;
    Button btn1, btn2;
    String fileName; MyDBHelper myHelper; SQLiteDatabase sqlDB;
    int cYear, cMonth, cDay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);
        setTitle("[일기장 SQLite] 이혜령");
        dp = findViewById(R.id.dp);
        edtDiary = findViewById(R.id.edtDiary);
        btn1 = findViewById(R.id.btnWrite);
        btn2 = findViewById(R.id.btnDel);
        Intent in = getIntent();
        String fname = in.getStringExtra("fname");
        String[] arr = fname.split("_");//"_"문자로 분리>> 문자배열 처리
        cYear=Integer.parseInt(arr[0]);
        cMonth=Integer.parseInt(arr[1])-1;
        cDay=Integer.parseInt(arr[2]);
        myHelper=new MyDBHelper(this);

        fileName = Integer.toString(cYear)+"_"+Integer.toString(cMonth+1)+"_"+Integer.toString(cDay);
        String str = readDiary(fileName);
        edtDiary.setText(str);
        dp.init(cYear, cMonth, cDay, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int y, int m, int d) {
                fileName = y + "_" + (m + 1) + "_" + d;
                String str = readDiary(fileName);//일기 있으면 읽어오기
                edtDiary.setText(str);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    sqlDB = myHelper.getWritableDatabase();
                    sqlDB.execSQL("delete from DiaryTBL where diaryDate='"+fileName+"';");
                    sqlDB.close();
                    Toast.makeText(getApplicationContext(), "삭제됨", Toast.LENGTH_SHORT).show();
                    edtDiary.setText("");
                    btn1.setText("새로저장"); btn2.setVisibility(View.GONE);
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), "삭제 실패", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn1.getText().toString().equals("새로저장")){//insert 처리
                    sqlDB = myHelper.getWritableDatabase();
                    sqlDB.execSQL("INSERT INTO DiaryTBL(diaryDate, content)"+"VALUES('"+fileName+"', '"+edtDiary.getText().toString()+"');");
                    sqlDB.close();
                    Toast.makeText(getApplicationContext(),"입력됨",Toast.LENGTH_SHORT).show();
                    btn1.setText("수정하기");
                    btn2.setVisibility(View.VISIBLE);
                }else{//update 처리
                    sqlDB = myHelper.getWritableDatabase();
                    sqlDB.execSQL("UPDATE DiaryTBL SET content = '"+edtDiary.getText().toString()+"' WHERE diaryDate = '" + fileName + "';");
                    sqlDB.close();
                    Toast.makeText(getApplicationContext(),"수정됨",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public String readDiary(String fName){
        String diaryStr = null;
        sqlDB = myHelper.getReadableDatabase();
        Cursor cursor;
        cursor = sqlDB.rawQuery("SELECT * FROM DiaryTBL WHERE diaryDate = '"+fName+"';",null);
        if (cursor.moveToFirst()==true){
            diaryStr = cursor.getString(2);
            btn1.setText("수정하기");
            btn2.setVisibility(View.VISIBLE);
        }else{
            btn2.setVisibility(View.GONE);//삭제 버튼 없애기
            btn1.setText("새로저장");
        }
        cursor.close(); sqlDB.close();

        return diaryStr;
    }
}