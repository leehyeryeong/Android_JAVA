package com.cookandroid.and0804_01_dbcuradp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText edtName, edtContact;
    Button btnIn, btnSelect;
    ListView list;

    MyDBHelper myHelper;
    SQLiteDatabase sqlDB;
    ContactAdapter cAdapter;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtName = findViewById(R.id.edtName);
        edtContact = findViewById(R.id.edtContact);
        btnIn = findViewById(R.id.btnIn);
        btnSelect = findViewById(R.id.btnSelect);
        list = findViewById(R.id.list);

        myHelper = new MyDBHelper(this);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView txtName = view.findViewById(R.id.txtName);
                TextView txtTel = view.findViewById(R.id.txtTel);
                String out = "이름: "+txtName.getText().toString()+
                             "\n전화번호: "+txtTel.getText().toString();
                Toast.makeText(getApplicationContext(), out, Toast.LENGTH_SHORT).show();
            }
        });
        btnIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    sqlDB = myHelper.getWritableDatabase();
                    String name = edtName.getText().toString().trim();
                    String tel = edtContact.getText().toString().trim();
                    if(!name.isEmpty()&&!tel.isEmpty()) {
                        String sql = "INSERT INTO contactTBL(name, tel) VALUES ('"+name+"', '"+tel+"');";
                        sqlDB.execSQL(sql);
                        sqlDB.close();
                        Toast.makeText(getApplicationContext(), "입력됨", Toast.LENGTH_SHORT).show();
                        edtName.setText("");
                        edtContact.setText("");
                        btnSelect.callOnClick();
                    } else {
                        Toast.makeText(getApplicationContext(), "이름 또는 전화번호를 입력하세요.", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "입력 실패", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqlDB = myHelper.getReadableDatabase();
                Cursor cursor = sqlDB.rawQuery("SELECT * FROM contactTBL;", null);
                if(cursor.getCount()>0) {
                    cAdapter = new ContactAdapter(MainActivity.this, cursor, true);
                    list.setAdapter(cAdapter);
                } else {
                    cAdapter = null;
                    list.setAdapter(cAdapter);
                }
                sqlDB.close();
                Toast.makeText(getApplicationContext(), "조회됨", Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    protected void onStop() {
        super.onStop();
        cursor.close();
    }
}