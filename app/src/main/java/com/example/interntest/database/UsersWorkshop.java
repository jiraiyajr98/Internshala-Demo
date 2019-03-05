package com.example.interntest.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class UsersWorkshop extends SQLiteOpenHelper {

    //Current Single Table Name
    private static final String table_name = "MYWorkshops";


    private static final String WORKSHOP_NAME = "WORKSHOP_NAME";

    private static final String TAG = "SQLDB";


    public UsersWorkshop(Context context){
        super(context,table_name,null,1);
    }

    //OnCreate Interface Overridden
    @Override
    public void onCreate(SQLiteDatabase db) {

        String create_table="CREATE TABLE IF NOT EXISTS "+table_name+"(_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                WORKSHOP_NAME +" TEXT)";
        db.execSQL(create_table);

    }

    //Add to this particular table
    public void addsqlData(String name){

        /*
        Content Values to create a structural key value format for easy  insertion of data.

        Reinitialize to avoid null pointer exception.

         */

        reinit();
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(WORKSHOP_NAME,name);
        db.insert(table_name,null,cv);
        db.close();
        Log.d(TAG,"Inserting "+name);
    }

    //Check if table is empty or not.
    public boolean isEmpty(){

        boolean empty = true;
        reinit();

        try (Cursor cur = this.getReadableDatabase().rawQuery("SELECT COUNT(*) FROM " + table_name, null)) {

            if (cur != null && cur.moveToFirst()) {
                empty = (cur.getInt(0) == 0);
                cur.close();
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }


        return empty;
    }

    //Get a Cursor of Data's
    public Cursor getAllData(){

        reinit();
        SQLiteDatabase db=this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM "+table_name,null);

    }

    //Usually not required but if upgrade is made.
    //Drop the table and recreate it
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+table_name);
        onCreate(db);
        db.close();
    }

    //Delete the current Table
    public void del_table(){
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS "+table_name);
        Log.d("SQLITE","Table Dropped");
        db.close();
    }


    //Reinitialize Database to avoid null pointer exception
    private void reinit(){

        SQLiteDatabase db=this.getReadableDatabase();

        String create_table="CREATE TABLE IF NOT EXISTS "+table_name+"(_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                WORKSHOP_NAME +" TEXT)";
        db.execSQL(create_table);
        db.close();
    }
}