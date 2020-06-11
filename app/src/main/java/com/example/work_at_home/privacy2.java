package com.example.work_at_home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

public class privacy2 extends AppCompatActivity {
WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy2);
        webView = (WebView) findViewById(R.id.webView);
        webView.loadUrl("file:///android_asset/privacy.html");
    }
    public void onBackPressed() {
        Intent myIntent = new Intent(privacy2.this, Guest_Home.class);
        startActivity(myIntent);
        Animatoo.animateSlideRight(this);

    }
}