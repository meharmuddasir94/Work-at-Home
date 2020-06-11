package com.example.work_at_home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

public class Language_Guest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language__guest);
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(Language_Guest.this,Guest_Home.class);
        startActivity(i);
        Animatoo.animateSlideRight(this);
         }
}