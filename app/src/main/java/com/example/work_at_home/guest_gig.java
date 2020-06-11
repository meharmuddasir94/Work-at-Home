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
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class guest_gig extends AppCompatActivity {
    RelativeLayout rl;
    RecyclerView objectrecyclerView;
    FirebaseFirestore objectFirebaseFirestore;
    FbAdapter3 objectFbAdapter3;
    TextView tvd,title;

    FirebaseAuth mAuth;
    String s;

    DocumentReference documentReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_gig);
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


            objectFbAdapter3 = new FbAdapter3(objectoptions,this);
            objectrecyclerView.setAdapter(objectFbAdapter3);
            objectrecyclerView.setLayoutManager(new LinearLayoutManager(this));

        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        objectFbAdapter3.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        objectFbAdapter3.stopListening();
    }

    public void back(View view) {
        Intent i = new Intent(guest_gig.this,Guest_Home.class);
        startActivity(i);
        Animatoo.animateSlideRight(this);
    }

    @Override
    public void onBackPressed() {

        Intent i = new Intent(guest_gig.this,Guest_Home.class);
        startActivity(i);
        Animatoo.animateSlideRight(this);
    }
}