package com.example.course_learning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Philosophy extends AppCompatActivity {
    TextView arrow;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_philosophy);
        arrow = (TextView) findViewById(R.id.textarrow);
        button = (Button) findViewById(R.id.button);

        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Philosophy.this,Home.class);
                startActivity(intent);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Philosophy.this, Paymentdataanalyst.class);
                startActivity(intent);
            }
        });
    }
}