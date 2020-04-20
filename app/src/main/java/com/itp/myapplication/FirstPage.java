package com.itp.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.core.Context;

import android.widget.TextView;
import java.util.ArrayList;

public class FirstPage extends AppCompatActivity {
    TextView titlepage, endpage;
    DatabaseReference reference;
    RecyclerView ourdoes;
    ArrayList<remindersDatabase> list;
    RemindersAdapter remindersAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);

        titlepage = findViewById(R.id.titlepage);
        endpage = findViewById(R.id.endpage);

        //working with data
        ourdoes = findViewById(R.id.ourdoes);
        ourdoes.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<remindersDatabase>();

        //get data from firebase
        reference = FirebaseDatabase.getInstance().getReference().child("Reminders");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //set code to retrive data and replace layout
                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    remindersDatabase p = dataSnapshot1.getValue(remindersDatabase.class);
                    list.add(p);
                }
                remindersAdapter = new RemindersAdapter(FirstPage.this, list);
                ourdoes.setAdapter(remindersAdapter);
                remindersAdapter.notifyDataSetChanged();


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // set code to show an error

                Toast.makeText(getApplicationContext(), "No Data", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
