package com.cookandroid.and0729_03_sdmem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;
import java.io.FileInputStream;

public class MainActivity extends AppCompatActivity {
    Button btnRead, btnMKdir, btnDeldir, btnFileList;
    EditText edtSd;
    String strSDPath; File myDir; //앱 디렉터리 이름
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityCompat.requestPermissions(this, new String[]
                {android.Manifest.permission.WRITE_EXTERNAL_STORAGE},MODE_PRIVATE);
        btnRead = findViewById(R.id.btnRead);
        btnMKdir = findViewById(R.id.btnMKdir);
        btnDeldir = findViewById(R.id.btnDeldir);
        btnFileList = findViewById(R.id.btnFileList);
        edtSd = findViewById(R.id.edtSD);
        //핸드폰의 SD 카드 절대 경로
        strSDPath = Environment.getExternalStorageDirectory().getAbsolutePath();
        myDir = new File(strSDPath+"/myDir"); //앱 이름의 폴더 경로 세팅
        btnMKdir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!myDir.exists())myDir.mkdir();
            }
        });
        btnDeldir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDir.delete();
            }
        });
        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileInputStream inFs = new FileInputStream(strSDPath+"/myDir/test.txt");
                    byte[] in = new byte[inFs.available()];
                    inFs.read(in);
                    edtSd.setText(new String(in));
                    inFs.close();
                } catch(Exception e) {

                }
            }
        });
        btnFileList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                File[] sysFiles = (new File(strSDPath).listFiles());
                String strFname = "파일 및 폴더 개수: "+sysFiles.length;
                for(int i = 0; i < sysFiles.length; i++) {
                    if(sysFiles[i].isDirectory()) {
                        strFname += "\n[폴더]"+sysFiles[i].toString();
                    } else if(sysFiles[i].isFile()) {
                        strFname += "\n[파일]"+sysFiles[i].toString();
                    }
                }
                edtSd.setText(strFname);
            }
        });
    }
}