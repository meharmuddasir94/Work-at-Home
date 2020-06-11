package com.example.work_at_home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Payment extends AppCompatActivity {
    RadioButton radios;
    RadioGroup radioGroup;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        radioGroup = findViewById(R.id.radio);
        btn=findViewById(R.id.btn2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radioID = radioGroup.getCheckedRadioButtonId();
                radios = findViewById(radioID);
                String ch = radios.getText().toString();
                if (radios.getText().toString().equals("one")) {
                    Intent intent = new Intent(Payment.this, creditcard.class);
                    startActivity(intent);

                }
                if (radios.getText().toString().equals("two")) {
                    Toast.makeText(Payment.this, "Sorry this Option  Service is not Avaliable in your Region", Toast.LENGTH_SHORT).show();
                }

                if (radios.getText().toString().equals("three")) {
                    Intent intent = new Intent(Payment.this, GooglePay.class);
                    startActivity(intent);
                }
            }

        });
    }

    public  void checkButton(View v){
        int radioID= radioGroup.getCheckedRadioButtonId();
        radios=findViewById(radioID);

    }

    public void back(View view) {
        onBackPressed();
    }

}