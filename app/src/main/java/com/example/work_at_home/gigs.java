package com.example.work_at_home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class gigs extends AppCompatActivity {
    RelativeLayout rl;
    RecyclerView objectrecyclerView;
    FirebaseFirestore objectFirebaseFirestore;
    FbAdapter1 objectFbAdapter1;
    TextView tvd,title;
    DatabaseReference reference;
    FirebaseAuth mAuth;
    String s;

    DocumentReference documentReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gigs);
        mAuth = FirebaseAuth.getInstance();
        tvd = findViewById(R.id.tvfs);
        Intent intent =getIntent();
        s=intent.getStringExtra("full");
        tvd.setText(s);
        title=findViewById(R.id.etg);
        title.setText(s);

        objectrecyclerView = findViewById(R.id.rec);
        objectFirebaseFirestore = FirebaseFirestore.getInstance();
        addstatusToRV();


    }

    private void addstatusToRV() {
        try {

            Query objectQuery = objectFirebaseFirestore.collection(tvd.getText().toString());
            FirestoreRecyclerOptions<ModelClass1> objectoptions
                    = new FirestoreRecyclerOptions.Builder<ModelClass1>()
                    .setQuery(objectQuery, ModelClass1.class)
                    .build();


            objectFbAdapter1 = new FbAdapter1(objectoptions,this);
            objectrecyclerView.setAdapter(objectFbAdapter1);
            objectrecyclerView.setLayoutManager(new LinearLayoutManager(this));

        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        objectFbAdapter1.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        objectFbAdapter1.stopListening();
    }

    public void back(View view) {
        onBackPressed();
    }
}