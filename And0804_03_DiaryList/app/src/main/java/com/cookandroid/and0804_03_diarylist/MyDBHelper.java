package com.cookandroid.and0804_03_diarylist;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDBHelper extends SQLiteOpenHelper {
    public MyDBHelper(@Nullable Context context) {
        super(context, "DiaryDB.db", null, 1);
        // 데이터베이스 이름 groupDB
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // 테이블 생성
        String str = "create table DiaryTBL(_id integer primary key autoincrement, diaryDate char(10), content varchar(500));";
        sqLiteDatabase.execSQL(str);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // 테이블 삭제
        sqLiteDatabase.execSQL("drop table if exists DiaryTBL;");
        onCreate(sqLiteDatabase);
    }
}