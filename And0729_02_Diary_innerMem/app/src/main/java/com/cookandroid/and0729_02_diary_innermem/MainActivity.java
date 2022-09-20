package com.cookandroid.and0729_02_diary_innermem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    DatePicker datePicker1;
    EditText edtDiary;
    Button btnSave;
    String fileName; //파일 이름
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("간단 일기장_내장 메모리[이혜령]");
        datePicker1 = findViewById(R.id.datePicker1);
        edtDiary = findViewById(R.id.edtDiary);
        btnSave = findViewById(R.id.btnSave);
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR); //시스템 달력에서 년도 가져오기
        int month = cal.get(Calendar.MONTH); //시스템 달력에서 월(0부터 시작) 가져오기
        int day = cal.get(Calendar.DAY_OF_MONTH); //시스템 달력에서 일 가져오기
        fileName = year+"_"+(month+1)+"_"+day+".txt"; //파일 이름 만들기 "년_월_일.txt"
        //오늘 날짜의 일기가 있으면 읽어서 edtDiary에 setText() 하기
        String str = readDiary(fileName); //일기 읽기 완성
        edtDiary.setText(str);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileOutputStream outFs = openFileOutput(fileName, Context.MODE_PRIVATE); //MOED_PRIVATE: 파일 쓰기용으로 open
                    String str = edtDiary.getText().toString();
                    outFs.write(str.getBytes());
                    outFs.close();
                    Toast.makeText(getApplicationContext(), "파일이 저장되었습니다.", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {

                }
            }
        });
        datePicker1.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int y, int m, int d) {
                fileName = y+"_"+(m+1)+"_"+d+".txt";
                String str = readDiary(fileName); //일기 있으면 읽어오기
                edtDiary.setText(str);
            }
        });
    }
    //파일 읽기 함수 따로 정의
    String readDiary(String fname) {
        String diaryData = null; //일기 내용 저장하는 변수
        try {
            FileInputStream inFs = openFileInput(fname); //년_월_일.txt 파일 읽기
            byte[] in = new byte[500];
            inFs.read(in);
            diaryData = (new String(in)).trim(); //양 끝에 공백 제거 함수 trim()
            btnSave.setText("수정하기");
            inFs.close();
        } catch(Exception e) {
            btnSave.setText("새로 저장");
        }
        return  diaryData;
    }
}