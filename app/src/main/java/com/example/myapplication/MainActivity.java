package com.example.myapplication;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
  private BottomNavigationView mbottom;
  private FrameLayout mframe;
  private First firstfragment;
    private Second secondfragment;
    private Third thirdfragment;
    private four fourfragment;
    private five fivefragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mbottom= (BottomNavigationView) findViewById(R.id.bottom_navi);
        mframe = (FrameLayout) findViewById(R.id.fragment_container);

        firstfragment = new First();
        secondfragment = new Second();
        thirdfragment = new Third();
        fourfragment = new four();
        fivefragment = new five();

        setFragment(firstfragment);

        mbottom.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId())
                {
                    case R.id.nav_first:
                        setFragment(firstfragment);
                        return true;

                    case R.id.nav_second:
                        setFragment(secondfragment);
                        return true;

                    case R.id.nav_third:
                        mbottom.setItemBackgroundResource(R.color.colorAccent);
                        setFragment(thirdfragment);
                        return true;

                    case R.id.nav_four:
                        setFragment(fourfragment);
                        return true;

                    case R.id.nav_five:
                        setFragment(fivefragment);
                    return true;

                    default:
                        return false;
                }
            }


        });
    }
    private void setFragment(Fragment fragment) {

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
    }
}