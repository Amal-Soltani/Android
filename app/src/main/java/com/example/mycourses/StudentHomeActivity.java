package com.example.mycourses;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mycourses.Entity.Cours;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class StudentHomeActivity extends AppCompatActivity {

    List<Cours> cours;
    RecyclerView rv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_home);
        cours = new ArrayList();
        rv=findViewById(R.id.recyclerView);
        rv.setAdapter(new MyAdapter2(cours,this));
        rv.setLayoutManager(new LinearLayoutManager(this));

    }

    private void datainitializa() {

        cours = new ArrayList<>();

        cours.add(new Cours("Probability","Jacob@gmail.com ","Cours Probability "));
        cours.add(new Cours("Matrice","Jacob@gmail.com ","Cours Matrice "));
        cours.add(new Cours("Logarithme","Jacob@gmail.com ","Cours Logarithme"));
        cours.add(new Cours("Analyse","Jacob@gmail.com ","cours Analyse"));
        cours.add(new Cours("Geometrique","Jacob@gmail.com ","Cours Geometrique"));

    }

}