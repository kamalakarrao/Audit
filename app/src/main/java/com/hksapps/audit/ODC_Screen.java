package com.hksapps.audit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;


public class ODC_Screen extends AppCompatActivity {

    private TextView odc1, odc2, odc3, odc4, odc5;
    private Spinner spinner;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_odc__screen);

        odc1 = (TextView) findViewById(R.id.odc1);
        odc2 = (TextView) findViewById(R.id.odc2);
        odc3 = (TextView) findViewById(R.id.odc3);
        odc4 = (TextView) findViewById(R.id.odc4);
        odc5 = (TextView) findViewById(R.id.odc5);


        spinner = (Spinner) findViewById(R.id.spinner);

        ArrayList<String> floors = new ArrayList<String>();
        floors.clear();
        floors.add("1st Floor");
        floors.add("2nd Floor");
        floors.add("3rd Floor");
        floors.add("4th Floor");
        floors.add("5th Floor");


        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, floors);

        spinner.setAdapter(dataAdapter);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (adapterView.getSelectedItemPosition() == 3 || adapterView.getSelectedItemPosition() == 4) {
                    odc5.setVisibility(View.GONE);

                } else {
                    odc5.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        odc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int pos = spinner.getSelectedItemPosition();
                intent = new Intent(ODC_Screen.this, Questions.class);

                switch (pos) {

                    case 0:
                        intent.putExtra("value", 7);
                        intent.putExtra("hub_tab_name", Constants.TABLE_1F_ODC_1);
                        break;

                    case 1:
                        intent.putExtra("value", 7);
                        intent.putExtra("hub_tab_name", Constants.TABLE_2F_ODC_1);
                        break;

                    case 2:
                        intent.putExtra("value", 7);
                        intent.putExtra("hub_tab_name", Constants.TABLE_3F_ODC_1);
                        break;

                    case 3:
                        intent.putExtra("value", 7);
                        intent.putExtra("hub_tab_name", Constants.TABLE_4F_ODC_1);
                        break;

                    case 4:
                        intent.putExtra("value", 7);
                        intent.putExtra("hub_tab_name", Constants.TABLE_5F_ODC_1);
                        break;


                }

                startActivity(intent);


            }
        });


        odc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int pos = spinner.getSelectedItemPosition();
                intent = new Intent(ODC_Screen.this, Questions.class);

                switch (pos) {

                    case 0:
                        intent.putExtra("value", 7);
                        intent.putExtra("hub_tab_name", Constants.TABLE_1F_ODC_2);
                        break;

                    case 1:
                        intent.putExtra("value", 7);
                        intent.putExtra("hub_tab_name", Constants.TABLE_2F_ODC_2);
                        break;

                    case 2:
                        intent.putExtra("value", 7);
                        intent.putExtra("hub_tab_name", Constants.TABLE_3F_ODC_2);
                        break;

                    case 3:
                        intent.putExtra("value", 7);
                        intent.putExtra("hub_tab_name", Constants.TABLE_4F_ODC_2);
                        break;

                    case 4:
                        intent.putExtra("value", 7);
                        intent.putExtra("hub_tab_name", Constants.TABLE_5F_ODC_2);
                        break;


                }

                startActivity(intent);


            }
        });


        odc3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int pos = spinner.getSelectedItemPosition();
                intent = new Intent(ODC_Screen.this, Questions.class);

                switch (pos) {

                    case 0:
                        intent.putExtra("value", 7);
                        intent.putExtra("hub_tab_name", Constants.TABLE_1F_ODC_3);
                        break;

                    case 1:
                        intent.putExtra("value", 7);
                        intent.putExtra("hub_tab_name", Constants.TABLE_2F_ODC_3);
                        break;

                    case 2:
                        intent.putExtra("value", 7);
                        intent.putExtra("hub_tab_name", Constants.TABLE_3F_ODC_3);
                        break;

                    case 3:
                        intent.putExtra("value", 7);
                        intent.putExtra("hub_tab_name", Constants.TABLE_4F_ODC_3);
                        break;

                    case 4:
                        intent.putExtra("value", 7);
                        intent.putExtra("hub_tab_name", Constants.TABLE_5F_ODC_3);
                        break;


                }

                startActivity(intent);


            }
        });


        odc4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int pos = spinner.getSelectedItemPosition();
                intent = new Intent(ODC_Screen.this, Questions.class);

                switch (pos) {

                    case 0:
                        intent.putExtra("value", 7);
                        intent.putExtra("hub_tab_name", Constants.TABLE_1F_ODC_4);
                        break;

                    case 1:
                        intent.putExtra("value", 7);
                        intent.putExtra("hub_tab_name", Constants.TABLE_2F_ODC_4);
                        break;

                    case 2:
                        intent.putExtra("value", 7);
                        intent.putExtra("hub_tab_name", Constants.TABLE_3F_ODC_4);
                        break;

                    case 3:
                        intent.putExtra("value", 7);
                        intent.putExtra("hub_tab_name", Constants.TABLE_4F_ODC_4);
                        break;

                    case 4:
                        intent.putExtra("value", 7);
                        intent.putExtra("hub_tab_name", Constants.TABLE_5F_ODC_4);
                        break;


                }

                startActivity(intent);


            }
        });


        odc5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int pos = spinner.getSelectedItemPosition();
                intent = new Intent(ODC_Screen.this, Questions.class);

                switch (pos) {

                    case 0:
                        intent.putExtra("value", 7);
                        intent.putExtra("hub_tab_name", Constants.TABLE_1F_ODC_5);
                        break;

                    case 1:
                        intent.putExtra("value", 7);
                        intent.putExtra("hub_tab_name", Constants.TABLE_2F_ODC_5);
                        break;

                    case 2:
                        intent.putExtra("value", 7);
                        intent.putExtra("hub_tab_name", Constants.TABLE_3F_ODC_5);
                        break;


                }

                startActivity(intent);


            }
        });





    }
}
