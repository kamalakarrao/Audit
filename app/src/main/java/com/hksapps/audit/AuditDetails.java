package com.hksapps.audit;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class AuditDetails extends AppCompatActivity {

    private EditText date, name_of_auditor, site, spoc;
    private Button done;
    private DatabaseHandler db;
    private ArrayList<String> no_of_dbs;
    public static String audit_db_name;
    private Context  context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audit_details);

        context=this;

        date = (EditText) findViewById(R.id.date);
        name_of_auditor = (EditText) findViewById(R.id.nameofauditor);
        site = (EditText) findViewById(R.id.site);
        spoc = (EditText) findViewById(R.id.spoc);

        done = (Button) findViewById(R.id.done);




        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!(date.getText().toString().matches("") && name_of_auditor.getText().toString().matches("") && site.getText().toString().matches("") && spoc.getText().toString().matches(""))) {

                    SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
                    SharedPreferences.Editor editor = pref.edit();

                    Set<String> set1 = new HashSet<String>();
                    set1 = pref.getStringSet("no_of_databases", new HashSet<String>());
                    no_of_dbs = new ArrayList<>();
                    //   set1.add(("Audit_" + date.getText().toString().toLowerCase() + "_" + site.getText().toString().toLowerCase()).trim());
                    final Iterator it = set1.iterator();
                    while (it.hasNext()) {

                        no_of_dbs.add(it.next().toString());
                    }

                    no_of_dbs.add(("Audit_" + date.getText().toString().toLowerCase() + "_" + site.getText().toString().toLowerCase()).trim());

                    Set<String> set = new HashSet<String>();
                    set.addAll(no_of_dbs);

                    editor.putStringSet("no_of_databases", set);
                    editor.commit();


                    editor.putString("database_name", ("Audit_" + date.getText().toString().toLowerCase() + "_" + site.getText().toString().toLowerCase()).trim());
                    editor.commit();

                    audit_db_name = ("Audit_" + date.getText().toString().toLowerCase() + "_" + site.getText().toString().toLowerCase()).trim();

                    db = new DatabaseHandler(context,audit_db_name);

                    db.addAuditDetails(new CheckList("Date: " + date.getText().toString()));
                    db.addAuditDetails(new CheckList("Name of Auditor: " + name_of_auditor.getText().toString()));
                    db.addAuditDetails(new CheckList("Site: " + site.getText().toString()));
                    db.addAuditDetails(new CheckList("SPOC: " + spoc.getText().toString()));

                    Intent k = new Intent(AuditDetails.this, FirstScreen.class);
                    k.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(k);
                }

            }
        });

    }
}
