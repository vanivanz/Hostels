package com.example.ivan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Name: Ndyabahika Ivan
//          Reg : 2017/BIT/121/ps

    }
    public void start(View view){
        Intent sec = new Intent(this,sec.class);
        startActivity(sec);

    }

    @Override
    protected void onStart() {
        super.onStart();

//        ProgressBar pb = findViewById(R.id.progressBar);
        Toast.makeText(this, "Starting", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}
