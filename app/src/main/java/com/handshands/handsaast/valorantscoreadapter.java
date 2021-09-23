package com.handshands.handsaast;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class valorantscoreadapter extends RecyclerView.Adapter<valorantscoreadapter.mh> {
    ArrayList<valorantscoremodel>list;
    Context context;

    public valorantscoreadapter(ArrayList<valorantscoremodel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public valorantscoreadapter.mh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.rawtopinfo,parent,false);
        return new mh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull valorantscoreadapter.mh holder, int position) {
        holder.name.setText(list.get(position).getName());
        holder.points.setText(list.get(position).getKda());
        Picasso.get().load(list.get(position).getImage()).into(holder.img);
        if (position<5){
            holder.layout.setBackgroundColor(Color.parseColor("#E91E63"));
        }
        else {
            holder.layout.setBackgroundColor(Color.parseColor("#ADB8E6"));

        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class mh extends RecyclerView.ViewHolder{
        TextView name,points;
        ImageView img;
        LinearLayout layout;
        public mh(@NonNull View itemView) {
            super(itemView);
            name= itemView.findViewById(R.id.topname);
            points= itemView.findViewById(R.id.topwins);
            img= itemView.findViewById(R.id.imgtop);
            layout=itemView.findViewById(R.id.mylayout);
        }
    }
}
