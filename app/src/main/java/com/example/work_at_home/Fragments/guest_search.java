package com.example.work_at_home.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.work_at_home.R;
import com.example.work_at_home.categoriesss;
import com.example.work_at_home.guestproblem;
import com.example.work_at_home.ui.main.SectionsPagerAdapter1;
import com.google.android.material.tabs.TabLayout;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link guest_search#newInstance} factory method to
 * create an instance of this fragment.
 */
public class guest_search extends Fragment {
    private View objview;
    private ImageView iv;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public guest_search() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment guest_search.
     */
    // TODO: Rename and change types and number of parameters
    public static guest_search newInstance(String param1, String param2) {
        guest_search fragment = new guest_search();
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
    private void intal(){
        SectionsPagerAdapter1 sectionsPagerAdapter = new SectionsPagerAdapter1(getActivity().getApplicationContext(), getFragmentManager());
        ViewPager viewPager = objview.findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);

        TabLayout tabs = objview.findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        iv=objview.findViewById(R.id.iconsearch);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int yourInt = 40;
                Intent myIntent = new Intent(getActivity().getApplicationContext(), guestproblem.class);
                myIntent.putExtra("yourIntName", yourInt);
                startActivity(myIntent);    }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        objview= inflater.inflate(R.layout.fragment_guest_search, container, false);
       intal();
        return objview;
    }
}