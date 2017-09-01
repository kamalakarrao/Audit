package com.hksapps.audit;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Questions extends AppCompatActivity {

    static TextView ques;
    static EditText remarks;
    static int j = 1;
    RadioButton yesno, y, n;
    RadioGroup grp;
    DatabaseHandler db;
    ArrayList<String> question_chk, yes_chk, no_chk, remarks_chk;
    private String table_name, tab_name , databaseName , hub_tab_name;
    private int question_number;

    @Override
    public void onBackPressed() {
        StoreAnswersInDb(table_name, j + 1);
        Intent i = new Intent(Questions.this, ReviewScreen.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        i.putExtra("table_name", table_name);
        startActivity(i);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);




        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        int value = pref.getInt("questions_screen", 0);

        databaseName = pref.getString("database_name", "None");

        y = (RadioButton) findViewById(R.id.yes);
        n = (RadioButton) findViewById(R.id.no);

   /*     y.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                 y.setChecked(false);
                n.setChecked(false);
                return true;
            }
        });
        n.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                 y.setChecked(false);
                n.setChecked(false);
                return true;
            }
        });*/
        ques = (TextView) findViewById(R.id.ques);
        remarks = (EditText) findViewById(R.id.remarks);

        db = new DatabaseHandler(this,databaseName);
//Editing Questions which are from Review Screen
        Intent intent = getIntent();
        tab_name = intent.getStringExtra("tab_name");
        hub_tab_name = intent.getStringExtra("hub_tab_name");
        int val = intent.getIntExtra("value", 000);
        question_number = intent.getIntExtra("question_number", 000);
        if (val == 20) {
            value = 20;
        }

        if(val == 7){
            value = 7;
        }

        switch (value) {
            case 1:
                table_name = Constants.TABLE_WORKAREA;
                j = 0;
                if (db.IsTableEmpty(table_name)) {

                    db.addChecklists(new CheckList("Are the fire extinguishers placed at appropriate locations?"), table_name);
                    db.addChecklists(new CheckList("Are the fire extinguishers refilled/due date displayed?"), table_name);
                    db.addChecklists(new CheckList("Is the work area free from debris/ waste?"), table_name);
                    db.addChecklists(new CheckList("Is the emergency contact information posted in the Work area?"), table_name);
                    db.addChecklists(new CheckList("Is the sprinkler system functional/inspected/documented (mention date)?"), table_name);
                    db.addChecklists(new CheckList("Was smoke/heat detectors functional and inspected (mention date)?"), table_name);
                    db.addChecklists(new CheckList("Are electrical panels clearly marked?"), table_name);
                    db.addChecklists(new CheckList("Does outlets, switches and boxes have covers?"), table_name);
                    db.addChecklists(new CheckList("Are other signages displayed in appropriate locations?"), table_name);
                    db.addChecklists(new CheckList("Is first aid box displayed with instructions?"), table_name);
                    db.addChecklists(new CheckList("Was emergency lighting system functional effectively during the tests?"), table_name);
                    db.addChecklists(new CheckList("Are fire exit signs in good conditions?"), table_name);
                    db.addChecklists(new CheckList("Are exits properly illuminated?"), table_name);
                    db.addChecklists(new CheckList("Are fire exits and the exit routes clearly marked?"), table_name);
                    db.addChecklists(new CheckList("Are exits free from obstruction?"), table_name);
                    db.addChecklists(new CheckList("Were there any issues with PA system during last testing?"), table_name);
                    db.addChecklists(new CheckList("Was access control doors checked for deactivation in case of emergency?"), table_name);
                    db.addChecklists(new CheckList("Were alarm system functioning effectively during the tests?"), table_name);
                    db.addChecklists(new CheckList("Are stairs/ aisleways free from material storage and debris?"), table_name);
                    db.addChecklists(new CheckList("Is transportation available for injured workers/plan in place?"), table_name);
                    db.addChecklists(new CheckList("Are warning signs posted for wet floors or spills?"), table_name);
                    db.addChecklists(new CheckList("Have fire wardens displayed their caps on desks?"), table_name);
                    db.addChecklists(new CheckList("Are fire escape plan installed on the floors?"), table_name);
                    db.addChecklists(new CheckList("Are the audio visual alarms present on the floor?"), table_name);
                    Toast.makeText(this, "Questions Added", Toast.LENGTH_SHORT).show();
                }
                break;

            case 2:
                table_name = Constants.TABLE_SERVERROOM;
                j = 0;
                if (db.IsTableEmpty(table_name)) {
                    db.addChecklists(new CheckList("Are the fire extinguishers placed at appropriate locations?"), table_name);
                    db.addChecklists(new CheckList("Are the fire extinguishers refilled/due date displayed?"), table_name);
                    db.addChecklists(new CheckList("Is server room free from debris/ waste?"), table_name);
                    db.addChecklists(new CheckList("Is the emergency contact information posted in the server room?"), table_name);
                    db.addChecklists(new CheckList("Was FM 200/ Inergen functional and inspected (mention date)?"), table_name);
                    db.addChecklists(new CheckList("Was smoke/heat detectors functional and inspected (mention date)?"), table_name);
                    db.addChecklists(new CheckList("Are electrical panels clearly marked?"), table_name);
                    db.addChecklists(new CheckList("Does outlets, switches and boxes have covers?"), table_name);
                    db.addChecklists(new CheckList("Is rodent control present in server room?"), table_name);
                    db.addChecklists(new CheckList("Are other signages displayed in appropriate locations?"), table_name);
                    db.addChecklists(new CheckList("Is temperature maintained in server room?"), table_name);
                    db.addChecklists(new CheckList("Is there any storage media found in the room?"), table_name);
                    db.addChecklists(new CheckList("Is visitors log maintained?"), table_name);
                    db.addChecklists(new CheckList("Are the temperature and humidity detecting devices functional?"), table_name);
                    db.addChecklists(new CheckList("Are blower fans clear of debris?"), table_name);
                    db.addChecklists(new CheckList("Other Findings?"), table_name);
                    Toast.makeText(this, "Questions Added", Toast.LENGTH_SHORT).show();
                }
                break;

            case 3:
                table_name = Constants.TABLE_ELECTRICALROOM;
                j = 0;
                if (db.IsTableEmpty(table_name)) {
                    db.addChecklists(new CheckList("Are the fire extinguishers placed at appropriate locations?"), table_name);
                    db.addChecklists(new CheckList("Are the fire extinguishers refilled/due date displayed?"), table_name);
                    db.addChecklists(new CheckList("Is electrical room free from debris/ waste?"), table_name);
                    db.addChecklists(new CheckList("Is the emergency contact information posted in the electrical room?"), table_name);
                    db.addChecklists(new CheckList("Is the sprinkler system functional/inspected/documented (mention date)?"), table_name);
                    db.addChecklists(new CheckList("Was smoke/heat detectors functional and inspected (mention date)?"), table_name);
                    db.addChecklists(new CheckList("Are electrical panels clearly marked?"), table_name);
                    db.addChecklists(new CheckList("Does outlets, switches and boxes have covers?"), table_name);
                    db.addChecklists(new CheckList("Is rodent control present in electrical room?"), table_name);
                    db.addChecklists(new CheckList("Are other signages displayed in appropriate locations?"), table_name);
                    db.addChecklists(new CheckList("Is first aid box displayed with instructions?"), table_name);
                    db.addChecklists(new CheckList("Was emergency lighting system functional effectively during the tests?"), table_name);
                    db.addChecklists(new CheckList("Is temperature maintained in electrical room?"), table_name);
                    Toast.makeText(this, "Questions Added", Toast.LENGTH_SHORT).show();
                }
                break;

            case 4:
                table_name = Constants.TABLE_SECURITYROOM;
                j = 0;
                if (db.IsTableEmpty(table_name)) {
                    db.addChecklists(new CheckList("Are the fire extinguishers placed at appropriate locations?"), table_name);
                    db.addChecklists(new CheckList("Are the fire extinguishers refilled/due date displayed?"), table_name);
                    db.addChecklists(new CheckList("Is the emergency contact information posted in the common area?"), table_name);
                    db.addChecklists(new CheckList("Is the sprinkler system functional/inspected/documented (mention date)?"), table_name);
                    db.addChecklists(new CheckList("Was smoke/heat detectors functional and inspected (mention date)?"), table_name);
                    db.addChecklists(new CheckList("Are electrical panels clearly marked?"), table_name);
                    db.addChecklists(new CheckList("Does outlets, switches and boxes have covers?"), table_name);
                    db.addChecklists(new CheckList("Is first aid box displayed with instructions?"), table_name);
                    db.addChecklists(new CheckList("Were there any issues with PAS during last testing?"), table_name);
                    db.addChecklists(new CheckList("Were alarm system functioning effectively during the tests?"), table_name);
                    db.addChecklists(new CheckList("Are fire escape plan installed in the security room?"), table_name);
                    db.addChecklists(new CheckList("Are BMS/CCTV system updated with latest antivirus update?"), table_name);
                    db.addChecklists(new CheckList("Are BMS/CCTV Ssystem connected to Capgemini Network?"), table_name);
                    db.addChecklists(new CheckList("Is the data maintained for Pregnant women and persons with disabilities?"), table_name);
                    db.addChecklists(new CheckList("Is the log of details of visitors and foreign delegates visiting CG maintained ?"), table_name);
                    db.addChecklists(new CheckList("Retentation of CCTV footage?"), table_name);
                    Toast.makeText(this, "Questions Added", Toast.LENGTH_SHORT).show();
                }
                break;


            case 5:
                table_name = Constants.TABLE_UPSROOM;
                j = 0;
                if (db.IsTableEmpty(table_name)) {
                    db.addChecklists(new CheckList("Are the fire extinguishers placed at appropriate locations?"), table_name);
                    db.addChecklists(new CheckList("Are the fire extinguishers refilled/due date displayed?"), table_name);
                    db.addChecklists(new CheckList("Is UPS Room free from debris/ waste?"), table_name);
                    db.addChecklists(new CheckList("Is the emergency contact information posted in the UPS Room?"), table_name);
                    db.addChecklists(new CheckList("Is the sprinkler system functional/inspected/documented (mention date)?"), table_name);
                    db.addChecklists(new CheckList("Was smoke/heat detectors functional and inspected (mention date)?"), table_name);
                    db.addChecklists(new CheckList("Are electrical panels clearly marked?"), table_name);
                    db.addChecklists(new CheckList("Does outlets, switches and boxes have covers?"), table_name);
                    db.addChecklists(new CheckList("Is rodent control present in UPS Room?"), table_name);
                    db.addChecklists(new CheckList("Are other signages displayed in appropriate locations?"), table_name);
                    db.addChecklists(new CheckList("Is temperature maintained in UPS room?"), table_name);
                    db.addChecklists(new CheckList("Is first aid box displayed with instructions?"), table_name);
                    db.addChecklists(new CheckList("Is there leakage found on batteries?"), table_name);
                    db.addChecklists(new CheckList("Is visitors log maintained?"), table_name);
                    db.addChecklists(new CheckList("Are the temperature and humidity detecting divices functional?"), table_name);
                    Toast.makeText(this, "Questions Added", Toast.LENGTH_SHORT).show();
                }
                break;


            case 6:
                table_name = Constants.TABLE_COMMONAREA;
                j = 0;
                if (db.IsTableEmpty(table_name)) {
                    db.addChecklists(new CheckList("Are the fire extinguishers placed at appropriate locations?"), table_name);
                    db.addChecklists(new CheckList("Are the fire extinguishers refilled/due date displayed?"), table_name);
                    db.addChecklists(new CheckList("Is common area free from debris/ waste?"), table_name);
                    db.addChecklists(new CheckList("Is the emergency contact information posted in the common area?"), table_name);
                    db.addChecklists(new CheckList("Is the sprinkler system functional/inspected/documented (mention date)?"), table_name);
                    db.addChecklists(new CheckList("Was smoke/heat detectors functional and inspected (mention date)?"), table_name);
                    db.addChecklists(new CheckList("Are electrical panels clearly marked?"), table_name);
                    db.addChecklists(new CheckList("Does outlets, switches and boxes have covers?"), table_name);
                    db.addChecklists(new CheckList("Are other signages displayed in appropriate locations?"), table_name);
                    db.addChecklists(new CheckList("Is first aid box displayed with instructions?"), table_name);
                    db.addChecklists(new CheckList("Was emergency lighting system functional effectively during the tests?"), table_name);
                    db.addChecklists(new CheckList("Are fire exit signs in good conditions?"), table_name);
                    db.addChecklists(new CheckList("Are exits properly illuminated?"), table_name);
                    db.addChecklists(new CheckList("Are fire exits and the exit routes clealy clearly marked?"), table_name);
                    db.addChecklists(new CheckList("Are exits free from obstruction?"), table_name);
                    db.addChecklists(new CheckList("Were there any issues with PAS during last testing?"), table_name);
                    db.addChecklists(new CheckList("Was access control doors checked for deactivation in case of emergency?"), table_name);
                    db.addChecklists(new CheckList("Were alarm system functioning effectively during the tests?"), table_name);
                    db.addChecklists(new CheckList("Are stairs/ aisleways free from material storage and debris?"), table_name);
                    db.addChecklists(new CheckList("Is transportation available for injured workers/plan in place?"), table_name);
                    db.addChecklists(new CheckList("Are warning signs posted for wet floors or spills?"), table_name);
                    db.addChecklists(new CheckList("Are fire escape plan installed in the common area?"), table_name);
                    db.addChecklists(new CheckList("All kitchen appliances wiring in proper good condition?"), table_name);
                    db.addChecklists(new CheckList("Does have a CO2 fire extinguisher?"), table_name);
                    db.addChecklists(new CheckList("Are combustible debries disposed of regularly?"), table_name);
                    db.addChecklists(new CheckList("Are the audio visual alarms present on the floor?"), table_name);
                    db.addChecklists(new CheckList("Other info?"), table_name);
                    Toast.makeText(this, "Questions Added", Toast.LENGTH_SHORT).show();
                }
                break;



            case 7:
                table_name = hub_tab_name;
                j = 0;
                if(db.IsTableEmpty(table_name)){

                    db.addChecklists(new CheckList("Are the fire extinguishers placed at appropriate locations?"), table_name);
                    db.addChecklists(new CheckList("Are the fire extinguishers refilled/due date displayed?"), table_name);
                    db.addChecklists(new CheckList("Is Hub Room free from debris/ waste?"), table_name);
                    db.addChecklists(new CheckList("Is the emergency contact information posted in the Hub Room?"), table_name);
                    db.addChecklists(new CheckList("Is the sprinkler system functional/inspected/documented (mention date)?"), table_name);
                    db.addChecklists(new CheckList("Was smoke/heat detectors functional and inspected (mention date)?"), table_name);
                    db.addChecklists(new CheckList("Are electrical panels clearly marked?"), table_name);
                    db.addChecklists(new CheckList("Does outlets, switches and boxes have covers?"), table_name);
                    db.addChecklists(new CheckList("Is rodent control present in Hub Room?"), table_name);
                    db.addChecklists(new CheckList("Are other signages displayed in appropriate locations?"), table_name);
                    db.addChecklists(new CheckList("Is there any storage media found in the room?"), table_name);
                    Toast.makeText(this, "Questions Added", Toast.LENGTH_SHORT).show();

                }
                break;

            case 20:
                table_name = tab_name;
                j = question_number;
                getDataFromDb();
                ques.setText(question_chk.get(j));
                remarks.setText(remarks_chk.get(j));
                checkYesOrNo(j);
                break;


        }

//Check work area table is empty or not









       /* Log.d("Insert: ", "Inserting ..");
        db.addChecklists(new CheckList("Is Server Okay?"));
        db.addChecklists(new CheckList("Is Server Secured?"));
        db.addChecklists(new CheckList("Is Everything okay?"));
        db.addChecklists(new CheckList("Is it Fast?"));
        db.addChecklists(new CheckList("Is it Working fine?"));
*/

        getDataFromDb();

        if (value != 20) {
            if (question_chk.size() > 0) {
                ques.setText(question_chk.get(0));
                remarks.setText(remarks_chk.get(0));
                checkYesOrNo(0);
            }
        }


        Button next = (Button) findViewById(R.id.next);
        Button previous = (Button) findViewById(R.id.previous);
        Button review_questions = (Button) findViewById(R.id.review_questions);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (j >= question_chk.size() - 1) {

                    StoreAnswersInDb(table_name, j + 1);

                    getDataFromDb();
                    Toast.makeText(Questions.this, "All Questions are done!", Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(Questions.this, ReviewScreen.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                    i.putExtra("table_name", table_name);
                    startActivity(i);


                    Log.d("Value", String.valueOf(j));


                } else {

                    StoreAnswersInDb(table_name, j + 1);

                    getDataFromDb();
                    grp.clearCheck();

                    j++;
                    ques.setText(question_chk.get(j));
                    checkYesOrNo(j);
                    remarks.setText(remarks_chk.get(j));

                }

            }
        });


        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (j <= 0) {

                    Toast.makeText(Questions.this, "This is 1st Question", Toast.LENGTH_SHORT).show();
                } else {
                    grp.clearCheck();
                    getDataFromDb();
                    j--;
                    ques.setText(question_chk.get(j));
                    checkYesOrNo(j);
                    remarks.setText(remarks_chk.get(j));

                }


            }
        });


        review_questions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                StoreAnswersInDb(table_name, j + 1);

                Intent i = new Intent(Questions.this, ReviewScreen.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                i.putExtra("table_name", table_name);
                startActivity(i);


            }
        });

    }

    private void getDataFromDb() {

        List<CheckList> allChecklists = db.getAllChecklists(table_name);

      /*  StringBuilder builder = new StringBuilder();
        for (CheckList details : allChecklists) {
            builder.append(details + "\n");
        }*/


        Log.e("size check list ", String.valueOf(allChecklists.size()));

        question_chk = new ArrayList<>();
        yes_chk = new ArrayList<>();
        no_chk = new ArrayList<>();
        remarks_chk = new ArrayList<>();
        for (CheckList con : allChecklists) {

            String temp = con.getChecklist();
            question_chk.add(temp);
            yes_chk.add(con.getYes().toString());

            no_chk.add(con.getNo().toString());

            String temp1 = con.getRemarks();
            remarks_chk.add(temp1);

        }


    }


    private String getRadioButtonChoice() {
        grp = (RadioGroup) findViewById(R.id.grp);

        if (grp.getCheckedRadioButtonId() == -1) {

            return "";


        } else {

            int selectedId = grp.getCheckedRadioButtonId();

            yesno = (RadioButton) findViewById(selectedId);

            return yesno.getText().toString();
        }

    }

    private void checkYesOrNo(int i) {

        if (yes_chk.get(i).toString().equals("yes")) {
            y.setChecked(true);
        } else if (no_chk.get(i).toString().equals("no")) {
            n.setChecked(true);
        } else {
            y.setChecked(false);
            n.setChecked(false);
        }


    }


    private void StoreAnswersInDb(String t_name, int id_no) {
        String y, n;
        if (getRadioButtonChoice().equals("Yes")) {
            y = "yes";
            n = "";
        } else if (getRadioButtonChoice().equals("No")) {
            y = "";
            n = "no";
        } else {
            y = "";
            n = "";
        }
        db.addAnswers(new CheckList(y, n, remarks.getText().toString()), t_name, id_no);
    }
}