package com.example.course_learning;

import androidx.appcompat.app.AppCompatActivity;

import android.accounts.Account;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class account extends AppCompatActivity {

    private RadioButton rdbtnmale,rdbtnfemale,rdbtnothersgender,rdbtnstudent,rdbtnemployed,rdbtnothersrole;
    EditText editname,editdateofbirth;
    Button btnsave;
    String savestring;
    TextView arrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        rdbtnmale = (RadioButton) findViewById(R.id.male);
        rdbtnfemale = (RadioButton) findViewById(R.id.female);
        rdbtnothersgender = (RadioButton) findViewById(R.id.othersgender);
        rdbtnstudent = (RadioButton) findViewById(R.id.student);
        rdbtnemployed = (RadioButton) findViewById(R.id.employed);
        rdbtnothersrole = (RadioButton) findViewById(R.id.othersrole);
         btnsave = (Button) findViewById(R.id.buttonsave);
         arrow = findViewById(R.id.textarrow);
         editname = findViewById(R.id.editname);
         editdateofbirth = (EditText) findViewById(R.id.editdateofbirth);

         btnsave.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 if (rdbtnmale.isChecked()) {
                     savestring = rdbtnmale.getText().toString();
                 } else if (rdbtnfemale.isChecked()) {
                     savestring = rdbtnfemale.getText().toString();
                 } else if (rdbtnothersgender.isChecked()) {
                     savestring = rdbtnothersgender.getText().toString();
                 }
              {
                         if(rdbtnstudent.isChecked()){
                             savestring=rdbtnstudent.getText().toString();
                         }
                         else  if(rdbtnemployed.isChecked()){
                             savestring=rdbtnemployed.getText().toString();
                         }
                         else  if(rdbtnothersrole.isChecked()){
                             savestring=rdbtnothersgender.getText().toString();
                         }
             }
         }
         });

        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(account.this, Home.class);
                startActivity(intent);

            }
        });

        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);

        editdateofbirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog dialog = new DatePickerDialog(account.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayofmonth) {
                        String date = dayofmonth + "/" + month + "/" + year;
                        editdateofbirth.setText(date);
                    }
                },year,month,day);
                dialog.show();
            }
        });
    btnsave.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(account.this, "Account Details saved Successfully", Toast.LENGTH_SHORT).show();
        }
    });
    }


    private boolean validate() {
        boolean valid = true;

        editname.setError(null);
        editdateofbirth.setError(null);

        valid = validateField(editname, "Please enter the Name") && valid;
        valid = validateField(editdateofbirth, "Please enter date of birth") && valid;

        return valid;
    }
    private  boolean validateField(EditText editText,String errorMessage) {
        String text = editText.getText().toString();
        if (TextUtils.isEmpty(text)) {
            editText.setError(errorMessage);
            editText.requestFocus();
            return false;
        }
        return true;
    }
}

