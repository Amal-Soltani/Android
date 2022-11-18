package com.example.mycourses;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mycourses.Entity.Cours;

import java.util.List;

public class MyAdapter2 extends RecyclerView.Adapter<MyAdapter2.MyViewHolder> {

    List<Cours> cours;
    Context context;

    public MyAdapter2(List<Cours> cours, Context context) {
        this.cours = cours;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=View.inflate(context,R.layout.single_item,null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.descp.setText(cours.get(position).getDescreption());
        holder.title.setText(cours.get(position).getTitle());
        holder.email.setText(cours.get(position).getEmail());
    }


    @Override
    public int getItemCount() {
        return cours.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title,email,descp;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tvCourse);
            email = itemView.findViewById(R.id.tvEmail);
            descp = itemView.findViewById(R.id.tvdescp);
        }
    }



}

