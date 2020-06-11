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

import com.example.work_at_home.Language;
import com.example.work_at_home.Language_Guest;
import com.example.work_at_home.Log_in;
import com.example.work_at_home.Login;
import com.example.work_at_home.Main2Activity;
import com.example.work_at_home.MyInterset;
import com.example.work_at_home.R;
import com.example.work_at_home.Search_view_page;
import com.example.work_at_home.Settings;
import com.example.work_at_home.Sign_up;
import com.example.work_at_home.Support;
import com.example.work_at_home.guest_login;
import com.example.work_at_home.guest_member;
import com.example.work_at_home.privacy2;
import com.example.work_at_home.term2;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link guest_account#newInstance} factory method to
 * create an instance of this fragment.
 */
public class guest_account extends Fragment {
private RelativeLayout real,rg,real2,real4vv,real4,real4v,real1;
private TextView tvv2vv;
private View objview;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public guest_account() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment guest_account.
     */
    // TODO: Rename and change types and number of parameters
    public static guest_account newInstance(String param1, String param2) {
        guest_account fragment = new guest_account();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    public void initial() {
        real = objview.findViewById(R.id.real);
        rg = objview.findViewById(R.id.rg);
        real2=objview.findViewById(R.id.real2);
        real1=objview.findViewById(R.id.real1);
        real4vv=objview.findViewById(R.id.real4vv);
        real4v=objview.findViewById(R.id.real4v);
        real4=objview.findViewById(R.id.real4);
       real1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               int yourInt = 121;
               Intent myIntent = new Intent(getActivity().getApplicationContext(), MyInterset.class);
               myIntent.putExtra("yourIntName", yourInt);
               startActivity(myIntent); }



       });


        real4vv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getActivity().getApplicationContext(), Support.class);
                startActivity(myIntent); }

        });
        real4v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getActivity().getApplicationContext(), term2.class);
                startActivity(myIntent); }

        });
        real4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getActivity().getApplicationContext(), privacy2.class);
                startActivity(myIntent); }

        });


        real2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getActivity().getApplicationContext(), Language_Guest.class);
                startActivity(myIntent); }



        });


        real.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int yourInt = 500;
                Intent myIntent = new Intent(getActivity().getApplicationContext(), guest_member.class);
                myIntent.putExtra("yourIntName", yourInt);
                startActivity(myIntent); }



        });

        rg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(getActivity().getApplicationContext(), guest_login.class);
                startActivity(myIntent); }

        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        objview= inflater.inflate(R.layout.fragment_guest_account, container, false);
    initial();
        return objview;
    }
}