package com.cookandroid.and0804_02_dbcuradpidol;

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

import com.cookandroid.and0804_02_dbcuradpidol.IdolAdapter;
import com.cookandroid.and0804_02_dbcuradpidol.MyDBHelper;
import com.cookandroid.and0804_02_dbcuradpidol.R;

public class MainActivity extends AppCompatActivity {
    EditText edtName, edtNumber;
    Button btnIn, btnSelect;
    ListView list;

    MyDBHelper myHelper;
    SQLiteDatabase sqlDB;
    IdolAdapter IAdapter;
    Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("[이혜령]아이돌DB관리_커서어댑터");
        edtName = findViewById(R.id.edtName);
        edtNumber = findViewById(R.id.edtNumber);
        btnIn = findViewById(R.id.btnIn);
        btnSelect = findViewById(R.id.btnSelect);
        list = findViewById(R.id.list);
        myHelper = new MyDBHelper(this);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView txtName = view.findViewById(R.id.txtName);
                TextView txtTel = view.findViewById(R.id.txtNum);
                String out = "이름: " + txtName.getText().toString();
                out += "\n인원 수: " + txtTel.getText().toString();
                Toast.makeText(getApplicationContext(), out, Toast.LENGTH_SHORT).show();
            }
        });
        btnIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    sqlDB = myHelper.getWritableDatabase();
                    String name = edtName.getText().toString().trim();
                    String number = edtNumber.getText().toString().trim();
                    if(!name.isEmpty()&&!number.isEmpty()){
                        String sql = "INSERT INTO groupTBL(gName, gNumber) VALUES ('"+name+"', '"+number+"');";
                        sqlDB.execSQL(sql);
                        sqlDB.close();
                        Toast.makeText(getApplicationContext(), "입력됨", Toast.LENGTH_SHORT).show();
                        edtName.setText(""); edtNumber.setText("");
                        btnIn.callOnClick();
                    }
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), "입력 실패", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqlDB = myHelper.getReadableDatabase();
                Cursor cursor = sqlDB.rawQuery("SELECT * FROM groupTBL;", null);
                if(cursor.getCount()>0) {
                    IAdapter = new IdolAdapter(MainActivity.this, cursor, true);
                    list.setAdapter(IAdapter);
                }
                else { //초기화 되어 테이블이 없는 경우 adapter 초기화시킴
                    IAdapter=null;
                    list.setAdapter(IAdapter);
                }
                sqlDB.close();
                Toast.makeText(getApplicationContext(),"조회됨",Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    protected void onStop(){
        super.onStop();
        cursor.close();
    }
}