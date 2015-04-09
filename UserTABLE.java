package com.example.peera_000.gmgcashmanager;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.net.ContentHandler;

/**
 * Created by peera_000 on 7/4/2558.
 */
public class UserTABLE {

    //Explicit
    private OpenHelper objOpenHelper;
    private SQLiteDatabase writeSQLite,readSQLite;
    private String StrCheckSamePassword;

    public static final String TABLE_USER = "UserTABLE";
    public static final String COLUMN_ID = "User_id";
    public static final String COLUMN_PASS = "Password";
    public  UserTABLE(Context context)
    {
        objOpenHelper = new OpenHelper(context);
        writeSQLite = objOpenHelper.getWritableDatabase();
        readSQLite = objOpenHelper.getReadableDatabase();
    }//Contractor

    public String CheckSamePassword() {
        Cursor objCursor = readSQLite.query(TABLE_USER,new String[]{COLUMN_PASS},null,null,null,null,null);
        if (objCursor != null) {
            objCursor.moveToLast();
             StrCheckSamePassword = objCursor.getString(objCursor.getColumnIndex(COLUMN_PASS));
        }

        return StrCheckSamePassword;
    }
    public boolean CheckCursor(){

        Cursor objCursor = readSQLite.query(TABLE_USER, new String[] {COLUMN_PASS},null,null,null,null,null);

        if (objCursor != null){

            objCursor.moveToLast();
        }

        return objCursor.isBeforeFirst();
    }

    //Add New Password
    public long AddNewPassword(Integer intPassword){

       ContentValues objContentValue = new ContentValues();
        objContentValue.put(COLUMN_PASS,intPassword);

        return writeSQLite.insert(TABLE_USER,null,objContentValue);
    }
}//Main Class
