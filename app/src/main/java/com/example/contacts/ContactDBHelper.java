package com.example.contacts;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ContactDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME= "mycontacts.db";
    private static final int VERSION_NUMBER = 1;
    private static final String CREATE_CONTACT_TABLE =
            "create table contact(" +
            "id integer primary key autoincrement, "+
            "contactname text not null, " +
            "streetaddress text, " +
            "city text, " +
            "state text, " +
            "zipcode text, " +
            "homephone text, " +
            "cellnumber text, " +
            "email text, " +
            "birthday text); ";

    public ContactDBHelper(Context context){
        super(context, DATABASE_NAME, null, VERSION_NUMBER);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_CONTACT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
