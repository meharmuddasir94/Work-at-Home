package com.example.work_at_home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

public class Support extends AppCompatActivity {
WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support);

        webView =(WebView)findViewById(R.id.webView);
        webView.loadUrl("file:///android_asset/support.html");

    }
    public void onBackPressed() {
        Intent myIntent = new Intent(Support.this, Guest_Home.class);
        startActivity(myIntent);
        Animatoo.animateSlideRight(this);

    }
}