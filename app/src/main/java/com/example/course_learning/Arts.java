package com.example.course_learning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class Arts extends AppCompatActivity {

    String artsList[] = {"Philosophy","Art","GraphicDesign"};
    int artsImages[] = {R.drawable.philosophy,R.drawable.artdesign,R.drawable.graphicdesign};

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_software);

        listView = (ListView) findViewById(R.id.Softwarelistview);


        SoftwareBaseAdapter softwareBaseAdapter = new SoftwareBaseAdapter(getApplicationContext(),artsList,artsImages);
        listView.setAdapter(softwareBaseAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                if (position == 0) {
                    Intent intent = new Intent(Arts.this, Philosophy.class);
                    startActivity(intent);
                }
                else if (position == 1) {
                    Intent intent1 = new Intent(Arts.this, Artart.class);
                    startActivity(intent1);
                }
                else if (position == 2) {
                    Intent intent2 = new Intent(Arts.this, Graphicdesign.class);
                    startActivity(intent2);
                }

            }
        });
    }
}