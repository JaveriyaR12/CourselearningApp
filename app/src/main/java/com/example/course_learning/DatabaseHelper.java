package com.example.course_learning;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import org.jetbrains.annotations.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String databaseName = "signLog.db";


    public DatabaseHelper(@Nullable Context context) {
        super(context, databaseName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MYDatabase) {
        MYDatabase.execSQL("create Table users(email TEXT primary key,password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int oldVersion, int newVersion) {
        MyDB.execSQL("drop Table if exists users");
    }

    public Boolean insertData(String email, String password) {
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email", email);
        contentValues.put("password", password);
        long result = MyDatabase.insert("users", null, contentValues);

        return result != -1;
    }



        public Boolean checkEmail (String email){
            SQLiteDatabase MyDatabase = this.getWritableDatabase();
            Boolean emailExits;
            try (Cursor cursor = MyDatabase.rawQuery("select * from users where email = ?", new String[]{email})) {
                emailExits = cursor.getCount() > 0;
            }

            return emailExits;
        }
        public Boolean checkEmailpassword (String email, String password){
            SQLiteDatabase MyDatabase = this.getWritableDatabase();
            Cursor cursor = MyDatabase.rawQuery("select * from users where email = ? and password = ?", new String[]{email, password});
            boolean isValid = cursor.getCount() > 0;
            cursor.close();
            return isValid;
        }
    }





