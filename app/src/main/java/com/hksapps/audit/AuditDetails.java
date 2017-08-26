package com.hksapps.audit;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AuditDetails extends AppCompatActivity {

    private EditText date, name_of_auditor, site, spoc;
    private Button done;
    private DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audit_details);

        date = (EditText) findViewById(R.id.date);
        name_of_auditor = (EditText) findViewById(R.id.nameofauditor);
        site = (EditText) findViewById(R.id.site);
        spoc = (EditText) findViewById(R.id.spoc);

        done = (Button) findViewById(R.id.done);

        db = new DatabaseHandler(this);


        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!(date.getText().toString().matches("") && name_of_auditor.getText().toString().matches("") && site.getText().toString().matches("") && spoc.getText().toString().matches(""))) {

                    SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putString("database_name", "Audit_" + date.getText().toString().toLowerCase() + "_" + site.getText().toString().toLowerCase());
                    editor.commit();

                    db.addAuditDetails(new CheckList("Date: " + date.getText().toString()));
                    db.addAuditDetails(new CheckList("Name of Auditor: " + name_of_auditor.getText().toString()));
                    db.addAuditDetails(new CheckList("Site: " + site.getText().toString()));
                    db.addAuditDetails(new CheckList("SPOC: " + spoc.getText().toString()));

                    finish();
                }

            }
        });

    }
}
