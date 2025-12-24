package app.sixthbca.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "MyDatabase.db";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "user";
    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // create table table_name;
        String query = "CREATE TABLE user (id INTEGER PRIMARY KEY, name TEXT, address TEXT, contact INTEGER);";
        db.execSQL(query);
    }

    public void insertUSer(String name,String address,int contact){
//        String insertQuery = "INSERT INTO user (name, address, contact) VALUES (?, ?, ?);";
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values =new ContentValues();
        values.put("name",name);
        values.put("address",address);
        values.put("contact",contact);
        db.insert(TABLE_NAME, null,values);
    }

    public Cursor getAllUser(){
        // SELECT * FROM user;
        SQLiteDatabase db = getReadableDatabase();
        Cursor sabaiData = db.rawQuery("SELECT * FROM user", null);
        return sabaiData;
    }

    public void updateUser(int id, String newName, String address){
        //update user set name = "jack" where id = 1;
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", newName);
        values.put("address", address);
        db.update(TABLE_NAME, values, "id = ?", new String[]{String.valueOf(id)});
    }

    public void deleteUser(int id){
        //delete from user where id=2;
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_NAME, "id = ?", new String[]{String.valueOf(id)});
       // db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}