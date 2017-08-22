package com.hksapps.audit;

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
    RadioButton yesno,y,n;
    RadioGroup grp;
    DatabaseHandler db;
    static int j=1;
    String table_name;

    ArrayList<String> question_chk,yes_chk,no_chk,remarks_chk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);


        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        int value = pref.getInt("questions_screen", 0);

        y = (RadioButton) findViewById(R.id.yes);
        n= (RadioButton) findViewById(R.id.no);
        ques = (TextView) findViewById(R.id.ques);
        remarks = (EditText) findViewById(R.id.remarks);

        db = new DatabaseHandler(this);

        switch (value){
            case 1: table_name = Constants.TABLE_WORKAREA;
                j=0;
                if(db.IsTableEmpty(table_name)){

                    db.addChecklists(new CheckList("Is work area Okay?"),table_name);
                    db.addChecklists(new CheckList("Is workspace Secured?"),table_name);
                    db.addChecklists(new CheckList("Is work okay?"),table_name);
                    db.addChecklists(new CheckList("Is work Fast?"),table_name);
                    db.addChecklists(new CheckList("Is work fine?"),table_name);
                    Toast.makeText(this, "Questions Added", Toast.LENGTH_SHORT).show();
                }
                break;

            case 2: table_name = Constants.TABLE_SERVERROOM;
                j=0;
                if(db.IsTableEmpty(table_name)){
                    db.addChecklists(new CheckList("Is Server Okay?"),table_name);
                    db.addChecklists(new CheckList("Is Server Secured?"),table_name);
                    db.addChecklists(new CheckList("Is Everything okay?"),table_name);
                    db.addChecklists(new CheckList("Is it Fast?"),table_name);
                    db.addChecklists(new CheckList("Is it Working fine?"),table_name);
                    Toast.makeText(this, "Questions Added", Toast.LENGTH_SHORT).show();
                }
                break;

            case 3: table_name = Constants.TABLE_ELECTRICALROOM;
                j=0;
                if(db.IsTableEmpty(table_name)){
                    db.addChecklists(new CheckList("Is Electrical room Okay?"),table_name);
                    db.addChecklists(new CheckList("Is Electrical room Secured?"),table_name);
                    db.addChecklists(new CheckList("Is Everything in Electrical room okay?"),table_name);
                    db.addChecklists(new CheckList("Is Electrical room Fast?"),table_name);
                    db.addChecklists(new CheckList("Is Electrical room Working fine?"),table_name);
                    Toast.makeText(this, "Questions Added", Toast.LENGTH_SHORT).show();
                }
                break;

            case 4: table_name = Constants.TABLE_SECURITYROOM;
                j=0;
                if(db.IsTableEmpty(table_name)){
                    db.addChecklists(new CheckList("Is Security room Okay?"),table_name);
                    db.addChecklists(new CheckList("Is Security room Secured?"),table_name);
                    db.addChecklists(new CheckList("Is Everything in Security room okay?"),table_name);
                    db.addChecklists(new CheckList("Is Security room Fast?"),table_name);
                    db.addChecklists(new CheckList("Is Security room Working fine?"),table_name);
                    Toast.makeText(this, "Questions Added", Toast.LENGTH_SHORT).show();
                }
                break;


            case 5: table_name = Constants.TABLE_UPSROOM;
                j=0;
                if(db.IsTableEmpty(table_name)){
                    db.addChecklists(new CheckList("Is UPS room Okay?"),table_name);
                    db.addChecklists(new CheckList("Is UPS room Secured?"),table_name);
                    db.addChecklists(new CheckList("Is Everything in UPS room okay?"),table_name);
                    db.addChecklists(new CheckList("Is UPS room Fast?"),table_name);
                    db.addChecklists(new CheckList("Is UPS room Working fine?"),table_name);
                    Toast.makeText(this, "Questions Added", Toast.LENGTH_SHORT).show();
                }
                break;



            case 6: table_name = Constants.TABLE_COMMONAREA;
                j=0;
                if(db.IsTableEmpty(table_name)){
                    db.addChecklists(new CheckList("Is Common area Okay?"),table_name);
                    db.addChecklists(new CheckList("Is Common area Secured?"),table_name);
                    db.addChecklists(new CheckList("Is Everything in Common area okay?"),table_name);
                    db.addChecklists(new CheckList("Is Common area Fast?"),table_name);
                    db.addChecklists(new CheckList("Is Common area Working fine?"),table_name);
                    Toast.makeText(this, "Questions Added", Toast.LENGTH_SHORT).show();
                }
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



        Button next = (Button) findViewById(R.id.next);
        Button previous = (Button) findViewById(R.id.previous);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(j>=question_chk.size()-1){

                    StoreAnswersInDb(table_name,j+1);

        getDataFromDb();


                    Log.d("Value", String.valueOf(j));

                    Toast.makeText(Questions.this, "All Questions are done!" , Toast.LENGTH_SHORT).show();


                }else {

                    StoreAnswersInDb(table_name,j+1);

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
                if(j<=0){

                    Toast.makeText(Questions.this, "This is 1st Question" , Toast.LENGTH_SHORT).show();
                }
                else {
                    grp.clearCheck();
                    getDataFromDb();
                    j--;
                    ques.setText(question_chk.get(j));
                    checkYesOrNo(j);
                    remarks.setText(remarks_chk.get(j));

                }


            }
        });






    }

    private void getDataFromDb(){

        List<CheckList> allChecklists = db.getAllChecklists(table_name);

      /*  StringBuilder builder = new StringBuilder();
        for (CheckList details : allChecklists) {
            builder.append(details + "\n");
        }*/


        Log.e("size check list ", String.valueOf(allChecklists.size()));

        question_chk=new ArrayList<>();
        yes_chk = new ArrayList<>();
        no_chk = new ArrayList<>();
        remarks_chk = new ArrayList<>();
        for(CheckList con : allChecklists) {

            String temp = con.getChecklist();
            question_chk.add(temp);
            yes_chk.add(con.getYes().toString());

            no_chk.add(con.getNo().toString());

            String temp1 = con.getRemarks();
            remarks_chk.add(temp1);

        }

        ques.setText(question_chk.get(0));
        remarks.setText(remarks_chk.get(0));
        checkYesOrNo(0);

    }


    private String getRadioButtonChoice(){
        grp = (RadioGroup) findViewById(R.id.grp);

        if(grp.getCheckedRadioButtonId()==-1){

            return "";


        }else {

            int selectedId = grp.getCheckedRadioButtonId();

            yesno = (RadioButton) findViewById(selectedId);

            return yesno.getText().toString();
        }

    }

    private void checkYesOrNo(int i){

        if(yes_chk.get(i).toString().equals("yes")){
            y.setChecked(true);
        }else if(no_chk.get(i).toString().equals("no")){
            n.setChecked(true);
        }else {
            y.setChecked(false);
            n.setChecked(false);
        }


    }


    private void StoreAnswersInDb(String t_name,int id_no){
        String y , n;
        if(getRadioButtonChoice().equals("Yes")) {
            y = "yes";
            n = "";
        }else if(getRadioButtonChoice().equals("No")){
            y = "";
            n = "no";
        }else {
            y="";
            n="";
        }
        db.addAnswers(new CheckList(y,n,remarks.getText().toString()),t_name,id_no);
    }
}