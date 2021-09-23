package com.handshands.handsaast;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class groupaadapter extends RecyclerView.Adapter<groupaadapter.mh> {
    ArrayList<groupainheret> list;
    Activity con;

    public groupaadapter(ArrayList<groupainheret> list, Activity con) {
        this.list = list;
        this.con = con;
    }

    @NonNull
    @Override
    public mh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(con).inflate(R.layout.grouparaw,parent,false);
        return new mh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull mh holder, final int position) {
holder.name.setText(list.get(position).getTeam());
        holder.play.setText(list.get(position).getPlayed());
        holder.wl.setText(list.get(position).getWinlose());
        holder.calcul.setText(list.get(position).getCalculation());
        holder.point.setText(list.get(position).getPoints());
        Picasso.get().load(list.get(position).getImage()).into(holder.icon);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(con,information.class);
                i.putExtra("team",list.get(position).getTeam());
                i.putExtra("icon",list.get(position).getImage());
                con.startActivity(i);
                con.overridePendingTransition(R.anim.slideinright,R.anim.slideoutleft);

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class mh extends RecyclerView.ViewHolder{
        TextView name,play,wl,calcul,point;
        ImageView icon;
       public mh(@NonNull View itemView) {
           super(itemView);
           name=itemView.findViewById(R.id.teamname);
           play=itemView.findViewById(R.id.play);
           wl=itemView.findViewById(R.id.fl);
           calcul=itemView.findViewById(R.id.calc);
           point=itemView.findViewById(R.id.points);
icon=itemView.findViewById(R.id.logo);

       }
   }
}
