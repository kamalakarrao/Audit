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
    Context ctx;
    public DatabaseHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
         ctx = context;

    }


    @Override
    public void onCreate(SQLiteDatabase db) {

       CreateTable(db,Constants.TABLE_WORKAREA);
       CreateTable(db,Constants.TABLE_SERVERROOM);
       CreateTable(db,Constants.TABLE_ELECTRICALROOM);
       CreateTable(db,Constants.TABLE_SECURITYROOM);
       CreateTable(db,Constants.TABLE_UPSROOM);
       CreateTable(db,Constants.TABLE_COMMONAREA);






    }

    private void CreateTable(SQLiteDatabase db,String table_name){

        String CREATE_WORKAREA_TABLE = "CREATE TABLE " + table_name + "("
                + Constants.KEY_ID + " INTEGER PRIMARY KEY," + Constants.KEY_CHECKLIST + " TEXT,"
                + Constants.KEY_YES + " TEXT," + Constants.KEY_NO + " TEXT," + Constants.KEY_REMARKS + " TEXT" + ")";
        db.execSQL(CREATE_WORKAREA_TABLE);

    }


    private void DropTable(SQLiteDatabase db,String table_name){

        db.execSQL("DROP TABLE IF EXISTS " + table_name);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        // Drop older table if existed
     DropTable(db,Constants.TABLE_WORKAREA);
     DropTable(db,Constants.TABLE_SERVERROOM);
     DropTable(db,Constants.TABLE_ELECTRICALROOM);
     DropTable(db,Constants.TABLE_SECURITYROOM);
     DropTable(db,Constants.TABLE_UPSROOM);
     DropTable(db,Constants.TABLE_COMMONAREA);


        // Create tables again
        onCreate(db);

    }


    public boolean IsTableEmpty(String table_name){
        SQLiteDatabase db = this.getWritableDatabase();
        String count = "SELECT count(*) FROM " + table_name;;
        Cursor mcursor = db.rawQuery(count, null);
        mcursor.moveToFirst();
        int icount = mcursor.getInt(0);
        if(icount>0){
          return false;
        }else
            return true;
    }


    public void addChecklists(CheckList checklist,String table_name) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Constants.KEY_CHECKLIST, checklist.getChecklist());
        values.put(Constants.KEY_YES, " ");
        values.put(Constants.KEY_NO, " ");
        values.put(Constants.KEY_REMARKS, " ");


        // Inserting Row
        db.insert(table_name, null, values);
        db.close(); // Closing database connection



    }


    public void addAnswers(CheckList checklist,String table_name,int id) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Constants.KEY_YES, checklist.getYes());
        values.put(Constants.KEY_NO, checklist.getNo());
        values.put(Constants.KEY_REMARKS, checklist.getRemarks());


        // Inserting Row
        db.update(table_name,values, "id="+id , null);
        db.close(); // Closing database connection



    }







    // Getting All Contacts
    public List<CheckList> getAllChecklists(String table_name) {
        List<CheckList> chklist = new ArrayList<CheckList>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + table_name;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                CheckList checkList = new CheckList();
                checkList.setId(Integer.parseInt(cursor.getString(0)));
                checkList.setChecklist(cursor.getString(1));

                checkList.setYes(cursor.getString(2));
                checkList.setNo(cursor.getString(3));
                checkList.setRemarks(cursor.getString(4));
                // Adding contact to list
                chklist.add(checkList);
            } while (cursor.moveToNext());
        }


        // return contact list
        return chklist;
    }
}


