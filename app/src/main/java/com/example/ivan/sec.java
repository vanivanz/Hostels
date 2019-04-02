package com.example.ivan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class sec extends AppCompatActivity {
    public static final String hostname="com.example.ivan.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec);

        final ListView reg = findViewById(R.id.hostels);
        final ArrayList<String> list = new ArrayList<String>();
        list.add("Boma");
        list.add("Golf Course");
        list.add("Taso");
        list.add("Kashanyarazi");
        list.add("Kiswahili");
        list.add("Town");
        list.add("Kihumuro");

        ArrayAdapter<String> hostel= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
        reg.setAdapter(hostel);
        reg.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String title = (String) reg.getAdapter().getItem(i);
                Intent intent = new Intent(reg.getContext(),thr.class);

                intent.putExtra(hostname,title);
                reg.getContext().startActivity(intent);
                Toast.makeText(getApplicationContext(), ""+list.get(i), Toast.LENGTH_SHORT).show();





            }
        });
    }
}
