package com.hksapps.audit;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class FirstScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        TextView db_list = (TextView) findViewById(R.id.db_list);
        LinearLayout linear = (LinearLayout) findViewById(R.id.linear);
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        String db_name = pref.getString("database_name", "None");


        Set<String> set1 = new HashSet<String>();
        set1 = pref.getStringSet("no_of_databases", new HashSet<String>());


        final Iterator it = set1.iterator();
        while (it.hasNext()) {
            final TextView rowTextView = new TextView(this);

            // set some properties of rowTextView or something
            rowTextView.setText(it.next().toString());

            rowTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(FirstScreen.this, it.next().toString(), Toast.LENGTH_SHORT).show();
                }
            });

            // add the textview to the linearlayout
            linear.addView(rowTextView);
        }


        db_list.setText(db_name);


        db_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(FirstScreen.this, MainActivity.class);
                startActivity(i);


            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(FirstScreen.this, AuditDetails.class);
                startActivity(i);
            }
        });
    }

}
