package com.example.work_at_home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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

public class MassageActivity extends AppCompatActivity {
TextView emailtv;
    FirebaseAuth auth;
    FirebaseFirestore objectFirebaseFirestore;
EditText ico;
ImageView send;
MessageAdapter messageAdapter;
List<Chat> mchat;
ModelClass1 modelClass1;
FirebaseUser fuser;
RecyclerView recyclerView;
    String r;
DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_massage);
       r = getIntent().getStringExtra("email");
        emailtv=findViewById(R.id.tv);
        emailtv.setText(r);
        ico=findViewById(R.id.ico);
        recyclerView=findViewById(R.id.rec);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        send=findViewById(R.id.send);
        auth =FirebaseAuth.getInstance();
        objectFirebaseFirestore = FirebaseFirestore.getInstance();
        String real=getIntent().getStringExtra("email");

        fuser = auth.getCurrentUser();
        final String userds=auth.getUid();
        reference=FirebaseDatabase.getInstance().getReference("Users").child(r);
reference.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        User user = dataSnapshot.getValue(User.class);
        readMesagges(fuser.getUid(),r);

    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }
});
    send.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String msg=ico.getText().toString();
            if(!msg.equals("")){
                sendMessage(fuser.getUid(),r,msg);
            }else {
                Toast.makeText(MassageActivity.this, "You can't send Empty msg ", Toast.LENGTH_SHORT).show();
            }
            ico.setText("");
        }
    });

    }
    private void sendMessage(String sender,String receviver,String message){
        HashMap<String,Object>hashMap=new HashMap<>();
        hashMap.put("sender",sender);
        hashMap.put("receviver",receviver);
        hashMap.put("message",message);
        reference.child("Chats").push().setValue(hashMap);

    }
    private void readMesagges(final String myid, final String userid){
        mchat = new ArrayList<>();

        reference = FirebaseDatabase.getInstance().getReference("Chats");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                mchat.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    Chat chat = snapshot.getValue(Chat.class);
                    if (chat.getReceviver()==myid && chat.getSender()==userid ||
                            chat.getReceviver()==userid && chat.getSender()==myid){
                        mchat.add(chat);
                    }

                    messageAdapter = new MessageAdapter(MassageActivity.this, mchat);
                    recyclerView.setAdapter(messageAdapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void currentUser(String userid){
        SharedPreferences.Editor editor = getSharedPreferences("PREFS", MODE_PRIVATE).edit();
        editor.putString("currentuser", userid);
        editor.apply();
    }

}