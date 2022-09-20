package com.cookandroid.project4_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView txtPet;
    CheckBox chk;
    RadioGroup rg;
    Button btnOK;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("이혜령");
        chk = findViewById(R.id.chk);
        txtPet = findViewById(R.id.txtPet);
        rg = findViewById(R.id.rg);
        btnOK = findViewById(R.id.btnOK);
        img = findViewById(R.id.img);
        chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(chk.isChecked()) { //true
                    txtPet.setVisibility(View.VISIBLE);
                    rg.setVisibility(View.VISIBLE);
                    btnOK.setVisibility(View.VISIBLE);
                    img.setVisibility(View.VISIBLE);
                } else {
                    txtPet.setVisibility(View.INVISIBLE);
                    rg.setVisibility(View.INVISIBLE);
                    btnOK.setVisibility(View.INVISIBLE);
                    img.setVisibility(View.INVISIBLE);
                    rg.clearCheck();
                    img.setImageDrawable(null);
                } //end of if
            } //end of onCheckedChanged
        });
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish(); //종료
            } //end of OnClick
        });
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch(i) {
                    case R.id.rdocat :
                        img.setImageResource(R.drawable.cat); break;
                    case R.id.rdodog :
                        img.setImageResource(R.drawable.dog); break;
                    case R.id.rdofox :
                        img.setImageResource(R.drawable.fox2); break;
                }
            }
        });
    }
}