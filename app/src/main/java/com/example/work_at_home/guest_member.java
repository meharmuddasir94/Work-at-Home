package com.example.work_at_home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

public class guest_member extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_member);
    }


    public void fbbb(View view) {
        Intent i = new Intent(guest_member.this, Sign2.class);
        startActivity(i);
    }

    public void google(View view) {
        Intent i = new Intent(guest_member.this, Google_log.class);
        startActivity(i);
    }

    public void signup(View view) {

        startActivity(new Intent(guest_member.this, Guest_signup.class));
        Animatoo.animateSplit(this);
    }


    public void signIn(View view) {

        startActivity(new Intent(guest_member.this, guest_login.class));

        Animatoo.animateSwipeRight(this);
    }


    @Override
    public void onBackPressed() {

        startActivity(new Intent(guest_member.this, Guest_Home.class));
        Animatoo.animateSlideDown(this);
    }
}