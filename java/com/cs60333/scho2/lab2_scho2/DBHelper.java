package com.cs60333.scho2.lab2_scho2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.Settings;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {

    public static String DATABASE_NAME = "books.db";
    public static int DATABASE_VERSION = 1;
    public static String TABLE_BOOK = "Team";
    public static String COL_NAME = "book_name";
    public static String COL_ID_0 = "_id";
    public static String COL_ID_1 = "school";
    public static String COL_ID_2 = "logo";
    public static String COL_ID_3 = "mascot";
    public static String COL_ID_4 = "oppRecord";
    public static String COL_ID_5 = "ndRecord";
    public static String COL_ID_6 = "score";
    public static String COL_ID_7 = "longDate";
    public static String COL_ID_8 = "date";
    public static String COL_ID_9 = "location";
    public static String TABLE_IMAGES = "Book_Images";
    public static String COL_IMAGE = "image_name";
    public static String COL_IMAGE_ID = "_id";
    public static String COL_BOOK_ID = "book_id";

    public DBHelper (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_BOOK + " ( " + COL_ID_0 + " INTEGER, " + COL_ID_1 + " TEXT, " + COL_ID_2 + " TEXT, " + COL_ID_3 + " TEXT, " + COL_ID_4 + " TEXT, " + COL_ID_5 + " TEXT, " + COL_ID_6 + " TEXT, " + COL_ID_7 + " TEXT, " + COL_ID_8 + " TEXT, " + COL_ID_9 + " TEXT )");
        //db.execSQL("CREATE TABLE " + TABLE_IMAGES + " ( " + COL_IMAGE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COL_BOOK_ID + " INTEGER, " +  COL_IMAGE + " TEXT, PRIMARY KEY ( " + COL_ID_0 + ")  )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE if exists " + TABLE_BOOK );
        db.execSQL("DROP TABLE if exists " + TABLE_IMAGES );
        onCreate(db);
    }

//    public void insertData(String tblname, ContentValues contentValues)
    public void insertData(String tblname, Integer id, String[] ex) {
        SQLiteDatabase db = getWritableDatabase();

        db.execSQL("INSERT INTO " + TABLE_BOOK + " VALUES ( " + id + ", " + ex[0] + ", " + ex[1] + ", " + ex[2] + ", " + ex[3] + ", " + ex[4] + ", " + ex[5] + ", " + ex[5] + ", " + ex[5] + ", " + ex[8] + " )");
        //long ret = db.insert(tblname, null, contentValues );

//        if (ret > -1) {
//            System.out.println("Successfully inserted");
//        } else {
//            System.out.println("Insert Unsuccessful");
//        }
        Log.d("help1", ex[0]);
        db.close();
    }

    public void deleteData(String tblname, String clause, int _id) {
        SQLiteDatabase db = getWritableDatabase();

        db.delete(tblname, clause, new String[]{Integer.toString(_id)});
        db.close();
    }


    public Cursor getAllEntries(String tblname, String[] columns) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(tblname, columns, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    public Cursor getSelectEntries(String tblname, String[] columns, String where, String[] args) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(tblname, columns, where, args, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    public String[] getTableFields(String tblname) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor dbCursor = db.query(tblname, null, null, null, null, null, null);
        String[] columnNames = dbCursor.getColumnNames();
        return columnNames;
    }

}
