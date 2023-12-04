package com.example.course_learning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class Paymentdataanalyst extends AppCompatActivity {

    String[] item = {"Accounting","Art","CreativeThinking","Data Analayst","Deep Learning","Digital marketing","Finance Analayst","Philosopy","UX Design"};

    AutoCompleteTextView autoCompleteTextView;

    ArrayAdapter<String>  adapterItems;
    Button buttonlearn;

    EditText secedit_payment, editexpired, editcvv;
    RadioButton debitcard,creditcard;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paymentdataanalyst);
        buttonlearn = findViewById(R.id.buttonlearn);
        secedit_payment =(EditText)findViewById(R.id.editpayment);
        editexpired =(EditText)findViewById(R.id.editexpireddate);
        editcvv =(EditText)findViewById(R.id.editcvv);
        debitcard = (RadioButton)findViewById(R.id.debitcard) ;
        creditcard = (RadioButton) findViewById(R.id.creditcard);


        String Rpay;
        Rpay = getIntent().getExtras().getString("datapay");
        secedit_payment.setText(Rpay);



        autoCompleteTextView = findViewById(R.id.auto_complete_txt);
        adapterItems = new ArrayAdapter<String>(this, R.layout.list_item, item);

        autoCompleteTextView.setAdapter(adapterItems);

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                String item = adapterView.getItemAtPosition(i).toString();


            }
        });
         
        autoCompleteTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentpayment = new Intent(Paymentdataanalyst.this, Learn.class);
                startActivity(intentpayment);

            }
        });
        buttonlearn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (creditcard.isChecked()) {
                    String CardNumber = secedit_payment.getText().toString();
                    String ExpirationDate = editexpired.getText().toString();
                    String CVV = editcvv.getText().toString();

                    if (isValidPaymentDetails(CardNumber, ExpirationDate, CVV)) {
                        Intent intent = new Intent(Paymentdataanalyst.this, Learn.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(Paymentdataanalyst.this, "Invalid Payment Details!", Toast.LENGTH_LONG).show();
                    }
                } else if (debitcard.isChecked()) {
                    Intent intent = new Intent(Paymentdataanalyst.this, Learn.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(Paymentdataanalyst.this, "Please Select a Payment Method", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    private boolean isValidPaymentDetails(String CardNumber, String ExpirationDate, String Cvv) {
        if (CardNumber.isEmpty() || ExpirationDate.isEmpty() || Cvv.isEmpty()) {
            Toast.makeText(Paymentdataanalyst.this, "Please fill in all payment details", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }
}
















               

