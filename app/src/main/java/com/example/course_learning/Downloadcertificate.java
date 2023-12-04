package com.example.course_learning;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;

public class Downloadcertificate extends AppCompatActivity {

    private static int REQUEST_CODE = 100;


    ImageView imageView;
    Button downloadbutton;

   OutputStream outputStream;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_downloadcertificate);

        imageView = findViewById(R.id.imageView);
        downloadbutton = findViewById(R.id.downloadbutton);

        downloadbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(Downloadcertificate.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                    saveImage();
                } else {
                    askPermission();
                }
            }
        });

    }


    private void askPermission() {

       ActivityCompat.requestPermissions(Downloadcertificate.this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},REQUEST_CODE);


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                saveImage();
            } else {
                Toast.makeText(Downloadcertificate.this, "Please provide the required permission", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void saveImage() {

       File dir = new File(Environment.getExternalStorageDirectory(),"SaveImage");
       if(!dir.exists()){
           dir.mkdir();
       }
       BitmapDrawable drawable = (BitmapDrawable) imageView.getDrawable();
       Bitmap bitmap = drawable.getBitmap();

       File file = new File(dir,System.currentTimeMillis()+".jpg");
        try {
            outputStream = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,outputStream);
       Toast.makeText(Downloadcertificate.this,"Successfully Saved Image",Toast.LENGTH_SHORT).show();
        try {
            outputStream.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            outputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}