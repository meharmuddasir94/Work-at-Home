package com.example.work_at_home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.work_at_home.Fragments.HomeFragment;

public class Login extends AppCompatActivity {
TextView tv;
int score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        tv=findViewById(R.id.tvd);
    }


    public void fbbb(View view) {
        Intent i = new Intent(Login.this, Sign2.class);
        startActivity(i);
    }

    public void google(View view) {
        Intent i = new Intent(Login.this, Google_log.class);
        startActivity(i);
    }

    public void signup(View view) {

        startActivity(new Intent(Login.this, Sign_up.class));
        Animatoo.animateSplit(this);
    }


    public void signIn(View view) {

        startActivity(new Intent(Login.this, Log_in.class));

        Animatoo.animateSwipeRight(this);
    }

    public void Guest(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("DATA",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("key",tv.getText().toString());
        editor.apply();
        finish();
        startActivity(new Intent(Login.this, Guest_Home.class));
        Animatoo.animateSwipeLeft(this);

    }


    @Override
    public void onBackPressed() {
        if (score == 500) {
            startActivity(new Intent(Login.this, Guest_Home.class));
            Animatoo.animateSlideRight(this);
        }else {
            startActivity(new Intent(Login.this, Main2Activity.class));
            Animatoo.animateSlideDown(this);
        }
    }
}