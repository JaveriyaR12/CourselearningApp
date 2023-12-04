package com.example.course_learning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DataAnalayst extends AppCompatActivity {
    Button dataanalyst;
    TextView arrow;
    private EditText editpaymentdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_analayst);

        dataanalyst = (Button) findViewById(R.id.buttondatanalyst);
        arrow = (TextView)findViewById(R.id.textarrow) ;
        editpaymentdata = (EditText) findViewById(R.id.editpaymentdata);



        dataanalyst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String payment = editpaymentdata.getText().toString();

                Intent intentdataanalyst = new Intent(DataAnalayst.this,Paymentdataanalyst.class);
                intentdataanalyst.putExtra("datapay",payment);
                startActivity(intentdataanalyst);
            }
        });

        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(DataAnalayst.this, Home.class);
                startActivity(intent);

            }
        });
    }
}