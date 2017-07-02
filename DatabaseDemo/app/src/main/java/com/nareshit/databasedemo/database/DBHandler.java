package com.nareshit.databasedemo.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler extends SQLiteOpenHelper {
    SQLiteDatabase db = null;

    public DBHandler(Context context) {
        super(context, "ManiDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table Student(" +
                "email Text primary key," +
                "password Text," +
                "address Text," +
                "phone Text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVer, int newVer) {
    }

    public long insertStudentRec(String email, String password, String address, String phone) {
        db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("email", email);
        cv.put("password", password);
        cv.put("address", address);
        cv.put("phone", phone);
        long id = db.insert("Student", null, cv);
        return id;
    }

    public boolean loginCrediantials(String email, String password) {
        db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from Student where email=? AND password=?", new String[]{email, password});
        if (cursor != null) {
            if (cursor.getCount() > 0) {
                return true;
            }
        }
        return false;
    }


    public long updateRec(String email, String phone, String address) {
        db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("phone", phone);
        cv.put("address", address);

        long id = db.update("Student", cv, "email=?", new String[]{email});
        return id;
    }

    public long deleteRec(String email) {
        db = this.getWritableDatabase();

        long id = db.delete("Student", "email=?", new String[]{email});
        return id;
    }
}