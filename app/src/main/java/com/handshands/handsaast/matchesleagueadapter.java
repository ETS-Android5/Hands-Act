package com.handshands.handsaast;

import android.app.Activity;
import android.content.Intent;
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

public class matchesleagueadapter extends RecyclerView.Adapter<matchesleagueadapter.mh> {
    ArrayList<matchesvalorantmodel> list;
    Activity context;

    public matchesleagueadapter(ArrayList<matchesvalorantmodel> list, Activity context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public matchesleagueadapter.mh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.rawleaguematch,parent,false);
        return new mh(view);    }

    @Override
    public void onBindViewHolder(@NonNull matchesleagueadapter.mh holder, int position) {
        holder.firstteam.setText(list.get(position).getFirstname());
        holder.secteam.setText(list.get(position).getSecname());
        holder.group.setText(list.get(position).getGroupname());
        holder.result.setText(list.get(position).getResult());
        holder.chat.setText(list.get(position).getChat());
        holder.date.setText(list.get(position).getDate());
        Picasso.get().load(list.get(position).getLive()).into(holder.live);
        Picasso.get().load(list.get(position).getFirstimage()).into(holder.firstimg);
        Picasso.get().load(list.get(position).getSecimage()).into(holder.secimg);
        holder.id.setText(list.get(position).getId());
        if(list.get(position).getWin().equals("left")){
            holder.l1.setBackgroundColor(Color.GREEN);
            holder.l2.setBackgroundColor(Color.RED);
        }
        else if (list.get(position).getWin().equals("right")){
            holder.l2.setBackgroundColor(Color.GREEN);
            holder.l1.setBackgroundColor(Color.RED);
        }
        else {
            holder.l2.setBackgroundColor(Color.TRANSPARENT);
            holder.l1.setBackgroundColor(Color.TRANSPARENT);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(context,leaguedetails.class);
                i.putExtra("firstname",list.get(position).getFirstname());
                i.putExtra("secname",list.get(position).getSecname());
                i.putExtra("result",list.get(position).getResult());
                i.putExtra("live",list.get(position).getLive());
                i.putExtra("chat",list.get(position).getChat());
                i.putExtra("img1",list.get(position).getFirstimage());
                i.putExtra("img2",list.get(position).getSecimage());
                i.putExtra("score",list.get(position).getScoretable());
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
        TextView firstteam,secteam,group,result,id,chat,date;
        ImageView firstimg,secimg,live;
        LinearLayout l1,l2;
        public mh(@NonNull View itemView) {
            super(itemView);
            firstteam=itemView.findViewById(R.id.showlivefirstname);
            secteam=itemView.findViewById(R.id.showlivesecname);
            group=itemView.findViewById(R.id.livegroup);
            result=itemView.findViewById(R.id.liveresult);
            live=itemView.findViewById(R.id.live);
            firstimg=itemView.findViewById(R.id.showlivefirstimg);
            secimg=itemView.findViewById(R.id.showlivesecimg);
            id=itemView.findViewById(R.id.livemyid);
            chat=itemView.findViewById(R.id.chat2);
            date=itemView.findViewById(R.id.date);
            l1=itemView.findViewById(R.id.ly1);
            l2=itemView.findViewById(R.id.ly2);
        }
    }
}
