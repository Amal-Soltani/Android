package com.example.mycourses;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mycourses.Entity.Cours;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{


    List<Cours> coursArrayList;
    Context context;
    ProfileFragment profileFragment;

    public MyAdapter(List<Cours> cours, Context context) {
        this.coursArrayList = cours;
        this.context = context;
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view=View.inflate(context,R.layout.single_item,null);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {


        Cours cours = coursArrayList.get(position);
        holder.descp.setText(cours.getDescreption());
        holder.title.setText(cours.getTitle());
        holder.email.setText(cours.getEmail());


    }

    @Override
    public int getItemCount() {
        return coursArrayList.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder  {
        TextView title,email,descp;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tvCourse);
            email = itemView.findViewById(R.id.tvEmail);
            descp = itemView.findViewById(R.id.tvdescp);

        }
    }
}
