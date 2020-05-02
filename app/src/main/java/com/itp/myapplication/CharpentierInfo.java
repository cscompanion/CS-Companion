package com.itp.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CharpentierInfo extends AppCompatActivity {
private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charpentier_info);
        button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openClientsPage();
            }
        });
        button = (Button) findViewById(R.id.button5);
        button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFirstPage();
            }
        });

    }
    public void openClientsPage() {
        Intent intent = new Intent(this, ClientsPage.class);
        startActivity(intent);
    }



    public void openFirstPage () {
        Intent intent = new Intent(this, FirstPage.class);
        startActivity(intent);





    }
    }
