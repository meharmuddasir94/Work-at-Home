package com.example.work_at_home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

public class sellers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sellers);
    }

    public void dropdown(View view) {
        startActivity( new Intent(sellers.this, Main2Activity.class));
        Animatoo.animateSlideDown(this);

    }

    public void gooo(View view) {
        startActivity( new Intent(sellers.this, Login.class));
        Animatoo.animateSlideLeft(this);
    }
}
