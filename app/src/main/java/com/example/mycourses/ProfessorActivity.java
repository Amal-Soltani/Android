package com.example.mycourses;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import android.widget.ImageView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

public class ProfessorActivity extends AppCompatActivity {

    DrawerLayout drawerlayout;
    ImageView menu;
    NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        drawerlayout = findViewById(R.id.drawerlayout);
        menu = findViewById(R.id.imageMenu);
        menu.setOnClickListener(e->{
            drawerlayout.openDrawer(GravityCompat.START);
        });

        navigationView = findViewById(R.id.navigationView);
        NavController navController = Navigation.findNavController(this,R.id.navHostFragment);
        NavigationUI.setupWithNavController(navigationView,navController);

    }
}