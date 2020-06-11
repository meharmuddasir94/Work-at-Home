package com.example.work_at_home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class  guest_login extends AppCompatActivity {
    EditText email,pass;
    Button btn2;
    TextView show;
    ProgressDialog progressDialog;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_login);
        email = findViewById(R.id.email);
        pass=findViewById(R.id.pass);
        pass.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        email=findViewById(R.id.email);
        show=findViewById(R.id.show);
        show.setVisibility(View.GONE);
        pass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(pass.getText().length()>0){
                    show.setVisibility(View.VISIBLE);
                }else {
                    show.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(show.getText()=="SHOW"){
                    show.setText("HIDE");
                    pass.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    pass.setSelection(pass.length());

                }else{
                    show.setText("SHOW");
                    pass.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    pass.setSelection(pass.length());

                }
            }
        });


        firebaseAuth = FirebaseAuth.getInstance();

        btn2 = (Button) findViewById(R.id.btn2);
        progressDialog = new ProgressDialog(this);

    }

    public void register(View view) {
        Intent i = new Intent(guest_login.this, guest_member.class);
        startActivity(i);

    }

    public void userLogin(View view) {

        String semail = email.getText().toString().trim();
        String spassword = pass.getText().toString().trim();

        if (TextUtils.isEmpty(semail)) {
            Toast.makeText(this, "Please Enter Email", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(spassword)) {
            Toast.makeText(this, "Please Enter Password", Toast.LENGTH_SHORT).show();
            return;
        }else if(spassword.length()<6) {
            Toast.makeText(this, "Password must of 6 digits", Toast.LENGTH_SHORT).show();
        }
        progressDialog.setMessage("Log In...");
        progressDialog.show();
        firebaseAuth.signInWithEmailAndPassword(semail, spassword)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if (task.isSuccessful()) {

                            Toast.makeText(guest_login.this, "Logging In", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(guest_login.this, HomeActivity2.class));
                            finish();
                        }else{
                            Toast.makeText(guest_login.this, "Login Fail check your email or password", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
    public void onBackPressed() {
        startActivity( new Intent(guest_login.this, Guest_Home.class));

        Animatoo.animateSlideRight(this);
    }

    public void forgets(View view) {
        startActivity( new Intent(guest_login.this, Forgetpas.class));
        Animatoo.animateSplit(this);
    }
}

