package com.example.work_at_home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.work_at_home.Fragments.AccountFragments;
import com.example.work_at_home.Fragments.HomeFragment;
import com.example.work_at_home.Fragments.MessageFragment;
import com.example.work_at_home.Fragments.NotificationFragment;
import com.example.work_at_home.Fragments.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class HomeActivity2 extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    HomeFragment objecthomeFragment;
    MessageFragment objectmessageFragment;
    NotificationFragment objectnotificationFragment;
    SearchFragment objectsearchFragment;
    AccountFragments objectaccountFragmnet;
    FirebaseAuth auth;
    RelativeLayout rl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);


        rl = findViewById(R.id.contan);
        initializeobjects();

        replacefragments(objecthomeFragment);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
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

    private void replacefragments(Fragment fragment) {

        try {

            FragmentTransaction objectfragmentTransaction = getSupportFragmentManager().beginTransaction();
            objectfragmentTransaction.replace(R.id.contan, fragment).commit();

        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();

        }
    }


    private void initializeobjects() {
        try {
            bottomNavigationView = findViewById(R.id.BNV1);
            objecthomeFragment = new HomeFragment();
            objectmessageFragment = new MessageFragment();
            objectaccountFragmnet = new AccountFragments();
            objectnotificationFragment = new NotificationFragment();
            objectsearchFragment = new SearchFragment();
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}