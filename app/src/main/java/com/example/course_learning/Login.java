package com.example.course_learning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText edit_loginemail3, edit_loginpassword3;
    ProgressBar progressBar;
    Button btn_login, btn_loginsignup;

    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edit_loginemail3 = findViewById(R.id.edit_loginemail);
        edit_loginpassword3 = (EditText) findViewById(R.id.edit_loginpassword);
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_loginsignup = (Button) findViewById(R.id.btn_loginsignup);
        progressBar = findViewById(R.id.progressBar);
        databaseHelper = new DatabaseHelper(this);


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String edit_loginemail1 = edit_loginemail3.getText().toString();
                String edit_loginpassword1 = edit_loginpassword3.getText().toString();

                if (edit_loginemail1.equals("") || edit_loginpassword1.equals(""))
                    Toast.makeText(Login.this, "login successful", Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkCredentials = databaseHelper.checkEmailpassword(edit_loginemail1, edit_loginpassword1);
                    if (checkCredentials) {
                        Toast.makeText(Login.this, "Login successful", Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.VISIBLE);
                        Intent intent = new Intent(Login.this, Home.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(Login.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });




        btn_loginsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentsignup = new Intent(Login.this, Signup.class);
                startActivity(intentsignup);
            }
        });

    }

    public static boolean isValid(String passwordhere) {
        int f1 = 0, f2 = 0, f3 = 0;
        if (passwordhere.length() < 8) {
            return false;
        } else {
            for (int p = 0; p < passwordhere.length(); p++) {
                if (Character.isLetter(passwordhere.charAt(p))) {
                    f1 = 1;
                }
            }
            for (int r = 0; r < passwordhere.length(); r++) {
                if (Character.isLetter(passwordhere.charAt(r))) {
                    f2 = 1;
                }
            }
            for (int s = 0; s < passwordhere.length(); s++) {
                if (Character.isLetter(passwordhere.charAt(s))) {
                    f3 = 1;
                }
            }
            if (f1 == 1 && f2 == 1 && f3 == 1)
                return true;
            return false;
        }
    }
}













