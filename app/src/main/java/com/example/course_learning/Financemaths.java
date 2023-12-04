package com.example.course_learning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Financemaths extends AppCompatActivity {
    TextView arrow;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_financemaths);
        arrow = (TextView) findViewById(R.id.textarrow);
        button = (Button)findViewById(R.id.button) ;


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Financemaths.this, Paymentdataanalyst.class);
                startActivity(intent);
            }
        });

        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Financemaths.this, Home.class);
                startActivity(intent);

            }
        });
    }
}