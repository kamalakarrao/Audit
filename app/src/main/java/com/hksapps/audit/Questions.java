package com.hksapps.audit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Questions extends AppCompatActivity {

    String[] Q={};
    int j=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        final TextView ques = (TextView) findViewById(R.id.ques);
        DatabaseHandler db = new DatabaseHandler(this);


//Check work area table is empty or not
        if(db.IsWorkAreaTableEmpty()){
            db.addChecklists(new CheckList("Is Server Okay?"));
            db.addChecklists(new CheckList("Is Server Secured?"));
            db.addChecklists(new CheckList("Is Everything okay?"));
            db.addChecklists(new CheckList("Is it Fast?"));
            db.addChecklists(new CheckList("Is it Working fine?"));
            Toast.makeText(this, "Questions Added", Toast.LENGTH_SHORT).show();
        }





       /* Log.d("Insert: ", "Inserting ..");
        db.addChecklists(new CheckList("Is Server Okay?"));
        db.addChecklists(new CheckList("Is Server Secured?"));
        db.addChecklists(new CheckList("Is Everything okay?"));
        db.addChecklists(new CheckList("Is it Fast?"));
        db.addChecklists(new CheckList("Is it Working fine?"));
*/
        List<CheckList> allChecklists = db.getAllChecklists();

        StringBuilder builder = new StringBuilder();
        for (CheckList details : allChecklists) {
            builder.append(details + "\n");
        }
       /* String txt="";
        for(CheckList con : allChecklists){
             txt = txt +con.getChecklist();
            ques.setText(txt);
        }*/

        for(int i=0;i<allChecklists.size();i++)
        {
/*
            Q[i] = allChecklists.toString();
*/
        }


        Button next = (Button) findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(j>Q.length){
                    Toast.makeText(Questions.this, "All Questions done!", Toast.LENGTH_SHORT).show();
                }else {
                    ques.setText(Q[j]);
                    j++;

                }
            }
        });


        Button previous = (Button) findViewById(R.id.previous);
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(j<0){
                    Toast.makeText(Questions.this, "This is first question", Toast.LENGTH_SHORT).show();
                }else {
                    ques.setText(Q[j]);
                    j--;

                }
            }
        });




    }
}
