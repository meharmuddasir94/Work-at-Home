package com.example.work_at_home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Post_A_Request extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spinner, spinner2;
    String cate, del;
    EditText editdes, budgt;
    FirebaseFirestore objectFirebaseFirestore;
TextView tv;
    FirebaseUser user;
    DatabaseReference reference;
    ProgressDialog progressDialog;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post__a__request);
        spinner = findViewById(R.id.spinners);
        spinner2 = findViewById(R.id.spinners2);
        editdes = findViewById(R.id.editdes);
        firebaseAuth = FirebaseAuth.getInstance();
        objectFirebaseFirestore = FirebaseFirestore.getInstance();
tv=findViewById(R.id.tvemailss);
        budgt = findViewById(R.id.budgt);
        spin11();
        spin12();
        user=FirebaseAuth.getInstance().getCurrentUser();
        reference= FirebaseDatabase.getInstance().getReference("Users").child(user.getUid());
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                User user = dataSnapshot.getValue(User.class);
                tv.setText(user.getName());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    public void spin12() {
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this,
                R.array.Days_arrays, android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(arrayAdapter);
        spinner2.setOnItemSelectedListener(this);

    }

    public void spin11() {
        ArrayAdapter<CharSequence> arrayAdapter1 = ArrayAdapter.createFromResource(this,
                R.array.Categories, android.R.layout.simple_spinner_item);
        arrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter1);
        spinner.setOnItemSelectedListener(this);

    }

    public void posttodb(View view) {
        del = spinner.getSelectedItem().toString();
        try {
            if (!editdes.getText().toString().isEmpty() && !budgt.getText().toString().isEmpty()) {
                Map<String, String> objectMap = new HashMap<>();
                objectMap.put("Description", editdes.getText().toString());
                objectMap.put("Time", spinner2.getSelectedItem().toString());
                objectMap.put("Budget", budgt.getText().toString());
                objectMap.put("Email", spinner.getSelectedItem().toString());

                objectFirebaseFirestore.collection(del)
                        .document(tv.getText().toString())
                        .set(objectMap)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(Post_A_Request.this, "Request is Posted Successfully", Toast.LENGTH_SHORT).show();
                                Intent myIntent = new Intent(getBaseContext(), HomeActivity2.class);
                                posttmanage();
                                startActivity(myIntent);


                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(Post_A_Request.this, "Failed to post", Toast.LENGTH_SHORT).show();
                            }
                        });

            } else {
                Toast.makeText(Post_A_Request.this, "Enter Values", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            Toast.makeText(Post_A_Request.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void posttmanage() {
        del = spinner.getSelectedItem().toString();
        try {

            if (!editdes.getText().toString().isEmpty()) {
                Map<String, String> objectMap = new HashMap<>();
                objectMap.put("Email",tv.getText().toString());
                objectMap.put("Description", editdes.getText().toString());
                objectMap.put("Time", spinner2.getSelectedItem().toString());
                objectMap.put("Budget", budgt.getText().toString());
                objectMap.put("Category",spinner.getSelectedItem().toString());

                objectFirebaseFirestore.collection("ManagingReq")
                        .document(tv.getText().toString())
                        .set(objectMap)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Intent myIntent = new Intent(getBaseContext(), HomeActivity2.class);
                                startActivity(myIntent);


                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(Post_A_Request.this, "Failed to post", Toast.LENGTH_SHORT).show();
                            }
                        });

            } else {
                Toast.makeText(Post_A_Request.this, "Enter Values", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            Toast.makeText(Post_A_Request.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }







    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


        cate = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}


