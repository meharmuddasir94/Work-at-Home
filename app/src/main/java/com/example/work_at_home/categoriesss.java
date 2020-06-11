package com.example.work_at_home;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.work_at_home.Fragments.AccountFragments;
import com.example.work_at_home.Fragments.HomeFragment;
import com.example.work_at_home.Fragments.MessageFragment;
import com.example.work_at_home.Fragments.NotificationFragment;
import com.example.work_at_home.Fragments.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.work_at_home.ui.main.SectionsPagerAdapter;

public class categoriesss extends AppCompatActivity {

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String TEXT = "text";
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoriesss);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        score = getIntent().getIntExtra("yourIntName", 0);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
    }

    public void basks(View view) {
        if (score == 200) {
            startActivity(new Intent(categoriesss.this, Guest_Home.class));
            Animatoo.animateSlideRight(this);
        }
        if(score==40){
            finish();
            startActivity(new Intent(categoriesss.this, Guest_Home.class));
            Animatoo.animateSlideRight(this);
        }
        if(score==40){
            finish();
            startActivity(new Intent(categoriesss.this, Guest_Home.class));
            Animatoo.animateSlideRight(this);

        }else {
            startActivity(new Intent(categoriesss.this, HomeActivity2.class));
            Animatoo.animateSlideRight(this);

        }
        if (score == 200) {
            finish();
            startActivity(new Intent(categoriesss.this, Guest_Home.class));
            Animatoo.animateSlideRight(this);
        }
        if(score==150){
            finish();
            startActivity(new Intent(categoriesss.this, Guest_Home.class));
            Animatoo.animateSlideRight(this);
        }
        if(score==0){
            finish();
            startActivity(new Intent(categoriesss.this, HomeActivity2.class));
            Animatoo.animateSlideRight(this);

        }
        if(score==30){
            finish();
            startActivity(new Intent(categoriesss.this, HomeActivity2.class));
            Animatoo.animateSlideRight(this);

        }
        if(score==40){
            finish();
            startActivity(new Intent(categoriesss.this, Guest_Home.class));
            Animatoo.animateSlideRight(this);

        }



        if(score==50){
            finish();
            startActivity(new Intent(categoriesss.this, Guest_Home.class));
            Animatoo.animateSlideRight(this);

        } if(score==10){
            finish();
            startActivity(new Intent(categoriesss.this, HomeActivity2.class));
            Animatoo.animateSlideRight(this);

        }
    }


    @Override
    public void onBackPressed() {
        if (score == 200) {
            finish();
            startActivity(new Intent(categoriesss.this, Guest_Home.class));
            Animatoo.animateSlideRight(this);
        }
        if(score==150){
            finish();
            startActivity(new Intent(categoriesss.this, Guest_Home.class));
            Animatoo.animateSlideRight(this);
        }
        if(score==0){
            finish();
            startActivity(new Intent(categoriesss.this, HomeActivity2.class));
            Animatoo.animateSlideRight(this);

        }
        if(score==30){
            finish();
            startActivity(new Intent(categoriesss.this, HomeActivity2.class));
            Animatoo.animateSlideRight(this);

        }
        if(score==40){
            finish();
            startActivity(new Intent(categoriesss.this, Guest_Home.class));
            Animatoo.animateSlideRight(this);

        }



        if(score==50){
            finish();
            startActivity(new Intent(categoriesss.this, Guest_Home.class));
            Animatoo.animateSlideRight(this);

        } if(score==10){
finish();
            startActivity(new Intent(categoriesss.this, HomeActivity2.class));
            Animatoo.animateSlideRight(this);

        }
    }
}