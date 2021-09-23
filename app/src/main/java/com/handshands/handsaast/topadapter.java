package com.handshands.handsaast;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class topadapter extends RecyclerView.Adapter<topadapter.mh> {
    ArrayList<topinformation>list;
    Context context;

    public topadapter(ArrayList<topinformation> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public mh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.rawtopinfo,parent,false);
        return new mh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull mh holder, int position) {
holder.name.setText(list.get(position).getName());
        holder.pos.setText(list.get(position).getPos());
        holder.points.setText(list.get(position).getPoints());
        Picasso.get().load(list.get(position).getImage()).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class mh extends RecyclerView.ViewHolder{
TextView name,pos,points;
ImageView img;
        public mh(@NonNull View itemView) {
            super(itemView);
           name= itemView.findViewById(R.id.topname);
            pos= itemView.findViewById(R.id.toppos);
            points= itemView.findViewById(R.id.topwins);
            img= itemView.findViewById(R.id.imgtop);

        }
    }
}
