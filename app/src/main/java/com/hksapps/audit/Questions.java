package com.hksapps.audit;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Questions extends AppCompatActivity {

    static TextView ques;
     static int j=1;
    String table_name;

    ArrayList<String> question_chk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);


        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
       int value = pref.getInt("questions_screen", 0);


        ques = (TextView) findViewById(R.id.ques);
        DatabaseHandler db = new DatabaseHandler(this);

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
        List<CheckList> allChecklists = db.getAllChecklists(table_name);

        StringBuilder builder = new StringBuilder();
        for (CheckList details : allChecklists) {
            builder.append(details + "\n");
        }


        Log.e("size check list ", String.valueOf(allChecklists.size()));

         question_chk=new ArrayList<>();
        for(CheckList con : allChecklists) {
            String temp = con.getChecklist();
            question_chk.add(temp);

        }

        ques.setText(question_chk.get(0));

        Button next = (Button) findViewById(R.id.next);
        Button previous = (Button) findViewById(R.id.previous);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(j>=question_chk.size()-1){

                    Toast.makeText(Questions.this, "All Questions are done!" , Toast.LENGTH_SHORT).show();


                }else {

                        j++;
                        ques.setText(question_chk.get(j));
                }

                Toast.makeText(Questions.this, String.valueOf(j) , Toast.LENGTH_SHORT).show();
            }
        });


        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(j<=0){

                    Toast.makeText(Questions.this, "This is 1st Question" , Toast.LENGTH_SHORT).show();
                }
                else {
                    j--;
                    ques.setText(question_chk.get(j));

                }


            }
        });






    }
}
