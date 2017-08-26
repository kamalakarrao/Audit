package com.hksapps.audit;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.ajts.androidmads.library.SQLiteToExcel;

import java.util.ArrayList;
import java.util.List;

public class ReviewScreen extends AppCompatActivity {

    private ViewGroup mLinearLayout;
    private Button exptable;
    private DatabaseHandler db;
    private ArrayList<String> question_chk, yes_chk, no_chk, remarks_chk;
    private String table_name;


    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_screen);
        mLinearLayout = (ViewGroup) findViewById(R.id.l_layout);


        db = new DatabaseHandler(this);

        Intent intent = getIntent();
        table_name = intent.getStringExtra("table_name");

        getAnswersFromDb(table_name);


        mLinearLayout.removeAllViews();
        for (int i = 0; i < question_chk.size(); i++) {

            addLayout(question_chk.get(i).toString(), (yes_chk.get(i).toString() + no_chk.get(i).toString()).trim(), remarks_chk.get(i).toString(), i);


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

    private void addLayout(String textViewText, String textview_answer, String textview_remark, final int j) {
        View layout2 = LayoutInflater.from(this).inflate(R.layout.activity_review_screen, mLinearLayout, false);

        TextView question = (TextView) layout2.findViewById(R.id.question);
        TextView answer = (TextView) layout2.findViewById(R.id.answer);
        TextView review_remark = (TextView) layout2.findViewById(R.id.review_remark);
        Button edit = (Button) layout2.findViewById(R.id.edit);


        exptable = (Button) layout2.findViewById(R.id.exp_table);
        exptable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ExportingOneTable(table_name);
            }
        });


        if (j + 1 == question_chk.size()) {
            exptable.setVisibility(View.VISIBLE);
        } else {
            exptable.setVisibility(View.GONE);

        }


        question.setText(textViewText);
        answer.setText(textview_answer);
        review_remark.setText(textview_remark);


        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ReviewScreen.this, "Loaded", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(ReviewScreen.this, Questions.class); // Your list's Intent
                i.setFlags(i.getFlags() | Intent.FLAG_ACTIVITY_NO_HISTORY);
                //Sending Value 20 to Questions screen
                i.putExtra("value", 20);
                i.putExtra("question_number", j);
                i.putExtra("tab_name", table_name);
                // Adds the FLAG_ACTIVITY_NO_HISTORY flag
                startActivity(i);
            }
        });

        mLinearLayout.addView(layout2);
    }

    public boolean isStoragePermissionGranted() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {
                return true;
            } else {

                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                return false;
            }
        } else { //permission is automatically granted on sdk<23 upon installation
            return true;
        }
    }

    public void ExportingOneTable(String t_name) {


        if (isStoragePermissionGranted()) {


            SQLiteToExcel sqliteToExcel = new SQLiteToExcel(ReviewScreen.this, "audit");
            sqliteToExcel.exportSingleTable(t_name, "Audit_" + t_name + ".xlsx", new SQLiteToExcel.ExportListener() {
                @Override
                public void onStart() {
                    Toast.makeText(ReviewScreen.this, "Started Exporting", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onCompleted(String filePath) {

                    Toast.makeText(ReviewScreen.this, "File is saved at " + filePath, Toast.LENGTH_SHORT).show();

                }

                @Override
                public void onError(Exception e) {

                    Toast.makeText(ReviewScreen.this, "Error Occured " + e, Toast.LENGTH_SHORT).show();

                }
            });
        }

    }

}
