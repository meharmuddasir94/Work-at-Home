package com.example.work_at_home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class Forgetpas extends AppCompatActivity {
TextView email;
FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgetpas);
        email=findViewById(R.id.email);
        auth=FirebaseAuth.getInstance();
    }

    public void reset(View view) {
        String name= email.getText().toString();
        if(TextUtils.isEmpty(name)){
            Toast.makeText(this, "Please enter the email,if you want to reset password", Toast.LENGTH_SHORT).show();
        }else{
            auth.sendPasswordResetEmail(name).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(Forgetpas.this, "Password reset link is send to your email", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Forgetpas.this,Log_in.class));

                    }else{
                        Toast.makeText(Forgetpas.this, "Please enter valid email address", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}