package com.hksapps.audit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ReviewScreen extends AppCompatActivity {

    private ViewGroup mLinearLayout;
    private DatabaseHandler db;
    private ArrayList<String> question_chk,yes_chk,no_chk,remarks_chk;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_screen);
        mLinearLayout = (ViewGroup) findViewById(R.id.l_layout);

        db = new DatabaseHandler(this);

        Intent intent = getIntent();
        String table_name = intent.getStringExtra("table_name");

        getAnswersFromDb(table_name);

mLinearLayout.removeAllViews();
        for(int i = 0;i<question_chk.size();i++){

            addLayout(question_chk.get(i).toString(),(yes_chk.get(i).toString()+no_chk.get(i).toString()).trim(),remarks_chk.get(i).toString(),i);



        }


    }


private void getAnswersFromDb(String t_name) {

    List<CheckList> allChecklists = db.getAllChecklists(t_name);

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

    private void addLayout(String textViewText, String textview_answer, String textview_remark, final int i) {
        View layout2 = LayoutInflater.from(this).inflate(R.layout.activity_review_screen, mLinearLayout, false);

        TextView question = (TextView) layout2.findViewById(R.id.question);
        TextView answer = (TextView) layout2.findViewById(R.id.answer);
        TextView review_remark = (TextView) layout2.findViewById(R.id.review_remark);
        Button edit = (Button) layout2.findViewById(R.id.edit);


        question.setText(textViewText);
        answer.setText(textview_answer);
        review_remark.setText(textview_remark);

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ReviewScreen.this, String.valueOf(i), Toast.LENGTH_SHORT).show();
            }
        });

        mLinearLayout.addView(layout2);
    }


}
