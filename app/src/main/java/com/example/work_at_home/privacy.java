package com.example.work_at_home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class privacy extends AppCompatActivity {
WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy);
        webView =(WebView)findViewById(R.id.webView);
        webView.loadUrl("file:///android_asset/privacy.html");
    }
}