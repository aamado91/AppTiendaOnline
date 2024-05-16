package com.ucompensar.apptiendaonline.repositories;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.ucompensar.apptiendaonline.entities.Customer;

public class RepositoryCustomer extends RepositoryBase {

    public RepositoryCustomer(Context context){
        super(context);
    }

    public long createCustomer(Customer customer) throws Exception {
        long id = 0;

        SQLiteDatabase db = getWritable();

        ContentValues values = new ContentValues();
        values.put("name", customer.getName());
        values.put("email", customer.getEmail());
        values.put("phone", customer.getPhone());
        values.put("password", customer.getPassword());

        id = db.insert(TABLE_CUSTOMERS, null, values);

        return id;
    }

    public Customer getCustomerByLogin(String email){

        Customer customer = null;
        SQLiteDatabase db = getReadable();
        String strQuery = String.format("SELECT * FROM %s WHERE email = '%s'", TABLE_CUSTOMERS, email);
        Cursor cursor = db.rawQuery(strQuery, null);

        if (cursor.moveToFirst()){
            customer = new Customer(cursor);
        }
        return customer;
    }
}
