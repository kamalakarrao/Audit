package com.hksapps.audit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class FloorScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floor_screen);




        TextView first_floor = (TextView) findViewById(R.id.first_floor);
        TextView second_floor = (TextView) findViewById(R.id.second_floor);
        TextView third_floor = (TextView) findViewById(R.id.third_floor);
        TextView fourth_floor = (TextView) findViewById(R.id.fourth_floor);
        TextView fifth_floor = (TextView) findViewById(R.id.fifth_floor);


        first_floor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(FloorScreen.this, MainActivity.class);
                i.putExtra("floor_no",1);
                startActivity(i);

            }
        });


 second_floor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(FloorScreen.this, MainActivity.class);
                i.putExtra("floor_no",2);
                startActivity(i);

            }
        });


 third_floor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(FloorScreen.this, MainActivity.class);
                i.putExtra("floor_no",3);
                startActivity(i);

            }
        });


 fourth_floor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(FloorScreen.this, MainActivity.class);
                i.putExtra("floor_no",4);
                startActivity(i);

            }
        });



 fifth_floor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(FloorScreen.this, MainActivity.class);
                i.putExtra("floor_no",5);
                startActivity(i);

            }
        });



    }
}
