package com.example.course_learning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class Personal extends AppCompatActivity {
    String personalList[] = {"Creative Thinking","Leadership Principles"};
    int personalImages[] = {R.drawable.creativethinking,R.drawable.leadership};

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);
        listView = (ListView) findViewById(R.id.Softwarelistview);


        SoftwareBaseAdapter softwareBaseAdapter = new SoftwareBaseAdapter(getApplicationContext(),personalList,personalImages);
        listView.setAdapter(softwareBaseAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                if (position == 0) {
                    Intent intent = new Intent(Personal.this, Creativethinking.class);
                    startActivity(intent);
                } else if (position == 1) {
                    Intent intent1 = new Intent(Personal.this, Leadership.class);
                    startActivity(intent1);
                }
            }
        });
    }
}