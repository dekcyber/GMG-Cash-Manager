package com.example.peera_000.gmgcashmanager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by peera_000 on 7/4/2558.
 */
public class OpenHelper extends SQLiteOpenHelper {
    //Explicit
    private static final String DATABASE_NAME = "GMG";
    private static final int DATABASE_VERSION = 1;
    private static final String CREATE_TABLE = "create table UserTABLE (_id integer primary key, Password integer);";

    public OpenHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }//OnCreate

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }//OnUpgrade




    public void onCREATE(SQLiteDatabase db){
        db.execSQL(CREATE_TABLE);
    } // onCreate
}
