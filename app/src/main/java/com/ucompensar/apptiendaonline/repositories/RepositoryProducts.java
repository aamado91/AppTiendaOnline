package com.ucompensar.apptiendaonline.repositories;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.ucompensar.apptiendaonline.entities.Product;

import java.util.ArrayList;
import java.util.List;

public class RepositoryProducts extends RepositoryBase {

    public RepositoryProducts(Context context){
        super(context);
    }

    public long createProduct(Product product) throws Exception {
        long id = 0;

        SQLiteDatabase db = getWritable();

        ContentValues values = new ContentValues();
        values.put("name", product.getName());
        values.put("price", product.getPrice());
        values.put("state", product.getState());
        values.put("image", product.getImage());

        id = db.insert(TABLE_PRODUCTS, null, values);

        return id;
    }

    public List<Product> getProducts(){

        List<Product> listProducts = new ArrayList<>();

        SQLiteDatabase db = getReadable();
        String strQuery = String.format("SELECT * FROM %s", TABLE_PRODUCTS);
        Cursor cursor = db.rawQuery(strQuery, null);

        if (cursor.moveToNext()){
            Product product = new Product(cursor);
            listProducts.add(product);
        }
        return listProducts;
    }
}

