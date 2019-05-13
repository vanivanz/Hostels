package com.example.ivan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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
        list.add("Taso Village Hostels");
        list.add("Golf Course");
        list.add("Boma");
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_items,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.setting:
                startActivity(new Intent(getApplicationContext(),MoreActivity.class));
                break;
            case R.id.email:
                startActivity(new Intent(getApplicationContext(),Email.class));
                break;
            case R.id.share:
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                String shareBodyText = "SHARE THE APP TO OTHERS";
                intent.putExtra(Intent.EXTRA_TEXT, shareBodyText);
                startActivity(Intent.createChooser(intent,"Choose app to complete sharing"));
                default:
                    return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
