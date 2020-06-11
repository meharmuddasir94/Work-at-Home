package com.example.work_at_home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.work_at_home.Fragments.AccountFragments;
import com.example.work_at_home.Fragments.HomeFragment;
import com.example.work_at_home.Fragments.MessageFragment;
import com.example.work_at_home.Fragments.NotificationFragment;
import com.example.work_at_home.Fragments.SearchFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class HomeActivity extends AppCompatActivity {
BottomNavigationView bottomNavigationView;
HomeFragment objecthomeFragment;
MessageFragment objectmessageFragment;
NotificationFragment objectnotificationFragment;
SearchFragment objectsearchFragment;
AccountFragments objectaccountFragmnet;
FirebaseAuth auth;
RelativeLayout rl;

    int score;
    TextView text;
    FirebaseFirestore objectFirebaseFirestore;
    FirebaseUser user;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        text=findViewById(R.id.tvemail);
        auth =FirebaseAuth.getInstance();
        objectFirebaseFirestore = FirebaseFirestore.getInstance();

        rl=findViewById(R.id.contan);
        initializeobjects();
        realtimeuserdb();
        replacefragments(objecthomeFragment);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.item_home:
                        replacefragments(objecthomeFragment);
                        return true;
                    case R.id.item_mess:
                        replacefragments(objectmessageFragment);
                        return true;
                    case R.id.item_notif:
                        replacefragments(objectnotificationFragment);
                        return true;
                    case R.id.item_searchss:
                        replacefragments(objectsearchFragment);

                        return true;
                    case R.id.item_account:
                        replacefragments(objectaccountFragmnet);
                        return true;
                        default:
                            return false;

                }
            }
        });
    }
    private void replacefragments(Fragment fragment){
        rl.removeAllViews();
        try{

            FragmentTransaction objectfragmentTransaction=getSupportFragmentManager().beginTransaction();
            objectfragmentTransaction.replace(R.id.contan,fragment).commit();

        }catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();

        }
    }


    private void initializeobjects() {
        try {
            bottomNavigationView=findViewById(R.id.BNV1);
            objecthomeFragment=new HomeFragment();
            objectmessageFragment= new MessageFragment();
            objectaccountFragmnet=new AccountFragments();
            objectnotificationFragment = new NotificationFragment();
            objectsearchFragment= new SearchFragment();
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        }

    public void  realtimeuserdb(){

        final FirebaseUser user = auth.getCurrentUser();
        final String named = getIntent().getStringExtra("username");
         String emails =auth.getCurrentUser().getEmail();
        text.setText(emails);
        String name = text.getText().toString();
        FirebaseUser userd =auth.getCurrentUser();
        String userds=userd.getUid();
        reference= FirebaseDatabase.getInstance().getReference("Users").child(userds);
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("id",userds);
        hashMap.put("username",name);
        hashMap.put("name",named);
        reference.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){

                    Toast.makeText(HomeActivity.this, "Automatically Logged In...", Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(HomeActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

