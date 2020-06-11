package com.example.work_at_home.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.work_at_home.FbAdapter;
import com.example.work_at_home.FbAdapter4;
import com.example.work_at_home.ModelClass;
import com.example.work_at_home.R;
import com.example.work_at_home.Search_view_page;
import com.example.work_at_home.categoriesss;
import com.example.work_at_home.guest_gig;
import com.example.work_at_home.guestproblem;
import com.example.work_at_home.guestproblem2;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Guest_homefragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Guest_homefragment extends Fragment {
    private RelativeLayout rl;
    private LinearLayout l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,lv11,lv12,lv13,lv14,lv15,lv16,lv17,lv18,lv19,lv20;
    private RecyclerView recs;
    private TextView tv,l1tv;
    private ImageView v1;
    private List<ModelClass> list;
    private RecyclerView objectrecyclerView;
    private FirebaseFirestore objectFirebaseFirestore;
    private FbAdapter4 objectFbAdapter;

    DatabaseReference reference;
    FirebaseAuth mAuth;

    DocumentReference documentReference;

    private View objviewhome;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Guest_homefragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Guest_homefragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Guest_homefragment newInstance(String param1, String param2) {
        Guest_homefragment fragment = new Guest_homefragment();
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
    private void initializationVariable() {
        v1 = objviewhome.findViewById(R.id.categ);
        rl = objviewhome.findViewById(R.id.rl4);
        tv = objviewhome.findViewById(R.id.search);
        l1 = objviewhome.findViewById(R.id.logocat);
        l3 = objviewhome.findViewById(R.id.l3);
        l4 = objviewhome.findViewById(R.id.l4);
        l5 = objviewhome.findViewById(R.id.l5);
        l6 = objviewhome.findViewById(R.id.l6);
        l7 = objviewhome.findViewById(R.id.l7);
        l8 = objviewhome.findViewById(R.id.l8);
        l9 = objviewhome.findViewById(R.id.l9);
        l10 = objviewhome.findViewById(R.id.l10);
        lv11 = objviewhome.findViewById(R.id.lv11);
        lv12 = objviewhome.findViewById(R.id.lv12);
        lv13 = objviewhome.findViewById(R.id.lv13);
        lv14 = objviewhome.findViewById(R.id.lv14);
        lv15 = objviewhome.findViewById(R.id.lv15);
        lv16 = objviewhome.findViewById(R.id.lv16);
        lv17 = objviewhome.findViewById(R.id.lv17);
        lv18 = objviewhome.findViewById(R.id.lv18);
        lv19 = objviewhome.findViewById(R.id.lv19);
        lv20 = objviewhome.findViewById(R.id.lv20);
        l3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity().getApplicationContext(), guest_gig.class);
                intent.putExtra("full", getString(R.string.busc));
                startActivity(intent);
            }
        });
        l4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity().getApplicationContext(), guest_gig.class);
                intent.putExtra("full", getString(R.string.traf));
                startActivity(intent);
            }
        });
        l5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity().getApplicationContext(), guest_gig.class);
                intent.putExtra("full", getString(R.string.soc));
                startActivity(intent);
            }
        });
        l6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(), guest_gig.class);
                intent.putExtra("full", getString(R.string.tshir));
                startActivity(intent);
            }
        });
        l7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity().getApplicationContext(), guest_gig.class);
                intent.putExtra("full", getString(R.string.voice));
                startActivity(intent);
            }
        });
        l8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity().getApplicationContext(), guest_gig.class);
                intent.putExtra("full", getString(R.string.seo));
                startActivity(intent);
            }
        });
        l9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity().getApplicationContext(), guest_gig.class);
                intent.putExtra("full", getString(R.string.photo));
                startActivity(intent);
            }
        });
        l10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity().getApplicationContext(), guest_gig.class);
                intent.putExtra("full", getString(R.string.artic));
                startActivity(intent);
            }
        });

        lv11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity().getApplicationContext(), guest_gig.class);
                intent.putExtra("full", getString(R.string.word));
                startActivity(intent);
            }
        });
        lv12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity().getApplicationContext(), guest_gig.class);
                intent.putExtra("full", getString(R.string.ill));
                startActivity(intent);
            }
        });
        lv13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity().getApplicationContext(), guest_gig.class);
                intent.putExtra("full", getString(R.string.mob));
                startActivity(intent);
            }
        });
        lv14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity().getApplicationContext(), guest_gig.class);
                intent.putExtra("full", getString(R.string.cra));
                startActivity(intent);
            }
        });
        lv15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity().getApplicationContext(), guest_gig.class);
                intent.putExtra("full", getString(R.string.websd));
                startActivity(intent);
            }
        });
        lv16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity().getApplicationContext(), guest_gig.class);
                intent.putExtra("full", getString(R.string.inte));
                startActivity(intent);
            }
        });
        lv17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity().getApplicationContext(), guest_gig.class);
                intent.putExtra("full", getString(R.string.res));
                startActivity(intent);
            }
        });
        lv18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity().getApplicationContext(), guest_gig.class);
                intent.putExtra("full", getString(R.string.vid));
                startActivity(intent);
            }
        });
        lv19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity().getApplicationContext(), guest_gig.class);
                intent.putExtra("full", getString(R.string.mus));
                startActivity(intent);
            }
        });
        lv20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity().getApplicationContext(), guest_gig.class);
                intent.putExtra("full", getString(R.string.other));
                startActivity(intent);
            }
        });


        l1tv = objviewhome.findViewById(R.id.logocattv);

        l2 = objviewhome.findViewById(R.id.l2);

        l2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity().getApplicationContext(), guest_gig.class);
                intent.putExtra("full", getString(R.string.logoA));
                startActivity(intent);
            }
        });
        l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = l1tv.getText().toString();
                Intent intent = new Intent(getActivity().getApplicationContext(), guest_gig.class);
                intent.putExtra("full", getString(R.string.logod));
                startActivity(intent);
            }
        });
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int yourInt = 200;
                Intent myIntent = new Intent(getActivity().getApplicationContext(), guestproblem.class);
                myIntent.putExtra("yourIntName", yourInt);
                startActivity(myIntent);
            }
        });
        rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int yourInt = 200;
                Intent myIntent = new Intent(getActivity().getApplicationContext(), guestproblem.class);
                myIntent.putExtra("yourIntName", yourInt);
                startActivity(myIntent);
            }
        });
        v1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int yourInt = 150;
                Intent myIntent = new Intent(getActivity().getApplicationContext(), guestproblem2.class);
                myIntent.putExtra("yourIntName", yourInt);
                startActivity(myIntent);
            }
        });
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        objviewhome= inflater.inflate(R.layout.fragment_guest_homefragment, container, false);
initializationVariable();
        mAuth= FirebaseAuth.getInstance();
        objectrecyclerView=objviewhome.findViewById(R.id.rec);
        objectFirebaseFirestore= FirebaseFirestore.getInstance();
        addstatusToRV();
        return objviewhome;
    }
    private void addstatusToRV(){
        try{

            Query objectQuery =objectFirebaseFirestore.collection("ManagingReq");
            FirestoreRecyclerOptions<ModelClass> objectoptions
                    = new FirestoreRecyclerOptions.Builder<ModelClass>()
                    .setQuery(objectQuery,ModelClass.class)
                    .build();


            objectFbAdapter=new FbAdapter4(objectoptions,getActivity().getApplicationContext());
            objectrecyclerView.setAdapter(objectFbAdapter);
            objectrecyclerView.setLayoutManager( new LinearLayoutManager(getActivity().getApplicationContext(),LinearLayoutManager.HORIZONTAL,true));


        }catch(Exception e){

        }

    }

    @Override
    public void onStart() {
        super.onStart();
        objectFbAdapter.startListening();

    }

    @Override
    public void onStop() {
        super.onStop();

        objectFbAdapter.stopListening();
    }
}
