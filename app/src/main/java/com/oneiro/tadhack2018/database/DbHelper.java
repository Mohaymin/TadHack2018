package com.oneiro.tadhack2018.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.oneiro.tadhack2018.database.TablesContract.*;
public class DbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "prescription_folder.db";
    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String SQL_CREATE_PRESCRIPTION_TABLE = "CREATE TABLE "
                + PrescriptionEntry.TABLE_NAME + " ( "
                + PrescriptionEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + PrescriptionEntry.COLUMN_COMPLAINT + " TEXT NOT NULL, "
                + PrescriptionEntry.COLUMN_MEDICINE + " TEXT );";
        sqLiteDatabase.execSQL(SQL_CREATE_PRESCRIPTION_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
