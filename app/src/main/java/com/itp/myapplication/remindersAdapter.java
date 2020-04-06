package com.itp.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class remindersAdapter extends RecyclerView.Adapter<remindersAdapter.MyViewHolder> {

    Context context;
    ArrayList<remindersAdapter> remindersDatabase;

    public remindersAdapter(Context c, ArrayList<remindersAdapter> p){    {
        context = c;
        remindersDatabase = p;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_reminder,viewType, attach false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            MyViewHolder.rCategory.setText(remindersDatabase.get(i).getrCategory());
            MyViewHolder.rDescription.setText(remindersDatabase.get(i).getrDescription());
            MyViewHolder.rUrgency.setText(remindersDatabase.get(i).getrUrgency());
            MyViewHolder.id.setText(remindersDatabase.get(i).getid());
            MyViewHolder.rDateDue.setText(remindersDatabase.get(i).getrDateDue());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView rCategory, rDescription, rUrgency, id, rDateDue;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            rCategory = (TextView) itemView.findViewById(R.id.rCategory);
            rDescription = (TextView) itemView.findViewById(R.id.rDescription);
            rUrgency = (TextView) itemView.findViewById(R.id.rUrgency);
            id = (TextView) itemView.findViewById(R.id.id);
            rDateDue = (TextView) itemView.findViewById(R.id.rDateDue);


        }
    }
}
