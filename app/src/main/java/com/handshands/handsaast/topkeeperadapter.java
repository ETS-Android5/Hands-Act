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

public class topkeeperadapter extends RecyclerView.Adapter<topkeeperadapter.mh> {
    ArrayList<topkeeperinfo>list;
    Context context;

    public topkeeperadapter(ArrayList<topkeeperinfo> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public mh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.rawtopkeeper,parent,false);
        return new mh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull mh holder, int position) {
holder.name.setText(list.get(position).getName());
        holder.pos.setText(list.get(position).getPos());
        holder.clean.setText(list.get(position).getCleansheet());
        holder.save.setText(list.get(position).getSave());
        Picasso.get().load(list.get(position).getImage()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class mh extends RecyclerView.ViewHolder{
        TextView name,pos,clean,save;
        ImageView imageView;
    public mh(@NonNull View itemView) {
        super(itemView);
        name=itemView.findViewById(R.id.topkeepname);
        pos=itemView.findViewById(R.id.topkeeppos);
        clean=itemView.findViewById(R.id.topclean);
        save=itemView.findViewById(R.id.topsave);
        imageView=itemView.findViewById(R.id.topimgkeep);


    }
}}
