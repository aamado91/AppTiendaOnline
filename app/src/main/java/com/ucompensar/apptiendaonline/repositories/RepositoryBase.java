package com.ucompensar.apptiendaonline.repositories;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.Nullable;
import com.ucompensar.apptiendaonline.db.DbHelper;

public class RepositoryBase extends DbHelper {

    public Context context;

    public RepositoryBase(@Nullable Context context){
        super(context);
        this.context = context;
    }

    public SQLiteDatabase getWritable(){
        return this.getWritableDatabase();
    }

    public SQLiteDatabase getReadable(){
        return this.getReadableDatabase();
    }
}
