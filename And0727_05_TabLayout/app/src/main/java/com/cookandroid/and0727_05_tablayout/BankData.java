package com.cookandroid.and0727_05_tablayout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class BankData extends Fragment {
    public static TextView txtData;
    public static int data = 10000; //통장 잔액

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.bank_data, container, false);
        
        txtData = v.findViewById(R.id.txtData);
        txtData.setText("잔액: "+BankData.data+"원");

        return v;
    }
}
