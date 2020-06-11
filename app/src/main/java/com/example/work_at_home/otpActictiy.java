package com.example.work_at_home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class otpActictiy extends AppCompatActivity {
    String codeid;
     FirebaseAuth mAuth;
     ProgressBar progressBar;
     TextView tv1,tv2;
    FirebaseUser user;
    DatabaseReference reference;
    FirebaseFirestore objectFirebaseFirestore;
    DocumentReference documentReference;
    EditText inputcodes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_actictiy);
        mAuth=FirebaseAuth.getInstance();
        progressBar=findViewById(R.id.progress_bar);
        inputcodes=findViewById(R.id.ico);
        String pnumber = getIntent().getStringExtra("phonenumber");
        sendVerificationCode(pnumber);
        objectFirebaseFirestore = FirebaseFirestore.getInstance();
tv1=findViewById(R.id.tv1);
tv2=findViewById(R.id.tv2);
tv2.setText(pnumber);
        if(mAuth != null){
            String i =mAuth.getCurrentUser().getEmail();
            tv1.setText(i);
        }



    }

    public void verfyss(View view) {
        String code = inputcodes.getText().toString().trim();

        if ((code.isEmpty() || code.length() < 6)){

            inputcodes.setError("Enter code...");
            inputcodes.requestFocus();
            return;
        }
        verifyCode(code);

    }

private void verifyCode(String code){
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(codeid, code);
        signInWithCredential(credential);
        }

    private void signInWithCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                           addphone();

                        } else {
                            Toast.makeText(otpActictiy.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }

                });
    }

    private void sendVerificationCode(String number){

        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                number,
                60,
                TimeUnit.SECONDS,
                TaskExecutors.MAIN_THREAD,
                mCallBack
        );
    }

    private PhoneAuthProvider.OnVerificationStateChangedCallbacks
            mCallBack = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

        @Override
        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);
            codeid = s;
        }

        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
            String code = phoneAuthCredential.getSmsCode();
            if (code != null){
                progressBar.setVisibility(View.VISIBLE);
                verifyCode(code);
            }
        }

        @Override
        public void onVerificationFailed(FirebaseException e) {
            Toast.makeText(otpActictiy.this, e.getMessage(),Toast.LENGTH_LONG).show();

        }
    };
    public void addphone(){
        if(!tv1.getText().toString().isEmpty()){
            documentReference=objectFirebaseFirestore.collection("Users").document(tv1.getText().toString());
            Map<String,Object> objectMap =new HashMap<>();
            objectMap.put("Phone",tv2.getText().toString());
            documentReference.update(objectMap)
            .addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    Intent intent = new Intent(otpActictiy.this, HomeActivity2.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    Toast.makeText(otpActictiy.this, "Your phone no. is Verified Successfully", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(otpActictiy.this, "Failed to Verify ", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}

