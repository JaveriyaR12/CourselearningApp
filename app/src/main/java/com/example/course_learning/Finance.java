package com.example.course_learning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class Finance extends AppCompatActivity {

    String financeList[] = {"FinancialManagement", "BusinessMathematics", "AdvanceAccounting", "FinanceAnalyst", "FinanceTrading"};
    int financeImages[] = {R.drawable.businesslistview, R.drawable.businessmaths, R.drawable.accounting, R.drawable.financeanalyst, R.drawable.financetrading};

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finance);

        listView = (ListView) findViewById(R.id.financelistview);


        SoftwareBaseAdapter softwareBaseAdapter = new SoftwareBaseAdapter(getApplicationContext(), financeList, financeImages);
        listView.setAdapter(softwareBaseAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                if (position == 0) {
                    Intent intent = new Intent(Finance.this, Financemanagement.class);
                    startActivity(intent);
                } else if (position == 1) {
                    Intent intent1 = new Intent(Finance.this, Financemaths.class);
                    startActivity(intent1);
                } else if (position == 2) {
                    Intent intent2 = new Intent(Finance.this, Accounting.class);
                    startActivity(intent2);
                } else if (position == 3) {
                    Intent intent3 = new Intent(Finance.this, Financeanalyst.class);
                    startActivity(intent3);
                } else if (position == 4) {
                    Intent intent4 = new Intent(Finance.this, Financetrading.class);
                    startActivity(intent4);
                }
            }
        });
    }
}