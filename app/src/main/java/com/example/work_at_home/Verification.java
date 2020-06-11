package com.example.work_at_home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class Verification extends AppCompatActivity {
Spinner spinner;
EditText phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);
        spinner=findViewById(R.id.spinners);
        phone=findViewById(R.id.phone);
        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, CountryData.countryNames));
    }

    public void send(View view) {
        String code = CountryData.countryAreaCodes[spinner.getSelectedItemPosition()];

        String number = phone.getText().toString().trim();

        if (number.isEmpty() || number.length() < 10) {
            phone.setError("Valid number is required");
            phone.requestFocus();
            return;
        }

        String phonenumber = "+" + code + number;

        Intent intent = new Intent(Verification.this, otpActictiy.class);
        intent.putExtra("phonenumber", phonenumber);
        startActivity(intent);

    }
}