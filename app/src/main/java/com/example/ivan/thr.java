package com.example.ivan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class thr extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thr);

        Intent intent = getIntent();
        String getHostel =intent.getStringExtra(sec.hostname);

        TextView text = findViewById(R.id.txt1);
        text.setText("You selected "+getHostel);



    }
}
