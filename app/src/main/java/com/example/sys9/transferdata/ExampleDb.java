package com.example.sys9.transferdata;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ExampleDb extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "sample_db";
    private static final String TABLENAME = "student";
    private static final String NAME = "USERNAME";
    private static final String COLLEGE_NAME = "COLLEGENAME";
    private static final String BRANCH_NAME = "BRANCHNAME";

    public ExampleDb(Context context) {
        super(context,DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " +TABLENAME+ "("
                + NAME + " TEXT, "
                + COLLEGE_NAME + " TEXT,"
                + BRANCH_NAME + " TEXT "
                + ")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table exists"+TABLENAME);
        onCreate(sqLiteDatabase);

    }
    public void insert(String name,String college,String branch){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(NAME,name);
        contentValues.put(COLLEGE_NAME,college);
        contentValues.put(BRANCH_NAME,branch);
        sqLiteDatabase.insert(TABLENAME,null,contentValues);
    }
}





