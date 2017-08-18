package com.hksapps.audit;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView WorkArea = (TextView) findViewById(R.id.workarea);
        TextView ServerRoom = (TextView) findViewById(R.id.serverroom);
        TextView ElectricalRoom = (TextView) findViewById(R.id.electricalroom);
        TextView SecurityRoom = (TextView) findViewById(R.id.securityroom);
        TextView UpsRoom = (TextView) findViewById(R.id.upsroom);
        TextView CommonArea = (TextView) findViewById(R.id.commonarea);


        WorkArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
                SharedPreferences.Editor editor = pref.edit();
                editor.putInt("questions_screen",1);
                editor.commit();

Intent i = new Intent(MainActivity.this,Questions.class);
                    startActivity(i);

            }
        });



        ServerRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
                SharedPreferences.Editor editor = pref.edit();
                editor.putInt("questions_screen",2);
                editor.commit();

                Intent i = new Intent(MainActivity.this,Questions.class);
                startActivity(i);

            }
        });




        ElectricalRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
                SharedPreferences.Editor editor = pref.edit();
                editor.putInt("questions_screen",3);
                editor.commit();

                Intent i = new Intent(MainActivity.this,Questions.class);
                startActivity(i);

            }
        });


        SecurityRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
                SharedPreferences.Editor editor = pref.edit();
                editor.putInt("questions_screen",4);
                editor.commit();

                Intent i = new Intent(MainActivity.this,Questions.class);
                startActivity(i);

            }
        });


        UpsRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
                SharedPreferences.Editor editor = pref.edit();
                editor.putInt("questions_screen",5);
                editor.commit();

                Intent i = new Intent(MainActivity.this,Questions.class);
                startActivity(i);

            }
        });


        CommonArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
                SharedPreferences.Editor editor = pref.edit();
                editor.putInt("questions_screen",6);
                editor.commit();

                Intent i = new Intent(MainActivity.this,Questions.class);
                startActivity(i);

            }
        });

    }
}
