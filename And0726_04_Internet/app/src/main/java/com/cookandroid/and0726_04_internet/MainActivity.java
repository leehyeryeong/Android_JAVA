package com.cookandroid.and0726_04_internet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtURL;
    Button btn_show, btn_open;
    RadioGroup rg;
    RadioButton rbWho, rbOreo;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("[이혜령]실습 3");
        edtURL = findViewById(R.id.edtURL);
        btn_show = findViewById(R.id.btn_show);
        btn_open = findViewById(R.id.btn_open);
        rg = findViewById(R.id.rg);
        rbWho = findViewById(R.id.rbWho);
        rbOreo = findViewById(R.id.rbOreo);
        image = findViewById(R.id.image);

        btn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = edtURL.getText().toString();
                Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
            }
        });
        btn_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = edtURL.getText().toString();
                Intent btn_open = new Intent(Intent.ACTION_VIEW, Uri.parse(str));
                startActivity(btn_open);
            }
        });
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rbWho:
                        image.setImageResource(R.drawable.marshmallow);
                        break;
                    case R.id.rbOreo:
                        image.setImageResource(R.drawable.oreo);
                }
            }
        });
    }
}