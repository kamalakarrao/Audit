package com.hksapps.audit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class OdcWorkHubRoom extends AppCompatActivity {

    Button workareabtn, hubroombtn;
    int floor_no, odc_no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_odc_work_hub_room);


        Intent intent_OdcWorkHub = getIntent();
        floor_no = intent_OdcWorkHub.getIntExtra("floor_no", 0);
        odc_no = intent_OdcWorkHub.getIntExtra("odc_no", 0);

        setTitle("Floor - " + floor_no + " ODC - " + odc_no);


        workareabtn = (Button) findViewById(R.id.workareabtn);
        hubroombtn = (Button) findViewById(R.id.hubroombtn);


        hubroombtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent in = new Intent(OdcWorkHubRoom.this, Questions.class);
                in.putExtra("value", 7);


                switch (floor_no) {

                    case 1:
                        switch (odc_no) {

                            case 1:
                                in.putExtra("hub_tab_name", Constants.TABLE_1F_ODC_1);
                                break;
                            case 2:
                                in.putExtra("hub_tab_name", Constants.TABLE_1F_ODC_2);
                                break;
                            case 3:
                                in.putExtra("hub_tab_name", Constants.TABLE_1F_ODC_3);
                                break;
                            case 4:
                                in.putExtra("hub_tab_name", Constants.TABLE_1F_ODC_4);
                                break;
                            case 5:
                                in.putExtra("hub_tab_name", Constants.TABLE_1F_ODC_5);
                                break;


                        }
                        break;

                    case 2:

                        switch (odc_no) {

                            case 1:
                                in.putExtra("hub_tab_name", Constants.TABLE_2F_ODC_1);
                                break;
                            case 2:
                                in.putExtra("hub_tab_name", Constants.TABLE_2F_ODC_2);
                                break;
                            case 3:
                                in.putExtra("hub_tab_name", Constants.TABLE_2F_ODC_3);
                                break;
                            case 4:
                                in.putExtra("hub_tab_name", Constants.TABLE_2F_ODC_4);
                                break;
                            case 5:
                                in.putExtra("hub_tab_name", Constants.TABLE_2F_ODC_5);
                                break;


                        }
                        break;

                    case 3:

                        switch (odc_no) {

                            case 1:
                                in.putExtra("hub_tab_name", Constants.TABLE_3F_ODC_1);
                                break;
                            case 2:
                                in.putExtra("hub_tab_name", Constants.TABLE_3F_ODC_2);
                                break;
                            case 3:
                                in.putExtra("hub_tab_name", Constants.TABLE_3F_ODC_3);
                                break;
                            case 4:
                                in.putExtra("hub_tab_name", Constants.TABLE_3F_ODC_4);
                                break;
                            case 5:
                                in.putExtra("hub_tab_name", Constants.TABLE_3F_ODC_5);
                                break;


                        }
                        break;

                    case 4:

                        switch (odc_no) {

                            case 1:
                                in.putExtra("hub_tab_name", Constants.TABLE_4F_ODC_1);
                                break;
                            case 2:
                                in.putExtra("hub_tab_name", Constants.TABLE_4F_ODC_2);
                                break;
                            case 3:
                                in.putExtra("hub_tab_name", Constants.TABLE_4F_ODC_3);
                                break;
                            case 4:
                                in.putExtra("hub_tab_name", Constants.TABLE_4F_ODC_4);
                                break;

                        }
                        break;

                    case 5:

                        switch (odc_no) {

                            case 1:
                                in.putExtra("hub_tab_name", Constants.TABLE_5F_ODC_1);
                                break;
                            case 2:
                                in.putExtra("hub_tab_name", Constants.TABLE_5F_ODC_2);
                                break;
                            case 3:
                                in.putExtra("hub_tab_name", Constants.TABLE_5F_ODC_3);
                                break;
                            case 4:
                                in.putExtra("hub_tab_name", Constants.TABLE_5F_ODC_4);
                                break;

                        }
                        break;


                }

                startActivity(in);


            }
        });


    }
}
