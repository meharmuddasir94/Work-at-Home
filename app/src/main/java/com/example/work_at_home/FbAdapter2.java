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

public class FbAdapter2 extends FirestoreRecyclerAdapter<UserModelClass, FbAdapter2.FbViewHolder2> {
    Context context;
    public FbAdapter2(@NonNull FirestoreRecyclerOptions<UserModelClass> options, Context context) {
        super(options);
        this.context=context;
    }

    @Override
    protected void onBindViewHolder(@NonNull FbViewHolder2 fbViewHolder1, int i, @NonNull final UserModelClass UserClass) {
        final String userName=getSnapshots().getSnapshot(i).getId();
        fbViewHolder1.usTV.setText(UserClass.getName());
        fbViewHolder1.spTV.setText(UserClass.getEmail());
        fbViewHolder1.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,MassageActivity.class);
                intent.putExtra("username",UserClass.getName());
                context.startActivity(intent);
            }
        });

    }

    @NonNull
    @Override
    public FbViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FbViewHolder2(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_itemsdf,parent,false));
    }
    public class FbViewHolder2 extends RecyclerView.ViewHolder{
        TextView usTV, spTV;
        View view;

        public FbViewHolder2(@NonNull View itemView) {
            super(itemView);
            usTV=itemView.findViewById(R.id.tv);
            spTV=itemView.findViewById(R.id.tv1us);
            view=itemView;
        }
    }
}