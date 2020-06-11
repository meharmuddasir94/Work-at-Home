package com.example.work_at_home.Fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.work_at_home.ManageOrder;
import com.example.work_at_home.ManagingRequest;
import com.example.work_at_home.MyInterset;
import com.example.work_at_home.Payment;
import com.example.work_at_home.Post_A_Request;
import com.example.work_at_home.R;
import com.example.work_at_home.Settings;
import com.example.work_at_home.sport;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 */
public class AccountFragments extends Fragment {
private ImageView il;
private FirebaseAuth auth;
private RelativeLayout real2,reall2,real3,real1,reall3,real,inter,reall1;
private FirebaseUser user ;
private TextView tv1;
private View objaccountfragment;

    public AccountFragments() {
        // Required empty public constructor
    }
    private void initializationVariable() {
        auth=FirebaseAuth.getInstance();
        tv1=objaccountfragment.findViewById(R.id.tv1us);
        real2=objaccountfragment.findViewById(R.id.real2);
        reall2=objaccountfragment.findViewById(R.id.reall2);
        reall3=objaccountfragment.findViewById(R.id.reall3);
        inter=objaccountfragment.findViewById(R.id.inter);
        reall1=objaccountfragment.findViewById(R.id.reall1);
        reall1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity().getApplicationContext(), Payment.class));

            }
        });
        real=objaccountfragment.findViewById(R.id.real);
        real.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity().getApplicationContext(), MyInterset.class));

            }
        });
        inter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity().getApplicationContext(), MyInterset.class));

            }
        });
        reall3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity().getApplicationContext(), sport.class));
            }
        });
        real3=objaccountfragment.findViewById(R.id.real3);
        real1=objaccountfragment.findViewById(R.id.real1);
        real1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity().getApplicationContext(), ManageOrder.class));

            }
        });
        real3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity().getApplicationContext(), ManagingRequest.class));

            }
        });

        reall2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                String shareBody ="Work At Home";
                String sharesub="Hey ! I am using this using";
                intent.putExtra(Intent.EXTRA_SUBJECT,shareBody);
                intent.putExtra(Intent.EXTRA_TEXT,sharesub);
                startActivity(Intent.createChooser(intent,"Share Using"));
            }
        });
        real2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity().getApplicationContext(), Post_A_Request.class));
            }
        });
        if(auth != null){
            String i =auth.getCurrentUser().getEmail();
            tv1.setText(i);
        }else {
            String j =auth.getCurrentUser().getDisplayName();
       tv1.setText(j); }
    il=objaccountfragment.findViewById(R.id.settingss);
    il.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(getActivity().getApplicationContext(), Settings.class));

        }
    });
    }

        @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        objaccountfragment= inflater.inflate(R.layout.fragment_account_fragments, container, false);
   initializationVariable();
        return objaccountfragment;

    }

}
