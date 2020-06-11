package com.example.work_at_home;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class FbAdapter1 extends FirestoreRecyclerAdapter<ModelClass1, FbAdapter1.FbViewHolder1> {
    Context context;
    public FbAdapter1(@NonNull FirestoreRecyclerOptions<ModelClass1> options, Context context) {
        super(options);
        this.context=context;
    }

    @Override
    protected void onBindViewHolder(@NonNull FbViewHolder1 fbViewHolder1, int i, @NonNull final ModelClass1 modelClass1) {
        final String userName=getSnapshots().getSnapshot(i).getId();
        fbViewHolder1.usTV.setText(modelClass1.getDescription());
        fbViewHolder1.spTV.setText(modelClass1.getBudget());
        fbViewHolder1.ciTV.setText(modelClass1.getEmail());
        fbViewHolder1.coTV.setText(modelClass1.getTime());
        fbViewHolder1.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String f ="Ahmed";
                Intent intent = new Intent(context,gig_open.class);
                intent.putExtra("userdes",modelClass1.getDescription());
                intent.putExtra("usertime",modelClass1.getTime());
                intent.putExtra("userbudget",modelClass1.getBudget());
                intent.putExtra("usercat",modelClass1.getEmail());
                intent.putExtra("usernam",userName);
                context.startActivity(intent);
            }
        });

    }

    @NonNull
    @Override
    public FbViewHolder1 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FbViewHolder1(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.singlecategory_row,parent,false));
    }
    public class FbViewHolder1 extends RecyclerView.ViewHolder{
        TextView usTV, spTV, ciTV, coTV;
        View view;

        public FbViewHolder1(@NonNull View itemView) {
            super(itemView);
            usTV=itemView.findViewById(R.id.devgig);
            spTV=itemView.findViewById(R.id.budget3);
            ciTV=itemView.findViewById(R.id.day4);
            coTV=itemView.findViewById(R.id.email4);
            view=itemView;
        }
    }
}