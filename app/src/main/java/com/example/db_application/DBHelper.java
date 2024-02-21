package com.example.db_application;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(@Nullable Context context) {
        super(context, "savandb", null, 1);
    }

    SQLiteDatabase db=this.getWritableDatabase();


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE STUDENT(ID INTEGER  PRIMARY KEY  AUTOINCREMENT,NAME TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
//insert
    public void insertdata(String nm){
        ContentValues cv=new ContentValues();
        cv.put("NAME",nm);
        db.insert("STUDENT",null,cv);
    }
//display
    public Cursor viewAll(){

       Cursor c=db.rawQuery("SELECT * FROM STUDENT",null);
       return c;
    }
//update
    public void UpdateData(String nm,String id){
        ContentValues cv=new ContentValues();
        cv.put("NAME",nm);
        db.update("STUDENT",cv,"ID=?",new String[]{id});
    }
//delete
    public void DeletData(String id){

        db.delete("STUDENT","ID=?",new String[]{id});
    }


}
