package com.itp.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CharpentierLeon extends AppCompatActivity {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_leon);

        button = (Button) findViewById(R.id.buttonClients);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewClients();
            }
        });
        button = (Button) findViewById(R.id.buttonMarkets);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMarkets();
            }
        });
        button = (Button) findViewById(R.id.buttonNews);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNews();
            }
        });
        button = (Button) findViewById(R.id.buttonHome);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHome();
            }
        });
        button = (Button) findViewById(R.id.button23);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTrans();
            }
        });
        button = (Button) findViewById(R.id.button55);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openpm();
            }
        });
        button = (Button) findViewById(R.id.button56);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openkyc();
            }
        });
    }
    public void openpm() {
//        Intent intent = new Intent(this, CLPortfolioMaster.class);
//        startActivity(intent);
    }
    public void openkyc() {
//        Intent intent = new Intent(this, CharpentierInfo.class);
//        startActivity(intent);
    }
    public void openTrans() {
//        Intent intent = new Intent(this, CLClientTrans.class);
//        startActivity(intent);
    }
    public void openNewClients() {
//        Intent intent = new Intent(this, NewClients.class);
//        startActivity(intent);
    }
    public void openHome() {
//        Intent intent = new Intent(this, client.class);
//        startActivity(intent);
    }
    public void openMarkets() {
//        Intent intent = new Intent(this, MarketsStocks.class);
//        startActivity(intent);
    }
    public void openNews() {
//        Intent intent = new Intent(this, News.class);
//        startActivity(intent);
    }
}

