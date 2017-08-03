package com.hksapps.audit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Questions extends AppCompatActivity {


    int j=1;

    ArrayList<String> question_chk;

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


        Log.e("size check list ", String.valueOf(allChecklists.size()));

         question_chk=new ArrayList<>();
        for(CheckList con : allChecklists) {
            String temp = con.getChecklist();
            question_chk.add(temp);

        }









    }
}
