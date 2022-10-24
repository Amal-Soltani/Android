package com.example.mycourses;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ListActivity extends AppCompatActivity {

    ImageView logout;
    RecyclerView recyclerView;
    FloatingActionButton fb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        logout = findViewById(R.id.icSignOut);
        logout.setOnClickListener(e->{
                startActivity(new Intent(ListActivity.this, LoginActivity.class));
            }
        );


        fb = (FloatingActionButton)findViewById(R.id.fadd);
        fb.setOnClickListener(e->{
                startActivity(new Intent(getApplicationContext(), AddActivity.class));
        });
    }
}