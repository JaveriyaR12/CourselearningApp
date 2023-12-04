package com.example.course_learning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Signup extends AppCompatActivity {
    EditText edit_email1, edit_phonenumber, edit_password1, edit_confirmpassword;
    TextView textview_login;
    Button btn_signup;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        databaseHelper = new DatabaseHelper(this);
        edit_email1 = findViewById(R.id.edit_email);
        edit_password1 = findViewById(R.id.edit_password);
        edit_phonenumber = findViewById((R.id.edit_phonenumber));
        edit_confirmpassword = findViewById(R.id.edit_confirmpassword);
        btn_signup = findViewById(R.id.btn_signup);
        textview_login = (TextView) findViewById(R.id.textview_login);

        textview_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentsignlogin = new Intent(getApplicationContext(), Login.class);
                startActivity(intentsignlogin);
            }
        });


        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = edit_email1.getText().toString();
                String phonenumber = edit_phonenumber.getText().toString();
                String password = edit_password1.getText().toString();
                String confirmpassword = edit_confirmpassword.getText().toString();


                if (email.length() == 0 || phonenumber.length() == 0 || password.length() == 0 || confirmpassword.length() == 0)
                    Toast.makeText(Signup.this, "All fields are mandatory", Toast.LENGTH_SHORT).show();

                else {
                    if (password.compareTo(confirmpassword) == 0) {
                        Boolean checkUserEmail = databaseHelper.checkEmail(email);
                        if (!checkUserEmail) {
                            Boolean insert = databaseHelper.insertData(email, password);
                            if (insert) {
                                Toast.makeText(Signup.this, "signup Successful", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(Signup.this, Login.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(Signup.this, "signup Failed", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(Signup.this, "User already exists; please login", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(Signup.this, "Invalid password", Toast.LENGTH_SHORT).show();
                    }

                }
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







