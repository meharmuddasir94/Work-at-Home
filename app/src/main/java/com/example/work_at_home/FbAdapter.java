package com.example.work_at_home;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

import java.util.ArrayList;

public class FbAdapter extends FirestoreRecyclerAdapter<ModelClass, FbAdapter.FbViewHolder> {
Context context;
    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public FbAdapter(@NonNull FirestoreRecyclerOptions<ModelClass> options ,Context context) {
        super(options);
        this.context=context;
    }

    @Override
    protected void onBindViewHolder(@NonNull final FbViewHolder fbViewHolder, int i, @NonNull final ModelClass modelClass) {
        final String userName=getSnapshots().getSnapshot(i).getId();
        fbViewHolder.usTV.setText(modelClass.getDescription());
        fbViewHolder.blTV.setText(modelClass.getTime());
        fbViewHolder.ciTV.setText(modelClass.getBudget());
        fbViewHolder.coTV.setText(userName);
        fbViewHolder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,gig_open.class);
                intent.putExtra("userdes",modelClass.getDescription());
                intent.putExtra("usertime",modelClass.getTime());
                intent.putExtra("userbudget",modelClass.getBudget());
                intent.putExtra("usercat",modelClass.getCategory());
                intent.putExtra("usernam",userName);
                context.startActivity(intent);
            }
        });

    }

    @NonNull
    @Override
    public FbViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FbViewHolder(LayoutInflater.from(context)
                .inflate(R.layout.featured_gis,parent,false));

    }

    public class FbViewHolder extends RecyclerView.ViewHolder {
        TextView usTV, blTV, ciTV, coTV;
View view;
        public FbViewHolder(@NonNull View singleRow) {
            super(singleRow);
            usTV = singleRow.findViewById(R.id.des2);
            blTV = singleRow.findViewById(R.id.days2);
            ciTV = singleRow.findViewById(R.id.budget2);
            coTV = singleRow.findViewById(R.id.caateg2);
            view=singleRow;

        }


    }
}

