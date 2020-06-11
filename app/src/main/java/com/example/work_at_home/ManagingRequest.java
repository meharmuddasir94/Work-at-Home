package com.example.work_at_home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.util.ArrayList;

public class ManagingRequest extends AppCompatActivity {
RelativeLayout rl;
    RecyclerView objectrecyclerView;
    FirebaseFirestore objectFirebaseFirestore;
    FbAdapter objectFbAdapter;

DatabaseReference reference;
    FirebaseAuth mAuth;

    DocumentReference documentReference;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_managing_request);
        mAuth=FirebaseAuth.getInstance();
        objectrecyclerView=findViewById(R.id.recyclerview);
        objectFirebaseFirestore=FirebaseFirestore.getInstance();
        addstatusToRV();


    }

    private void addstatusToRV(){
        try{

            Query objectQuery =objectFirebaseFirestore.collection("ManagingReq");
            FirestoreRecyclerOptions<ModelClass> objectoptions
                    = new FirestoreRecyclerOptions.Builder<ModelClass>()
                    .setQuery(objectQuery,ModelClass.class)
                    .build();


            objectFbAdapter=new FbAdapter(objectoptions,this);
            objectrecyclerView.setAdapter(objectFbAdapter);
            objectrecyclerView.setLayoutManager( new LinearLayoutManager(this));

        }catch(Exception e){
            Toast.makeText(this,e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }
    @Override
    protected void onStart() {
        super.onStart();
        objectFbAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        objectFbAdapter.stopListening();
    }


    public void movetopost(View view) {
        startActivity( new Intent(ManagingRequest.this, Post_A_Request.class));
        Animatoo.animateSplit(this);
    }

    public void back(View view) {
        onBackPressed();
    }
}