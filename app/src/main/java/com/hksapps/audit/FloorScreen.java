package com.hksapps.audit;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.ajts.androidmads.library.SQLiteToExcel;



public class FloorScreen extends AppCompatActivity {

    String databaseName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floor_screen);

        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        databaseName = pref.getString("database_name", "None");

        Button exp = (Button) findViewById(R.id.exp);

        TextView first_floor = (TextView) findViewById(R.id.first_floor);
        TextView second_floor = (TextView) findViewById(R.id.second_floor);
        TextView third_floor = (TextView) findViewById(R.id.third_floor);
        TextView fourth_floor = (TextView) findViewById(R.id.fourth_floor);
        TextView fifth_floor = (TextView) findViewById(R.id.fifth_floor);


        first_floor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(FloorScreen.this, MainActivity.class);
                i.putExtra("floor_no",1);
                startActivity(i);

            }
        });


 second_floor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(FloorScreen.this, MainActivity.class);
                i.putExtra("floor_no",2);
                startActivity(i);

            }
        });


 third_floor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(FloorScreen.this, MainActivity.class);
                i.putExtra("floor_no",3);
                startActivity(i);

            }
        });


 fourth_floor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(FloorScreen.this, MainActivity.class);
                i.putExtra("floor_no",4);
                startActivity(i);

            }
        });



 fifth_floor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(FloorScreen.this, MainActivity.class);
                i.putExtra("floor_no",5);
                startActivity(i);

            }
        });



        exp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (isStoragePermissionGranted()) {


                    SQLiteToExcel sqliteToExcel = new SQLiteToExcel(FloorScreen.this, databaseName, Environment.getExternalStorageDirectory().getAbsolutePath() + "/Audit Checklists/");
                    sqliteToExcel.exportAllTables(databaseName + "_Excel.xlsx", new SQLiteToExcel.ExportListener() {
                        @Override
                        public void onStart() {
                            Toast.makeText(FloorScreen.this, "Started Exporting", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onCompleted(String filePath) {

                            Toast.makeText(FloorScreen.this, "File is saved at " + filePath, Toast.LENGTH_SHORT).show();

                        }

                        @Override
                        public void onError(Exception e) {

                            Toast.makeText(FloorScreen.this, "Error Occured " + e, Toast.LENGTH_SHORT).show();

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
