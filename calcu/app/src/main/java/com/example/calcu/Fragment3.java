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

import org.w3c.dom.Text;

public class Fragment3 extends Fragment {
    // Buttons and TextViews for calculating the volume of 3D shapes
    Button btbalok, btpiramid, bttabung;
    TextView balok, piramid, tabung;

    // EditTexts for entering the dimensions of the 3D shapes
    EditText pbalok, lbalok, tbalok, ppiramid, lpiramid, tpiramid, rtabung, ttabung;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_3, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Find the buttons and text views by their ID
        btbalok = view.findViewById(R.id.bt_balok);
        btpiramid = view.findViewById(R.id.bt_piramid);
        bttabung = view.findViewById(R.id.bt_tabung);

        balok = view.findViewById(R.id.tv_balok);
        piramid = view.findViewById(R.id.tv_piramid);
        tabung = view.findViewById(R.id.tv_tabung);

        // Find the edit texts by their ID
        pbalok = view.findViewById(R.id.et_pbalok);
        lbalok = view.findViewById(R.id.et_lbalok);
        tbalok = view.findViewById(R.id.et_tbalok);

        ppiramid = view.findViewById(R.id.et_ppiramid);
        lpiramid = view.findViewById(R.id.et_lpiramid);
        tpiramid = view.findViewById(R.id.et_tpiramid);

        rtabung = view.findViewById(R.id.et_rtabung);
        ttabung = view.findViewById(R.id.et_ttabung);

        // Set onClickListeners for each button
        btbalok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the values entered in the edit texts
                String str1 = pbalok.getText().toString().trim();
                String str2 = lbalok.getText().toString().trim();
                String str3 = tbalok.getText().toString().trim();

                // Check that all the edit texts have been filled in
                if (str1.length() > 0 && str2.length() > 0 && str3.length() > 0) {
                    // Convert the string values to integers
                    int p = Integer.valueOf(str1);
                    int l = Integer.valueOf(str2);
                    int t = Integer.valueOf(str3);
                    balok.setText(String.valueOf(p*l*t));
                } else {
                    // Calculate the volume of the rectangular prism
                    balok.setText("\0");
                }
            }
        });

        btpiramid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the values entered in the edit texts
                String str1 = ppiramid.getText().toString().trim();
                String str2 = lpiramid.getText().toString().trim();
                String str3 = tpiramid.getText().toString().trim();
                // Check that all the edit texts have been filled in
                if (str1.length() > 0 && str2.length() > 0 && str3.length() > 0) {
                    // Convert the string values to integers
                    int p = Integer.valueOf(str1);
                    int l = Integer.valueOf(str2);
                    int t = Integer.valueOf(str3);
                    piramid.setText(String.valueOf(p*l*t/3));
                } else {
                    piramid.setText("\0");
                }
            }
        });

        bttabung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str1 = rtabung.getText().toString().trim();
                String str2 = ttabung.getText().toString().trim();

                if (str1.length() > 0 && str2.length() > 0) {
                    int r = Integer.valueOf(str1);
                    int t = Integer.valueOf(str2);
                    tabung.setText(String.valueOf(22*r*r*t/7));
                } else {
                    tabung.setText("\0");
                }
            }
        });
    }
}