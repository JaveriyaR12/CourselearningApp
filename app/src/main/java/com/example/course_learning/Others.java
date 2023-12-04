package com.example.course_learning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class Others extends AppCompatActivity {
    String othersList[] = {"Health and fitness"};
    int softwareImages[] = {R.drawable.healthfitness};
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_others);

        listView = (ListView) findViewById(R.id.Otherslistview);


        SoftwareBaseAdapter softwareBaseAdapter = new SoftwareBaseAdapter(getApplicationContext(),othersList,softwareImages);
        listView.setAdapter(softwareBaseAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                if (position == 0) {
                    Intent intent = new Intent(Others.this, Healthandfitness.class);
                    startActivity(intent);
                }
            }
        });
    }
}