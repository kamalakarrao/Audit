package com.hksapps.audit;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import static com.hksapps.audit.Constants.DATABASE_NAME;

/**
 * Created by Administrator on 7/31/2017.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    public DatabaseHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_WORKAREA_TABLE = "CREATE TABLE " + Constants.TABLE_WORKAREA + "("
                + Constants.KEY_ID + " INTEGER PRIMARY KEY," + Constants.KEY_CHECKLIST + " TEXT,"
                + Constants.KEY_YES + " TEXT" + Constants.KEY_NO + " TEXT" + Constants.KEY_REMARKS + " TEXT" + ")";
        db.execSQL(CREATE_WORKAREA_TABLE);






    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + Constants.TABLE_WORKAREA);

        // Create tables again
        onCreate(db);

    }


    public boolean IsWorkAreaTableEmpty(){
        SQLiteDatabase db = this.getWritableDatabase();
        String count = "SELECT count(*) FROM " + Constants.TABLE_WORKAREA;;
        Cursor mcursor = db.rawQuery(count, null);
        mcursor.moveToFirst();
        int icount = mcursor.getInt(0);
        if(icount>0){
          return false;
        }else
            return true;
    }


    public void addChecklists(CheckList checklist) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Constants.KEY_CHECKLIST, checklist.getChecklist());


        // Inserting Row
        db.insert(Constants.TABLE_WORKAREA, null, values);
        db.close(); // Closing database connection


    }

    // Getting All Contacts
    public List<CheckList> getAllChecklists() {
        List<CheckList> chklist = new ArrayList<CheckList>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + Constants.TABLE_WORKAREA;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                CheckList checkList = new CheckList();
                checkList.setId(Integer.parseInt(cursor.getString(0)));
                checkList.setChecklist(cursor.getString(1));

             /*   checkList.setYes(cursor.getString(2));
                checkList.setNo(cursor.getString(3));
                checkList.setRemarks(cursor.getString(4));*/
                // Adding contact to list
                chklist.add(checkList);
            } while (cursor.moveToNext());
        }


        // return contact list
        return chklist;
    }
}


