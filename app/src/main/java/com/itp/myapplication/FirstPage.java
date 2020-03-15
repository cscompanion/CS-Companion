package com.itp.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class FirstPage extends AppCompatActivity {
    TextView titlepage, endpage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);

        titlepage = findViewById(R.id.titlepage);
        endpage = findViewById(R.id.endpage);
    }
}
