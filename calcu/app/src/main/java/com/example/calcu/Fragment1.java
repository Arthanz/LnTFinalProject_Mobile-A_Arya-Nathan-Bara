package com.example.calcu;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class Fragment1 extends Fragment {

    Button plus, less, reset; // Buttons for incrementing, decrementing, and resetting the counter
    TextView counter; // TextView displaying the current count
    SharedPreferences sharedPref; // Shared preferences used for storing the counter value
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_1, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Find the views by their IDs
        plus = view.findViewById(R.id.bt_plusplus);
        less = view.findViewById(R.id.bt_lessless);
        reset = view.findViewById(R.id.bt_reset);
        counter = view.findViewById(R.id.tv_counter);
        // Retrieve the counter value from the shared preferences
        sharedPref = getActivity().getSharedPreferences("counter", Context.MODE_PRIVATE);
        counter.setText(sharedPref.getString("counter", ""));
        // Set up the click listeners for each button
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the current count, increment it, and update the TextView and shared preferences
                String str = counter.getText().toString();
                int n = Integer.valueOf(str);
                ++n;
                str = String.valueOf(n);
                counter.setText(str);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("counter", str);
                editor.apply();
            }
        });

        less.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the current count, decrement it, and update the TextView and shared preferences
                String str = counter.getText().toString();
                int n = Integer.valueOf(str);
                --n;
                str = String.valueOf(n);
                counter.setText(str);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("counter", str);
                editor.apply();
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Reset the count to zero and update the TextView and shared preferences
                counter.setText("0");
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("counter", "0");
                editor.apply();
            }
        });

    }
}