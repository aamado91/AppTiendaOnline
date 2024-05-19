package com.ucompensar.apptiendaonline.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 4;
    private static final String DATABASE_NAME = "online_store_4.db";
    public static final String TABLE_CUSTOMERS = "t_customers";
    public static final String TABLE_PRODUCTS = "t_products";

    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Creation of tables
        String strDdlTableCustomers = String.format("CREATE TABLE %s (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL, gender INTEGER NOT NULL, email TEXT NOT NULL, phone TEXT NOT NULL, password TEXT NOT NULL)", TABLE_CUSTOMERS);
        String strDdlTableProducts = String.format("CREATE TABLE %s (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL, price TEXT NOT NULL, state TEXT NOT NULL, image INTEGER NULL)", TABLE_PRODUCTS);
        db.execSQL(strDdlTableCustomers);
        db.execSQL(strDdlTableProducts);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Delete tables if exists
        db.execSQL(String.format("DELETE TABLE %s", TABLE_CUSTOMERS));
        db.execSQL(String.format("DELETE TABLE %s", TABLE_PRODUCTS));

        // Call the onCreate method to create a new instance of tables
        onCreate(db);
    }
}
