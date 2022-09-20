package com.cookandroid.project7_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtName, edtGender, edtTel;
    Button btnInsert, btnGender, btnTel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("[이혜령]메뉴 총정리");
        edtName = findViewById(R.id.edtName);
        edtGender = findViewById(R.id.edtGender);
        edtTel = findViewById(R.id.edtTel);
        btnInsert = findViewById(R.id.btnInsert);
        btnGender = findViewById(R.id.btnGender);
        btnTel = findViewById(R.id.btnTel);
        registerForContextMenu(btnTel); //전화번호 버튼을 컨텍스트 메뉴로 등록
        btnGender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu p = new PopupMenu(getApplicationContext(), view);
                getMenuInflater().inflate(R.menu.menu_popup, p.getMenu());
                p.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.itemMan:
                                edtGender.setText("남자"); break;
                            case R.id.itemWoman:
                                edtGender.setText("여자"); break;
                        } //end of switch
                        return false;
                    } //end of onMenuItemClick
                });
                p.show(); //팝업메뉴 보여주기
            } //end of onClick
        });
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edtName.getText().toString();
                String gender = edtGender.getText().toString();
                String str = name + "님\n" + gender;
                Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
            } //end of onClick
        });
    } //end of onCreate

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        if(v==btnTel) { //컨텍스트 메뉴는 위젯을 롱클릭할 때 오픈
            menu.setHeaderTitle("전화번호 선택하세요.");
            menuInflater.inflate(R.menu.menu_context, menu);
        } //end of if
    } //end of onCreateContextMenu

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item010:
                edtTel.setText(item.getTitle().toString()); break;
            case R.id.item017:
                edtTel.setText(item.getTitle().toString()); break;
        } //end of switch
        return true;
    } //end of onContextItemSelected

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_option, menu);
        return true;
    } //end of onCreateOptionsMenu

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itemReset:
                edtName.setText("");
                edtGender.setText("");
                edtTel.setText("");
                return true;
            case R.id.itemExit:
                Toast.makeText(getApplicationContext(), "종료합니다.", Toast.LENGTH_SHORT).show();
                finish(); //앱 종료
                return true;
        } //end of switch
        return false;
    } //end of onOptionsItemSelected
} //end of MainActivity