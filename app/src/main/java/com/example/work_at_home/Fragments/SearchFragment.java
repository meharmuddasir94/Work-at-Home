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
import com.example.work_at_home.ui.main.SectionsPagerAdapter;
import com.example.work_at_home.ui.main.SectionsPagerAdapter1;
import com.google.android.material.tabs.TabLayout;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment {
private View objview;
private ImageView iv;


    public SearchFragment() {
        // Required empty public constructor
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
        int yourInt = 30;
        Intent myIntent = new Intent(getActivity().getApplicationContext(), categoriesss.class);
        myIntent.putExtra("yourIntName", yourInt);
        startActivity(myIntent);    }
});
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        objview= inflater.inflate(R.layout.fragment_search, container, false);
    intal();
    return  objview;
    }

}
