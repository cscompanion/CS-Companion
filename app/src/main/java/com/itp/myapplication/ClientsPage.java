package com.itp.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ClientsPage extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clients_page);

        button = (Button) findViewById(R.id.button6);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openJuricJan();
            }
        });
        button = (Button) findViewById(R.id.button7);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTravers();
            }
        });
        button = (Button) findViewById(R.id.button10);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCharpentier();
            }
        });
        button = (Button) findViewById(R.id.button11);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDupuis();
            }
        });

        button = (Button) findViewById(R.id.button12);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSergeyova();
            }
        });

        button = (Button) findViewById(R.id.button13);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAleskeevich();
            }
        });
        button = (Button) findViewById(R.id.button4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewClients();
            }
        });
        button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMarkets();
            }
        });
        button = (Button) findViewById(R.id.button5);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLogin();
            }
        });
        button = (Button) findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHome();
            }
        });

    }
    public void openNewClients() {
        Intent intent = new Intent(this, NewClients.class);
        startActivity(intent);
    }

    public void openMarkets() {
        Intent intent = new Intent(this, MarketsStocks.class);
        startActivity(intent);
    }
    public void openLogin() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void openHome() {
        Intent intent = new Intent(this, client.class);
        startActivity(intent);
    }
    public void openTravers() {
        Intent intent = new Intent(this, TraversMillard.class);
        startActivity(intent);
    }
    public void openDupuis() {
        Intent intent = new Intent(this, DupuisLouis.class);
        startActivity(intent);
    }

    public void openJuricJan() {
        Intent intent = new Intent(this, JuricJan.class);
        startActivity(intent);}

    public void openCharpentier() {
        Intent intent = new Intent(this, CharpentierLeon.class);
        startActivity(intent);}

    public void openSergeyova() {
        Intent intent = new Intent(this, SergeyevaSelidova.class);
        startActivity(intent);}

    public void openAleskeevich() {
        Intent intent = new Intent(this, AleskeevichYagovkin.class);
        startActivity(intent);}

}



