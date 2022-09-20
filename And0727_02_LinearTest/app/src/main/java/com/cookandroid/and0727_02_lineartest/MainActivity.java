package com.cookandroid.and0727_02_lineartest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtX, edtY;
    Spinner op;
    Button btn;
    TextView txtResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("[이혜령]Linear Test");
        edtX = findViewById(R.id.edtX);
        edtY = findViewById(R.id.edtY);
        op = findViewById(R.id.op);
        btn = findViewById(R.id.btn);
        txtResult = findViewById(R.id.txtResult);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i = op.getSelectedItemPosition();
                int x = Integer.parseInt(edtX.getText().toString());
                int y = Integer.parseInt(edtY.getText().toString());
                switch (i) {
                    case 0 : txtResult.setText(""+(x+y)); break;
                    case 1 : txtResult.setText(""+(x-y)); break;
                    case 2 : txtResult.setText(""+(x*y)); break;
                    case 3 : txtResult.setText(""+(x%y)); break;
                }
            }
        });
    }
}