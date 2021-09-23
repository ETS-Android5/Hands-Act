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

public class playeradapter extends RecyclerView.Adapter<playeradapter.mh> {
    Context con;
    ArrayList<playerinformation> list;

    public playeradapter(Context con, ArrayList<playerinformation> list) {
        this.con = con;
        this.list = list;
    }

    @NonNull
    @Override
    public mh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(con).inflate(R.layout.rawstrike,parent,false);
        return new mh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull mh holder, int position) {
holder.name.setText(list.get(position).getName());
        holder.pos.setText(list.get(position).getPos());
        holder.goal.setText(list.get(position).getGoal());
        holder.assist.setText(list.get(position).getAssist());
        Picasso.get().load(list.get(position).getImage()).into(holder.playerimg);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class mh extends RecyclerView.ViewHolder{
        TextView name,pos,goal,assist;
        ImageView playerimg;
        public mh(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.playername);
            pos=itemView.findViewById(R.id.playerpos);
            goal=itemView.findViewById(R.id.goals);
            assist=itemView.findViewById(R.id.assists);
            playerimg=itemView.findViewById(R.id.playerimg);
        }
    }
}
