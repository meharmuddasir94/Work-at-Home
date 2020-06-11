package com.example.work_at_home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

public class creditcard extends AppCompatActivity {
EditText first,last,cvv,card;
DatePicker picker;
Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creditcard);
        card = findViewById(R.id.tvcardname);
        cvv = findViewById(R.id.CVV);
        first = findViewById(R.id.firstname);
        last = findViewById(R.id.lastname);
        btn = findViewById(R.id.btn2);
        picker = findViewById(R.id.date);
        if (card.getText().toString().isEmpty() && cvv.getText().toString().isEmpty() && first.getText().toString().isEmpty() && last.getText().toString().isEmpty()) {
         btn.setEnabled(false);
        } else {
       btn.setEnabled(true);

        }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(creditcard.this, "Click", Toast.LENGTH_SHORT).show();
            }
        });

    }
    public void back(View view) {
        onBackPressed();
    }
}