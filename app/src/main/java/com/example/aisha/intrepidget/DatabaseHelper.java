package com.example.aisha.intrepidget;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.InputStream;

/**
 * Created by Aisha on 12/10/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    //declare variables to assign to database
    public  static  final  String DATABASE_NAME= "travel.db";
    public  static  final  String TABLE_NAME = "travel_table";
    public  static  final  String COL_1_ID = "ID";
    public  static  final  String COL_2_CITY = "CITY";
    public  static  final  String COL_3_DURATION = "DURATION";
    public  static  final  String COL_4_MONTH_YEAR= "MONTHYEAR";


    //whenever this constructor is called, database is created
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        //create database table
        //SQLiteDatabase db = this.getWritableDatabase();
    }

    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME +" ( "+ COL_1_ID +
            " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_2_CITY + " VARCHAR(225), " +
            COL_3_DURATION + " VARCHAR(225), " + COL_4_MONTH_YEAR + " VARCHAR(225));";

    @Override
    public void onCreate(SQLiteDatabase db) {
        //create database table whenever this function is called
        //execute the query passed as the parameter
        try{
            db.execSQL(CREATE_TABLE);
        } catch (SQLException e){
            //return something
        }
    }

    private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String city, String duration, String monthYear ){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2_CITY, city);
        contentValues.put(COL_3_DURATION, duration);
        contentValues.put(COL_4_MONTH_YEAR, monthYear);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME, null);
        return res;
    }

    public boolean updateData(String id, String city, String duration, String monthYear){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1_ID, id);
        contentValues.put(COL_2_CITY, city);
        contentValues.put(COL_3_DURATION, duration);
        contentValues.put(COL_4_MONTH_YEAR, monthYear);
        db.update(TABLE_NAME, contentValues, "ID = ?", new String[]{ id } );
        return true;
    }

    public Integer deleteData(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?", new String[]{ id });
    }
}
