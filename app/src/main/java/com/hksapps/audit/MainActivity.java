package com.hksapps.audit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView WorkArea = (TextView) findViewById(R.id.workarea);
        WorkArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


Intent i = new Intent(MainActivity.this,Questions.class);
                    startActivity(i);

            }
        });
    }
}
