package com.example.course_learning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class Businessmarketing extends AppCompatActivity {
    String BusinessList[] = {"Digital Marketing","Business Marketing"};
    int BusinessImages[] = {R.drawable.marketing,R.drawable.businessmarketing};
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_businessmarketing);

        listView = (ListView) findViewById(R.id.Businessmarketlistview);


        SoftwareBaseAdapter softwareBaseAdapter = new SoftwareBaseAdapter(getApplicationContext(),BusinessList,BusinessImages);
        listView.setAdapter(softwareBaseAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                if (position == 0) {
                    Intent intent = new Intent(Businessmarketing.this, Digitalmarketing.class);
                    startActivity(intent);
                } else if (position == 1) {
                    Intent intent1 = new Intent(Businessmarketing.this, Marketing.class);
                    startActivity(intent1);

                }
            }
        });
    }
}