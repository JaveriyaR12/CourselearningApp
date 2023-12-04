package com.example.course_learning;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.accounts.Account;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.course_learning.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Home extends AppCompatActivity {
    private CardView software,finance,arts,personal,business,others;
    TextView account;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);


        software = findViewById(R.id.software);
        finance = findViewById(R.id.finance);
        arts = findViewById(R.id.Arts);
        personal = findViewById(R.id.development);
        business = findViewById(R.id.business);
        others = findViewById(R.id.others);
        account=(TextView) findViewById(R.id.account);



        software.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Home.this,Software.class);
                startActivity(intent1);
            }
        });

        finance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(Home.this,Finance.class);
                startActivity(intent2);
            }
        });

        arts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(Home.this,Arts.class);
                startActivity(intent3);
            }
        });
        personal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(Home.this,Personal.class);
                startActivity(intent4);
            }
        });
        business.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent5 = new Intent(Home.this,Businessmarketing.class);
                startActivity(intent5);
            }
        });
        others.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Home.this,Others.class);
                startActivity(intent1);
            }
        });
        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentaccount = new Intent(Home.this, account.class);
                startActivity(intentaccount);
            }
        });




    }
}