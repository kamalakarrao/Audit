package com.hksapps.audit;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.ajts.androidmads.library.SQLiteToExcel;

public class MainActivity extends AppCompatActivity {

    public static String databaseName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        databaseName = pref.getString("database_name", "None");

        setTitle(databaseName);



        TextView WorkArea = (TextView) findViewById(R.id.workarea);
        TextView ServerRoom = (TextView) findViewById(R.id.serverroom);
        TextView ElectricalRoom = (TextView) findViewById(R.id.electricalroom);
        TextView SecurityRoom = (TextView) findViewById(R.id.securityroom);
        TextView UpsRoom = (TextView) findViewById(R.id.upsroom);
        TextView CommonArea = (TextView) findViewById(R.id.commonarea);
        TextView HubRoom = (TextView) findViewById(R.id.hubroom);

        Button exp = (Button) findViewById(R.id.export);


        WorkArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
                SharedPreferences.Editor editor = pref.edit();
                editor.putInt("questions_screen", 1);
                editor.commit();

                Intent i = new Intent(MainActivity.this, Questions.class);
                startActivity(i);

            }
        });


        ServerRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
                SharedPreferences.Editor editor = pref.edit();
                editor.putInt("questions_screen", 2);
                editor.commit();

                Intent i = new Intent(MainActivity.this, Questions.class);
                startActivity(i);

            }
        });


        ElectricalRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
                SharedPreferences.Editor editor = pref.edit();
                editor.putInt("questions_screen", 3);
                editor.commit();

                Intent i = new Intent(MainActivity.this, Questions.class);
                startActivity(i);

            }
        });


        SecurityRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
                SharedPreferences.Editor editor = pref.edit();
                editor.putInt("questions_screen", 4);
                editor.commit();

                Intent i = new Intent(MainActivity.this, Questions.class);
                startActivity(i);

            }
        });


        UpsRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
                SharedPreferences.Editor editor = pref.edit();
                editor.putInt("questions_screen", 5);
                editor.commit();

                Intent i = new Intent(MainActivity.this, Questions.class);
                startActivity(i);

            }
        });


        CommonArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
                SharedPreferences.Editor editor = pref.edit();
                editor.putInt("questions_screen", 6);
                editor.commit();

                Intent i = new Intent(MainActivity.this, Questions.class);
                startActivity(i);

            }
        });

        HubRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, ODC_Screen.class);
                startActivity(i);
            }
        });


        exp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (isStoragePermissionGranted()) {


                    SQLiteToExcel sqliteToExcel = new SQLiteToExcel(MainActivity.this, databaseName);
                    sqliteToExcel.exportAllTables(databaseName + "_Excel.xlsx", new SQLiteToExcel.ExportListener() {
                        @Override
                        public void onStart() {
                            Toast.makeText(MainActivity.this, "Started Exporting", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onCompleted(String filePath) {

                            Toast.makeText(MainActivity.this, "File is saved at " + filePath, Toast.LENGTH_SHORT).show();

                        }

                        @Override
                        public void onError(Exception e) {

                            Toast.makeText(MainActivity.this, "Error Occured " + e, Toast.LENGTH_SHORT).show();

                        }
                    });
                }
            }
        });


    }


    public boolean isStoragePermissionGranted() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {
                return true;
            } else {

                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                return false;
            }
        } else { //permission is automatically granted on sdk<23 upon installation
            return true;
        }
    }
}
