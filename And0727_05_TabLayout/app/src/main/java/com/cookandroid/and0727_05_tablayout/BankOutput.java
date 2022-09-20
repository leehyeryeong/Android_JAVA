package com.cookandroid.and0727_05_tablayout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class BankOutput extends Fragment {
    Button btnOutputOK;
    EditText edtOutput;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.bank_output, container, false);
        btnOutputOK = v.findViewById(R.id.btnOutputOK);
        edtOutput = v.findViewById(R.id.edtOutput);

        btnOutputOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n = Integer.parseInt(edtOutput.getText().toString());
                BankData.data -= n;
                BankData.txtData.setText("잔액: " + BankData.data + "원");
            }
        });

        return v;
    }
}
