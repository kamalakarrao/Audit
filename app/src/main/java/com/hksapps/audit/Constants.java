package com.hksapps.audit;

import android.app.Activity;

import static com.hksapps.audit.MainActivity.databaseName;

/**
 * Created by Administrator on 7/31/2017.
 */

public class Constants extends Activity {





    public static final String DATABASE_NAME = databaseName;

    public static final String TABLE_WORKAREA = "workarea";
    public static final String TABLE_SERVERROOM = "serverroom";
    public static final String TABLE_ELECTRICALROOM = "electricalrroom";
    public static final String TABLE_SECURITYROOM = "securityroom";
    public static final String TABLE_UPSROOM = "upsroom";
    public static final String TABLE_COMMONAREA = "commonarea";


    public static final String KEY_ID = "id";
    public static final String KEY_CHECKLIST = "Checklist";
    public static final String KEY_YES = "Yes";
    public static final String KEY_NO = "No";
    public static final String KEY_REMARKS = "Remarks";
}