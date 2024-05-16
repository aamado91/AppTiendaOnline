package com.ucompensar.apptiendaonline.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "online_store.db";
    public static final String TABLE_CUSTOMERS = "t_customers";

    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Creation of tables
        String strDdlTableCustomers = String.format("CREATE TABLE %s (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL, email TEXT NOT NULL, phone TEXT NOT NULL, password TEXT NOT NULL)", TABLE_CUSTOMERS);

        db.execSQL(strDdlTableCustomers);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Delete tables if exists
        db.execSQL(String.format("DELETE TABLE %s", TABLE_CUSTOMERS));

        // Call the onCreate method to create a new instance of tables
        onCreate(db);
    }
}
