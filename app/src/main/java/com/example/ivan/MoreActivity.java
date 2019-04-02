package com.example.ivan;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

public class MoreActivity extends AppCompatActivity {
  BottomNavigationView bottomNavigationView;
  FrameLayout frameLayout;
  AccountFragment accountFragment;
  HelpFragment helpFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);
        bottomNavigationView=findViewById(R.id.navigation);
        frameLayout=findViewById(R.id.frame_layout);
        accountFragment=new AccountFragment();
        helpFragment=new HelpFragment();
        setFragement(accountFragment);


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.account:
                        setFragement(accountFragment);
                        break;
                    case R.id.help:
                        setFragement(helpFragment);
                        break;
                }
                return false;
            }
        });
    }
    public void setFragement(android.support.v4.app.Fragment fragement){
        android.support.v4.app.FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragement);
        fragmentTransaction.commit();

    }
}
