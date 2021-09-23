package com.handshands.handsaast;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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

public class lastadapter extends RecyclerView.Adapter<lastadapter.mh> {
    ArrayList<lastinheret> list;
    Activity context;

    public lastadapter(ArrayList<lastinheret> list, Activity context) {
        this.list = list;
        this.context = context;
    }
    @NonNull
    @Override
    public mh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.rawlast,parent,false);
        return new mh(view);
    }
    @Override
    public void onBindViewHolder(@NonNull mh holder, final int position) {
holder.firstteam.setText(list.get(position).getFirstname());
        holder.secteam.setText(list.get(position).getSecname());
        holder.group.setText(list.get(position).getGroupname());
        holder.result.setText(list.get(position).getResult());
        holder.date.setText(list.get(position).getDate());
        holder.chat.setText(list.get(position).getChat());
        Picasso.get().load(list.get(position).getFirstimage()).into(holder.firstimg);
        Picasso.get().load(list.get(position).getSecimage()).into(holder.secimg);
        Picasso.get().load(list.get(position).getFirstplan()).into(holder.firstp);
        Picasso.get().load(list.get(position).getSecplan()).into(holder.secp);
        holder.id.setText(list.get(position).getId());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(context,lastresult.class);
                i.putExtra("firstname",list.get(position).getFirstname());
                i.putExtra("secname",list.get(position).getSecname());
                i.putExtra("result",list.get(position).getResult());
                i.putExtra("date",list.get(position).getDate());
                i.putExtra("chat",list.get(position).getChat());
                i.putExtra("img1",list.get(position).getFirstimage());
                i.putExtra("img2",list.get(position).getSecimage());
                i.putExtra("plan1",list.get(position).getFirstplan());
                i.putExtra("plan2",list.get(position).getSecplan());
                context.startActivity(i);
                context.overridePendingTransition(R.anim.slideinright,R.anim.slideoutleft);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class mh extends RecyclerView.ViewHolder{
TextView firstteam,secteam,group,result,date,id,chat;
ImageView firstimg,secimg,firstp,secp;
public mh(@NonNull View itemView) {
            super(itemView);
            firstteam=itemView.findViewById(R.id.showfirstname);
            secteam=itemView.findViewById(R.id.showsecname);
            group=itemView.findViewById(R.id.lastgroup);
            result=itemView.findViewById(R.id.lastresult);
            date=itemView.findViewById(R.id.lastdate);
            firstimg=itemView.findViewById(R.id.showfirstimg);
            secimg=itemView.findViewById(R.id.showsecimg);
            firstp=itemView.findViewById(R.id.firstplan);
            secp=itemView.findViewById(R.id.secplan);

    id=itemView.findViewById(R.id.myid);
    chat=itemView.findViewById(R.id.chat);
        }
    }
}
