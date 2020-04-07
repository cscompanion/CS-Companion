package com.itp.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class RemindersAdapter extends RecyclerView.Adapter<RemindersAdapter.MyViewHolder> {

    Context context;
    ArrayList<remindersDatabase> remindersDatabase;

    public RemindersAdapter(Context c, ArrayList<remindersDatabase> p){
        context = c;
        remindersDatabase = p;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_reminder, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.rCategory.setText(remindersDatabase.get(i).getrCategory());
        myViewHolder.rDescription.setText(remindersDatabase.get(i).getrDescription());
        myViewHolder.rUrgency.setText(remindersDatabase.get(i).getrUrgency());
        myViewHolder.id.setText(remindersDatabase.get(i).getId());
        myViewHolder.rDateDue.setText((CharSequence) remindersDatabase.get(i).getrDateDue());

    }

    @Override
    public int getItemCount() {
        return remindersDatabase.size();
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
