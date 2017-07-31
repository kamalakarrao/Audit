package com.hksapps.audit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

public class Questions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        TextView ques = (TextView) findViewById(R.id.ques);
        DatabaseHandler db = new DatabaseHandler(this);

        Log.d("Insert: ", "Inserting ..");
        db.addChecklists(new CheckList("Is Server Okay?"));
        db.addChecklists(new CheckList("Is Server Secured?"));
        db.addChecklists(new CheckList("Is Everything okay?"));
        db.addChecklists(new CheckList("Is it Fast?"));
        db.addChecklists(new CheckList("Is it Working fine?"));

        List<CheckList> allChecklists = db.getAllChecklists();

      /*  StringBuilder builder = new StringBuilder();
        for (CheckList details : allChecklists) {
            builder.append(details + "\n");
        }*/
        String txt="";
        for(CheckList con : allChecklists){
             txt = txt +con.getChecklist()+"\\n";
            ques.setText(txt);
        }


    }
}
