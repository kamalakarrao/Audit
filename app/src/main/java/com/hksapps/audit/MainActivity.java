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

public class MainActivity extends AppCompatActivity {

    public static String databaseName;
    int floor_no;
    private TextView odc1, odc2, odc3, odc4, odc5, DataCenter, ElectricalRoom, SecurityRoom, UpsRoom, CommonArea, uline, sline, dline;
    private Intent intent_odc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        databaseName = pref.getString("database_name", "None");

        final Intent intent = getIntent();
        floor_no = intent.getIntExtra("floor_no", 0);

        SharedPreferences.Editor editor = pref.edit();
        editor.putInt("floor_no", floor_no);
        editor.commit();


        setTitle("Floor - " + floor_no);

        odc1 = (TextView) findViewById(R.id.odc1);
        odc2 = (TextView) findViewById(R.id.odc2);
        odc3 = (TextView) findViewById(R.id.odc3);
        odc4 = (TextView) findViewById(R.id.odc4);
        odc5 = (TextView) findViewById(R.id.odc5);

        uline = (TextView) findViewById(R.id.uline);
        sline = (TextView) findViewById(R.id.sline);
        dline = (TextView) findViewById(R.id.dline);

        DataCenter = (TextView) findViewById(R.id.datacenter);

    /*    TextView WorkArea = (TextView) findViewById(R.id.workarea);
       */
        ElectricalRoom = (TextView) findViewById(R.id.electricalroom);
        SecurityRoom = (TextView) findViewById(R.id.securityroom);
        UpsRoom = (TextView) findViewById(R.id.upsroom);
        CommonArea = (TextView) findViewById(R.id.commonarea);

//        /*TextView HubRoom = (TextView) findViewById(R.id.hubroom);*/

        Button exp = (Button) findViewById(R.id.export);


       /* WorkArea.setOnClickListener(new View.OnClickListener() {
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

*/


        visibilitiesOfViews();


