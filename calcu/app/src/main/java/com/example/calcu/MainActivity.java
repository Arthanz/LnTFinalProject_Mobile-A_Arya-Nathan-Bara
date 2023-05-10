package com.example.calcu;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView toRegis;
    Button login;
    EditText email, password;
    SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI elements
        login = findViewById(R.id.bt_login);
        toRegis = findViewById(R.id.tv_toregister);
        email = findViewById(R.id.et_emaillogin);
        password = findViewById(R.id.et_passwordlogin);

        // Open registration activity when "To Register" is clicked
        toRegis.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, registerActivity.class));
        });

        // Retrieve shared preferences object for user account data
        sharedPref = getSharedPreferences("user_account", MODE_PRIVATE);

        // Handle login button click event
        login.setOnClickListener(v -> {
            // Validate email input
            if (email.getText().toString().length() < 5 || (!email.getText().toString().contains("@") || !email.getText().toString().contains(".com")) || email.getText().toString().indexOf("@") > email.getText().toString().indexOf(".com")) {
                Toast.makeText(this, "invalid email", Toast.LENGTH_SHORT).show();
            }
            // Check if email is registered
            else if(!email.getText().toString().equals(sharedPref.getString("email", ""))) {
                Toast.makeText(this, "email unregistered", Toast.LENGTH_SHORT).show();
            }
            // Check if password is correct
            else if(!password.getText().toString().equals(sharedPref.getString("password", ""))) {
                Toast.makeText(this, "wrong password", Toast.LENGTH_SHORT).show();
            }
            // Proceed to home activity if login is successful
            else {
                startActivity(new Intent(MainActivity.this, home.class));
            }
        });
    }
}