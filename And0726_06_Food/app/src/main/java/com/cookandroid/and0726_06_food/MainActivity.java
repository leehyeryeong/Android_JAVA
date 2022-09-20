package com.cookandroid.and0726_06_food;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    CheckBox chkStart;
    TextView txtConcept;
    RadioGroup rg;
    RadioButton rbRg, rbSh, rbKi, rbPc;
    ImageView img;
    Button btnReset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("[이혜령]설문 앱 완성하기");
        chkStart = findViewById(R.id.chkStart);
        txtConcept = findViewById(R.id.txtConcept);
        rg = findViewById(R.id.rg);
        rbRg = findViewById(R.id.rbRg);
        rbSh = findViewById(R.id.rbSh);
        rbKi = findViewById(R.id.rbKi);
        rbPc = findViewById(R.id.rbPc);
        img = findViewById(R.id.img);
        btnReset = findViewById(R.id.btnReset);

        txtConcept.setVisibility(View.INVISIBLE);
        rg.setVisibility(View.INVISIBLE);
        img.setVisibility(View.INVISIBLE);
        btnReset.setVisibility(View.INVISIBLE);

        chkStart.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(chkStart.isChecked()==true) {
                    txtConcept.setVisibility(View.VISIBLE);
                    rg.setVisibility(View.VISIBLE);
                    btnReset.setVisibility(View.VISIBLE);
                } else if(chkStart.isChecked()==false) {
                    txtConcept.setVisibility(View.INVISIBLE);
                    rg.setVisibility(View.INVISIBLE);
                    btnReset.setVisibility(View.INVISIBLE);
                }
            }
        });
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                img.setVisibility(View.VISIBLE);
                switch (i) {
                    case R.id.rbRg:
                        img.setImageResource(R.drawable.regular);
                        break;
                    case R.id.rbSh:
                        img.setImageResource(R.drawable.superhuman);
                        break;
                    case R.id.rbKi:
                        img.setImageResource(R.drawable.kickit);
                        break;
                    case R.id.rbPc:
                        img.setImageResource(R.drawable.punch);
                        break;
                }
            }
        });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rg.clearCheck();
                img.setImageDrawable(null);
            }
        });
    }
}