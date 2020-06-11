package com.example.work_at_home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class gig_open extends AppCompatActivity {
    TextView  tv,tv1,tv2,tv3,tv4;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gig_open);
        tv = findViewById(R.id.tv);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.desreal);
        tv3 = findViewById(R.id.dayreal);
        tv4 = findViewById(R.id.catreal);
        String de = getIntent().getStringExtra("userdes");

        String day = getIntent().getStringExtra("usertime");
        String bud = getIntent().getStringExtra("userbudget");
        final String email = getIntent().getStringExtra("usernam");
        String ca = getIntent().getStringExtra("usercat");


        tv.setText(email);
        tv1.setText(bud);
        tv2.setText(de);
        tv3.setText(day);
        tv4.setText(ca);
        fab=findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rem = tv.getText().toString();
                Intent intent = new Intent(gig_open.this,MassageActivity.class);
                intent.putExtra("email",rem);
                startActivity(intent);
            }
        });

    }
public void back(View view) {
        onBackPressed();
    }

    public void buy(View view) {
        String m = tv1.getText().toString();
        String d = tv3.getText().toString();
        String over = tv2.getText().toString();
        Intent intent= new Intent(gig_open.this,buy.class);
    intent.putExtra("money",m) ;
    intent.putExtra("delivery",d);
        intent.putExtra("descri",over);
    startActivity(intent);

    }
}