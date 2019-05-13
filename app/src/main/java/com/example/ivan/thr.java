package com.example.ivan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class thr extends AppCompatActivity {
    ListView listView;

    public static final String hostname = "com.example.ivan.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thr);

        Intent intent = getIntent();
        String getHostel =intent.getStringExtra(sec.hostname);

        TextView text = findViewById(R.id.txt1);
        text.setText("You selected "+getHostel);
        listView=(ListView)findViewById(R.id.listhostel);
        final ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("MURISA HOSTEL");
        arrayList.add("HESTEN HOSTEL");
        arrayList.add("MARK HOSTEL");
        arrayList.add("TRIPLE B HOSTEL");
        arrayList.add("WHITE HOSTEL");
        arrayList.add("CONGENT HOSTEL");
        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayList);

       listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String title = (String) listView.getAdapter().getItem(i);
                Intent intent = new Intent(listView.getContext(),Hostel.class);

                intent.putExtra(hostname,title);
                listView.getContext().startActivity(intent);
                Toast.makeText(getApplicationContext(), ""+arrayList.get(i), Toast.LENGTH_SHORT).show();

            }
        });


    }
}


