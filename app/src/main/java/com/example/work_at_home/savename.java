package com.example.work_at_home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class savename extends AppCompatActivity {
FirebaseAuth auth;
FirebaseFirestore objectFirebaseFirestore;
EditText name;
TextView email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_savename);
        auth = FirebaseAuth.getInstance();
        objectFirebaseFirestore = FirebaseFirestore.getInstance();
    name=findViewById(R.id.name);
    email=findViewById(R.id.emailx);
    }

    public void Savetorealdb(View view) {
        try { FirebaseUser user = auth.getCurrentUser();
            String emails =auth.getCurrentUser().getEmail();
            email.setText(emails);
            if (!email.getText().toString().isEmpty() ) {
                Map<String, String> objectMap = new HashMap<>();
                objectMap.put("email", email.getText().toString());
                objectMap.put("name", name.getText().toString());

                objectFirebaseFirestore.collection("Users")
                        .document(email.getText().toString())
                        .set(objectMap)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {


                                Toast.makeText(savename.this, "Automatically logging in ", Toast.LENGTH_SHORT).show();
                                String namee=name.getText().toString();
                                Intent myIntent = new Intent(getBaseContext(), HomeActivity.class);
                                myIntent.putExtra("username",namee);
                                startActivity(myIntent);


                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(savename.this, "F", Toast.LENGTH_SHORT).show();
                            }
                        });

            } else {
                Toast.makeText(savename.this, "Enter Values", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            Toast.makeText(savename.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }

}

