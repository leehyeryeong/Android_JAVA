package com.cookandroid.and0727_04_framebank;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnBalance, btnDeposit, btnWithdraw, btnDepositOK, btnWithdrawOK;
    LinearLayout balance, deposit, withdraw;
    EditText edtDeposit, edtWithdraw;
    TextView mybalance;
    int total = 10000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("[이혜령]실습 2");
        btnBalance = findViewById(R.id.btnBalance);
        btnDeposit = findViewById(R.id.btnDeposit);
        btnWithdraw = findViewById(R.id.btnWithdraw);
        btnDepositOK = findViewById(R.id.btnDepositOK);
        btnWithdrawOK = findViewById(R.id.btnWithdrawOK);
        balance = findViewById(R.id.balance);
        deposit = findViewById(R.id.deposit);
        withdraw = findViewById(R.id.withdraw);
        edtDeposit = findViewById(R.id.edtDeposit);
        edtWithdraw = findViewById(R.id.edtWithdraw);
        mybalance = findViewById(R.id.mybalance);

        btnBalance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                balance.setVisibility(View.VISIBLE);
                deposit.setVisibility(View.INVISIBLE);
                withdraw.setVisibility(View.INVISIBLE);
                btnBalance.setBackgroundColor(Color.parseColor("#FFF068"));
                btnDeposit.setBackgroundColor(Color.parseColor("#CCCCCC"));
                btnWithdraw.setBackgroundColor(Color.parseColor("#CCCCCC"));
            }
        });
        btnDeposit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deposit.setVisibility(View.VISIBLE);
                balance.setVisibility(View.INVISIBLE);
                withdraw.setVisibility(View.INVISIBLE);
                btnDeposit.setBackgroundColor(Color.parseColor("#FFF068"));
                btnBalance.setBackgroundColor(Color.parseColor("#CCCCCC"));
                btnWithdraw.setBackgroundColor(Color.parseColor("#CCCCCC"));
            }
        });
        btnWithdraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                withdraw.setVisibility(View.VISIBLE);
                balance.setVisibility(View.INVISIBLE);
                deposit.setVisibility(View.INVISIBLE);
                btnWithdraw.setBackgroundColor(Color.parseColor("#FFF068"));
                btnBalance.setBackgroundColor(Color.parseColor("#CCCCCC"));
                btnDeposit.setBackgroundColor(Color.parseColor("#CCCCCC"));
            }
        });
        btnDepositOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int deposit = Integer.parseInt(edtDeposit.getText().toString());
                total += deposit;
                mybalance.setText("잔액: "+total+"원");
            }
        });
        btnWithdrawOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int withdraw = Integer.parseInt(edtWithdraw.getText().toString());
                total -= withdraw;
                mybalance.setText("잔액: "+total+"원");
            }
        });
    }
}