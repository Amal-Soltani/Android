package com.example.mycourses;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.mycourses.Entity.Cours;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment { RecyclerView rv;
    List<Cours> cours;
    Button btnAdd;
    MyAdapter myAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_profile, container, false);
        datainitializa();


        rv= view.findViewById(R.id.recyclerView);
        myAdapter = new MyAdapter(cours, getContext());
        rv.setAdapter(myAdapter);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setHasFixedSize(true);


        myAdapter.notifyDataSetChanged();

        return view ;
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