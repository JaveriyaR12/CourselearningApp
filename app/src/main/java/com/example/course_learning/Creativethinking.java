package com.example.course_learning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Creativethinking extends AppCompatActivity {
    TextView arrow;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creativethinking);
        button = (Button) findViewById(R.id.button);
        arrow = (TextView)findViewById(R.id.textarrow) ;

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentdataanalyst = new Intent(Creativethinking.this,Paymentdataanalyst.class);
                startActivity(intentdataanalyst);
            }
        });

        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Creativethinking.this, Home.class);
                startActivity(intent);

            }
        });
    }
}