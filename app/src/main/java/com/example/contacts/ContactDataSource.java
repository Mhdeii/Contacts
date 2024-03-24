package com.example.contacts;

import android.database.sqlite.SQLiteDatabase;

public class ContactDataSource {
    SQLiteDatabase database;
    ContactDBHelper dbHelper;

    public void open(){
        database = dbHelper.getWritableDatabase(); //writable  can create and onUpgrade it checks what to call and excute
    }

    public void close(){
        database.close();
    }
}
