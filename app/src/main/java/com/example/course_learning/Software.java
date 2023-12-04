package com.example.course_learning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Software extends AppCompatActivity {
    String softwareList[] = {"Dataanalyst","Python","Fullstack","UXdesign","Deeplearning"};
    int softwareImages[] = {R.drawable.javascript,R.drawable.python,R.drawable.fullstack,R.drawable.uxdesign,R.drawable.deeplearning};

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_software);

        listView = (ListView) findViewById(R.id.Softwarelistview);


       SoftwareBaseAdapter softwareBaseAdapter = new SoftwareBaseAdapter(getApplicationContext(),softwareList,softwareImages);
       listView.setAdapter(softwareBaseAdapter);
       listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


               if (position == 0) {
                   Intent intent = new Intent(Software.this, DataAnalayst.class);
                   startActivity(intent);
               }
               else if (position == 1) {
                   Intent intent1 = new Intent(Software.this, Python.class);
                   startActivity(intent1);
           }
               else if (position == 2) {
                   Intent intent2 = new Intent(Software.this, Fullstack.class);
                   startActivity(intent2);
       }
               else if (position == 3) {
                   Intent intent3 = new Intent(Software.this, Uxdesign.class);
                   startActivity(intent3);
               }
               else if (position == 4) {
                   Intent intent4 = new Intent(Software.this, Deeplearning.class);
                   startActivity(intent4);
               }
    }
});
    }
}

















