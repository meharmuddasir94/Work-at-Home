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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Sign_up extends AppCompatActivity {
    EditText email,pass;

    int score;
    TextView show,name;
    Button btn2;
FirebaseFirestore objectFirebaseFirestore;
    FirebaseUser user;
    DatabaseReference reference;
    ProgressDialog progressDialog;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        pass=findViewById(R.id.pass);
        name=findViewById(R.id.name);
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
        objectFirebaseFirestore = FirebaseFirestore.getInstance();
        btn2 = (Button) findViewById(R.id.btn2);
        progressDialog = new ProgressDialog(this);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                   registerUser();


            }
        });

    }

    public void registerUser() {
        String semail = email.getText().toString().trim();
        String spassword = pass.getText().toString().trim();
        if (TextUtils.isEmpty(semail)) {
            Toast.makeText(this, "Please Enter Email", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(spassword)) {
            Toast.makeText(this, "Please Enter Password", Toast.LENGTH_SHORT).show();
            return;
        }
        if(spassword.length()<6){
            Toast.makeText(this, "Minimum Length is 6 ", Toast.LENGTH_SHORT).show();
            return;
        }
        progressDialog.setMessage("Registrating User...");
        progressDialog.show();
        firebaseAuth.createUserWithEmailAndPassword(semail, spassword)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
                            startActivity(new Intent(Sign_up.this, Log_in.class));
                            Toast.makeText(Sign_up.this, "User Registered Successfully", Toast.LENGTH_SHORT).show();
                            btn2.setEnabled(false);
                            storedata();
                            progressDialog.dismiss();
                            email.setText("");
                            pass.setText("");
                            finish();

                        } else {
                            Toast.makeText(Sign_up.this, "Failed to Sign up ", Toast.LENGTH_SHORT).show();
                            btn2.setEnabled(true);
                            progressDialog.dismiss();
                        }
                    }
                });
    }

    public void log(View view) {
        Intent i = new Intent(Sign_up.this, Log_in.class);
        startActivity(i);
    }
    public void onBackPressed() {
        super.onBackPressed();
        Animatoo.animateSlideRight(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(firebaseAuth.getCurrentUser()!=null){
            firebaseAuth.signOut();
        }
    }
    public void storedata(){
     try {
        if (!email.getText().toString().isEmpty() ) {
            Map<String, String> objectMap = new HashMap<>();
            objectMap.put("email", email.getText().toString());
            objectMap.put("name", name.getText().toString());
            progressDialog.setMessage("Logging in...");
            progressDialog.show();
            objectFirebaseFirestore.collection("Users")
                    .document(email.getText().toString())
                    .set(objectMap)
                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {


                            Toast.makeText(Sign_up.this, "Automatically logging in ", Toast.LENGTH_SHORT).show();
                            String namee=name.getText().toString();
                            Intent myIntent = new Intent(getBaseContext(), HomeActivity.class);
                            myIntent.putExtra("username",namee);
                            startActivity(myIntent);
                            progressDialog.dismiss();



                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(Sign_up.this, "F", Toast.LENGTH_SHORT).show();
                        }
                    });

        } else {
            Toast.makeText(Sign_up.this, "Enter Values", Toast.LENGTH_SHORT).show();
        }
    } catch (Exception e) {
        Toast.makeText(Sign_up.this, e.getMessage(), Toast.LENGTH_SHORT).show();
    }

}

        }




