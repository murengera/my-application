package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Mydatabase extends SQLiteOpenHelper {

    public  static final String DATABASE_NAME = "employe.db";
    public static final String TABLE_NAME = "register";
    public static  final String COL_1 = "ID";
    public static  final String COL_2 = "Firstname";
    public static  final String COL_3 = "Lastname";
    public static  final String COL_4 = "Password";
    public static  final String COL_5 = "Email";
    public static  final String COL_6 = "Phone";

    public Mydatabase(Context context ) {
        super(context , DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
   db.execSQL(" CREATE TABLE " + TABLE_NAME + "(ID INTEGER PRIMARY KEY  AUTOINCREMENT , Firstname TEXT, Lastname TEXT, Password TEXT, Email TEXT, Phone TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }
}