        DataCenter.setOnClickListener(new View.OnClickListener() {
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





      /* odc1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               intent_odc = new Intent(MainActivity.this, Questions.class);

               switch (floor_no) {

                   case 1:
                       intent_odc.putExtra("value", 7);
                       intent_odc.putExtra("hub_tab_name", Constants.TABLE_1F_ODC_1);
                       break;

                   case 2:
                       intent_odc.putExtra("value", 7);
                       intent_odc.putExtra("hub_tab_name", Constants.TABLE_2F_ODC_1);
                       break;

                   case 3:
                       intent_odc.putExtra("value", 7);
                       intent_odc.putExtra("hub_tab_name", Constants.TABLE_3F_ODC_1);
                       break;

                   case 4:
                       intent_odc.putExtra("value", 7);
                       intent_odc.putExtra("hub_tab_name", Constants.TABLE_4F_ODC_1);
                       break;

                   case 5:
                       intent_odc.putExtra("value", 7);
                       intent_odc.putExtra("hub_tab_name", Constants.TABLE_5F_ODC_1);
                       break;


               }

               startActivity(intent);

           }
       });


       odc2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {


               intent_odc = new Intent(MainActivity.this, Questions.class);

               switch (floor_no) {

                   case 1:
                       intent_odc.putExtra("value", 7);
                       intent_odc.putExtra("hub_tab_name", Constants.TABLE_1F_ODC_2);
                       break;

                   case 2:
                       intent_odc.putExtra("value", 7);
                       intent_odc.putExtra("hub_tab_name", Constants.TABLE_2F_ODC_2);
                       break;

                   case 3:
                       intent_odc.putExtra("value", 7);
                       intent_odc.putExtra("hub_tab_name", Constants.TABLE_3F_ODC_2);
                       break;

                   case 4:
                       intent_odc.putExtra("value", 7);
                       intent_odc.putExtra("hub_tab_name", Constants.TABLE_4F_ODC_2);
                       break;

                   case 5:
                       intent_odc.putExtra("value", 7);
                       intent_odc.putExtra("hub_tab_name", Constants.TABLE_5F_ODC_2);
                       break;


               }

               startActivity(intent);


           }
       });


       odc3.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               intent_odc = new Intent(MainActivity.this, Questions.class);

               switch (floor_no) {

                   case 1:
                       intent_odc.putExtra("value", 7);
                       intent_odc.putExtra("hub_tab_name", Constants.TABLE_1F_ODC_3);
                       break;

                   case 2:
                       intent_odc.putExtra("value", 7);
                       intent_odc.putExtra("hub_tab_name", Constants.TABLE_2F_ODC_3);
                       break;

                   case 3:
                       intent_odc.putExtra("value", 7);
                       intent_odc.putExtra("hub_tab_name", Constants.TABLE_3F_ODC_3);
                       break;

                   case 4:
                       intent_odc.putExtra("value", 7);
                       intent_odc.putExtra("hub_tab_name", Constants.TABLE_4F_ODC_3);
                       break;

                   case 5:
                       intent_odc.putExtra("value", 7);
                       intent_odc.putExtra("hub_tab_name", Constants.TABLE_5F_ODC_3);
                       break;


               }

               startActivity(intent);



           }
       });


       odc4.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {


               intent_odc = new Intent(MainActivity.this, Questions.class);

               switch (floor_no) {

                   case 1:
                       intent_odc.putExtra("value", 7);
                       intent_odc.putExtra("hub_tab_name", Constants.TABLE_1F_ODC_4);
                       break;

                   case 2:
                       intent_odc.putExtra("value", 7);
                       intent_odc.putExtra("hub_tab_name", Constants.TABLE_2F_ODC_4);
                       break;

                   case 3:
                       intent_odc.putExtra("value", 7);
                       intent_odc.putExtra("hub_tab_name", Constants.TABLE_3F_ODC_4);
                       break;

                   case 4:
                       intent_odc.putExtra("value", 7);
                       intent_odc.putExtra("hub_tab_name", Constants.TABLE_4F_ODC_4);
                       break;

                   case 5:
                       intent_odc.putExtra("value", 7);
                       intent_odc.putExtra("hub_tab_name", Constants.TABLE_5F_ODC_4);
                       break;


               }

               startActivity(intent);



           }
       });


       odc5.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               intent_odc = new Intent(MainActivity.this, Questions.class);

               switch (floor_no) {

                   case 1:
                       intent_odc.putExtra("value", 7);
                       intent_odc.putExtra("hub_tab_name", Constants.TABLE_1F_ODC_5);
                       break;

                   case 2:
                       intent_odc.putExtra("value", 7);
                       intent_odc.putExtra("hub_tab_name", Constants.TABLE_2F_ODC_5);
                       break;

                   case 3:
                       intent_odc.putExtra("value", 7);
                       intent_odc.putExtra("hub_tab_name", Constants.TABLE_3F_ODC_5);
                       break;




               }

               startActivity(intent);



           }
       });*/


        odc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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

      /*  HubRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, ODC_Screen.class);
                startActivity(i);
            }
        });
*/

        exp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (isStoragePermissionGranted()) {


                    SQLiteToExcel sqliteToExcel = new SQLiteToExcel(MainActivity.this, databaseName, Environment.getExternalStorageDirectory().getAbsolutePath() + "/Audit Checklists/");
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


    private void visibilitiesOfViews() {

        if (floor_no == 1) {

            SecurityRoom.setVisibility(View.VISIBLE);
            sline.setVisibility(View.VISIBLE);

            UpsRoom.setVisibility(View.VISIBLE);
            uline.setVisibility(View.VISIBLE);

        } else {

            SecurityRoom.setVisibility(View.GONE);
            sline.setVisibility(View.GONE);
            UpsRoom.setVisibility(View.GONE);
            uline.setVisibility(View.GONE);
        }


        if (floor_no == 2) {

            DataCenter.setVisibility(View.VISIBLE);
            dline.setVisibility(View.VISIBLE);
        } else {
            DataCenter.setVisibility(View.GONE);
            dline.setVisibility(View.GONE);
        }

        if (floor_no == 4 || floor_no == 5) {

            odc5.setVisibility(View.GONE);
        } else {
            odc5.setVisibility(View.VISIBLE);
        }

    }
}
