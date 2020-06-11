package com.example.work_at_home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.google.firebase.auth.FirebaseAuth;

public class Settings extends AppCompatActivity {
FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
auth= FirebaseAuth.getInstance();

    }

    public void logout(View view) {
        auth.signOut();
        startActivity(new Intent(Settings.this, Login.class));
        finish();
    }

    public void opentoverfy(View view) {
        startActivity(new Intent(Settings.this, security.class));
        Animatoo.animateSlideLeft(this);

    }

    public void language(View view) {
        int yourInt = 700;
        Intent myIntent = new Intent(Settings.this, Language.class);
        myIntent.putExtra("yourIntName", yourInt);
        startActivity(myIntent);
    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }

    public void terms(View view) {
        Intent myIntent = new Intent(Settings.this, privacy.class);
        startActivity(myIntent);
        Animatoo.animateSlideRight(this);

    }

    public void policy(View view) {

        Intent myIntent = new Intent(Settings.this, Policy.class);
        startActivity(myIntent);
        Animatoo.animateSlideRight(this);

    }
}

