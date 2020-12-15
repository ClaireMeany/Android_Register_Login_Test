package com.example.wildlifegps;

import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.net.Uri;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;

public class DBHandler extends SQLiteOpenHelper {

        //information of database
        private static final int DATABASE_VERSION = 1;
        private static final String DATABASE_NAME = "WildlifeDB.db";
        public static final String TABLE_NAME_USERS = "Users";
        public static final String COLUMN_USERNAME = "Username";
        public static final String COLUMN_PASSWORD = "Password";
        //initialize the database
        public DBHandler(Context context) {
            super(context, DATABASE_NAME, null, 1);
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("create table Users ("
                    +"username varchar(30) primary key,"
                    +"password varchar(80) not null"
            +")");

    }

    //ADD
    public void addUser(User user){
        SQLiteDatabase db = this.getWritableDatabase();
        String username=user.getUsername();
        String password=user.getPassword();

        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);

        db.insert(TABLE_NAME_USERS, null, contentValues);
        db.close();

    }

    //SEARCH
    //for registering an account check if username is taken
    public boolean searchUsername(String username){
        boolean bool=false;
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT username FROM "+ TABLE_NAME_USERS + " WHERE username = '" + username+"'",null);
        bool=cursor.moveToFirst();

        cursor.close();
        return bool;
    }
    //for login credentials
    public boolean searchUser(String username, String password) {
        boolean bool = false;
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM "+ TABLE_NAME_USERS + " WHERE username = '" + username + "' AND password = '" + password +"'",null);
        bool=cursor.moveToFirst();

        //db.close();
        cursor.close();
        db.close();
        return bool;

    }
        public void onUpgrade(SQLiteDatabase db, int i, int i1) {}

}
