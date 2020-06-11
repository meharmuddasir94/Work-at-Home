package com.example.work_at_home;

import android.content.Intent;
import android.os.Bundle;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.work_at_home.ui.main.SectionsPagerAdapter1;
import com.example.work_at_home.ui.main.SectionsPagerAdapter3;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.work_at_home.ui.main.SectionsPagerAdapter;

public class guestproblem2 extends AppCompatActivity {
int score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guestproblem2);
        SectionsPagerAdapter3 sectionsPagerAdapter = new SectionsPagerAdapter3(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        score = getIntent().getIntExtra("yourIntName", 0);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

    }

    @Override
    public void onBackPressed() {
        if(score == 150) {
            finish();
            startActivity(new Intent(guestproblem2.this, Guest_Home.class));
            Animatoo.animateSlideRight(this);
        }else{
            finish();
            startActivity(new Intent(guestproblem2.this, HomeActivity2.class));
            Animatoo.animateSlideRight(this);


        }
    }

    public void searchopen(View view) {
        if (score == 150) {
            int yourInt = 50;
            Intent myIntent = new Intent(guestproblem2.this, categoriesss.class);
            myIntent.putExtra("yourIntName", yourInt);
            startActivity(myIntent);
            Animatoo.animateSlideRight(this);
        }
        if(score==0)
        { int yourInt = 10;
            Intent myIntent = new Intent(guestproblem2.this, categoriesss.class);
            myIntent.putExtra("yourIntName", yourInt);
            startActivity(myIntent);
            Animatoo.animateSlideRight(this);
        }
    }
}

