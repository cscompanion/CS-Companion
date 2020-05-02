package com.itp.myapplication;


import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;

import android.widget.EditText;
import android.widget.ListView;


import androidx.annotation.NonNull;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.itp.myapplication.databinding.ActivityFirstPageBinding;

import java.util.ArrayList;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class FirstPage extends AppCompatActivity implements View.OnClickListener {
    private FirebaseAuth mAuth;
    private ActivityFirstPageBinding mBinding;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);
        mBinding = ActivityFirstPageBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        mBinding.signOutButton.setOnClickListener((View.OnClickListener) this);



    }


    private void signOut() {
        mAuth.signOut();
        updateUI(null);
        startActivity(new Intent(this, EmailPasswordActivity.class));
    }

    private void updateUI(FirebaseUser user) {
    }

    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.signOutButton) {
            signOut();
        }
    }
    private void openEmailPasswordActivity()
    {
        Intent intent = new Intent(this, EmailPasswordActivity.class);
        startActivity(intent);
    }
}
