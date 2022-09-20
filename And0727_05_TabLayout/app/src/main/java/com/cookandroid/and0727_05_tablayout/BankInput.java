package com.cookandroid.and0727_05_tablayout;

import android.media.FaceDetector;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class BankInput extends Fragment {
    Button btnInputOK;
    EditText edtInput;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.bank_input, container, false);
        btnInputOK = v.findViewById(R.id.btnInputOK);
        edtInput = v.findViewById(R.id.edtInput);

        btnInputOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n = Integer.parseInt(edtInput.getText().toString());
                BankData.data += n;
                BankData.txtData.setText("잔액: "+BankData.data+"원");
            }
        });

        return v;
    }
}
