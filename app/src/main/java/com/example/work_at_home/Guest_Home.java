package com.example.work_at_home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.work_at_home.Fragments.AccountFragments;
import com.example.work_at_home.Fragments.BlankFragment;
import com.example.work_at_home.Fragments.Guest_homefragment;
import com.example.work_at_home.Fragments.HomeFragment;
import com.example.work_at_home.Fragments.MessageFragment;
import com.example.work_at_home.Fragments.NotificationFragment;
import com.example.work_at_home.Fragments.SearchFragment;
import com.example.work_at_home.Fragments.guest_account;
import com.example.work_at_home.Fragments.guest_search;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Guest_Home extends AppCompatActivity {
        BottomNavigationView bottomNavigationView;
        Guest_homefragment objecthomeFragment;
        MessageFragment objectmessageFragment;
        NotificationFragment objectnotificationFragment;
        guest_search objectsearchFragment;
        guest_account objguest;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_guest__home);

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
                           movetologg();
                            return true;
                        case R.id.item_notif:
                            movetologg();
                            return true;
                        case R.id.item_searchss:
                            replacefragments(objectsearchFragment);
                            return true;
                        case R.id.item_account:
                            replacefragments(objguest);
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
        private void movetologg(){
            startActivity(new Intent(Guest_Home.this, guest_member.class));
            Animatoo.animateSlideUp(this);
        }

        private void initializeobjects() {
            try {
                bottomNavigationView = findViewById(R.id.BNV1);
                objecthomeFragment = new Guest_homefragment();
                objectmessageFragment = new MessageFragment();
                objguest = new guest_account();
                objectnotificationFragment = new NotificationFragment();
                objectsearchFragment = new guest_search();
            } catch (Exception e) {
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }
    }


