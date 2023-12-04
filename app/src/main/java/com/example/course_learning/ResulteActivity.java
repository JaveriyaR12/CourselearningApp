package com.example.course_learning;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.animation.ObjectAnimator;


public class ResulteActivity extends AppCompatActivity {
    ImageView imageView3;

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resulte);
        textView = findViewById(R.id.textView);
        imageView3 = findViewById(R.id.imageView4);


        int score = getIntent().getIntExtra("Resute", 0);
        textView.setText("Score : " + score);


        findViewById(R.id.btn_restart).setOnClickListener(
                restart -> {
                    Intent intent = new Intent(ResulteActivity.this, Downloadcertificate.class);
                    startActivity(intent);
                    finish();
                }
        );

    }
}
