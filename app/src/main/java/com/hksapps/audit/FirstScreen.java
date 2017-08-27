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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class FirstScreen extends AppCompatActivity {
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;

    private ArrayList<String> no_of_dbs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        LinearLayout linear = (LinearLayout) findViewById(R.id.linear);
        pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode

        editor = pref.edit();

        String db_name = pref.getString("database_name", "None");


        Set<String> set1 = new HashSet<String>();
        set1 = pref.getStringSet("no_of_databases", new HashSet<String>());

        no_of_dbs = new ArrayList<>();
        no_of_dbs.clear();
        final Iterator it = set1.iterator();
        while (it.hasNext()) {

            no_of_dbs.add(it.next().toString());
        }


        for (int i = 0; i < no_of_dbs.size(); i++) {

            final TextView rowTextView = new TextView(this);
            final int finalI = i;
            // set some properties of rowTextView or something
            rowTextView.setText(no_of_dbs.get(finalI));

            Toast.makeText(FirstScreen.this, no_of_dbs.get(finalI), Toast.LENGTH_SHORT).show();

            rowTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    editor.putString("database_name", no_of_dbs.get(finalI));
                    editor.commit();

                    Intent o = new Intent(FirstScreen.this, MainActivity.class);
                    startActivity(o);

                }
            });

            rowTextView.setTextSize(24);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(10, 10, 10, 10);
            rowTextView.setLayoutParams(params);
            // add the textview to the linearlayout
            linear.addView(rowTextView);

        }

       /* db_list.setText(db_name);


        db_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(FirstScreen.this, MainActivity.class);
                startActivity(i);


            }
        });
*/
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
