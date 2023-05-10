package com.example.calcu;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Fragment2 extends Fragment {

    Button btpersegi, btsegitiga, btlingkaran;
    TextView persegi, segitiga, lingkaran;
    EditText sisipersegi, tinggisegitiga, alassegitiga, radiuslingkaran;
    // The onCreateView method inflates the fragment layout and returns its view
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_2, container, false);
    }
    // The onViewCreated method is called after the view has been created
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        // Initialize views by finding their IDs from the inflated layout
        super.onViewCreated(view, savedInstanceState);

        btpersegi = view.findViewById(R.id.bt_persegi);
        btsegitiga = view.findViewById(R.id.bt_segitiga);
        btlingkaran = view.findViewById(R.id.bt_lingkaran);

        persegi = view.findViewById(R.id.tv_persegi);
        segitiga = view.findViewById(R.id.tv_segitiga);
        lingkaran = view.findViewById(R.id.tv_lingkaran);

        sisipersegi = view.findViewById(R.id.et_persegi);
        tinggisegitiga = view.findViewById(R.id.et_tinggisegitiga);
        alassegitiga = view.findViewById(R.id.et_alassegitiga);
        radiuslingkaran = view.findViewById(R.id.et_lingkaran);

        // Set click listeners for each button to perform the corresponding calculations
        btpersegi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = sisipersegi.getText().toString().trim();
                if (str.length() > 0) {
                    int s = Integer.valueOf(str);
                    persegi.setText(String.valueOf(s*s));
                } else {
                    persegi.setText("\0");
                }
            }
        });
        btsegitiga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = alassegitiga.getText().toString().trim();
                String str2 = tinggisegitiga.getText().toString().trim();
                if (str.length() > 0 && str2.length() > 0) {
                    int a = Integer.valueOf(str);
                    int t = Integer.valueOf(str2);
                    segitiga.setText(String.valueOf(a*t/2));
                } else {
                    segitiga.setText("\0");
                }
            }
        });
        btlingkaran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = radiuslingkaran.getText().toString().trim();
                if (str.length() > 0) {
                    int r = Integer.valueOf(str);
                    lingkaran.setText(String.valueOf(22*r*r/7));
                } else {
                    lingkaran.setText("\0");
                }
            }
        });
    }
}