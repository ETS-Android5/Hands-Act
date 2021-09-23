package com.handshands.handsaast;

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

public class eventsadapter extends RecyclerView.Adapter<eventsadapter.mvh> {
    ArrayList<eventsinherent> list;
    Context con;
public eventsadapter(ArrayList<eventsinherent>l,Context c){
this.list=l;
this.con=c;
}
    @NonNull
    @Override
    public mvh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
View view= LayoutInflater.from(con).inflate(R.layout.rawevents,parent,false);
    return new mvh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull mvh holder, int position) {
holder.mydate.setText(list.get(position).getTime());
holder.mydisc.setText(list.get(position).getDescription());
        holder.day.setText(list.get(position).getDay());
        holder.time.setText(list.get(position).getMonth());
Picasso.get().load(list.get(position).getImage()).into(holder.img);
holder.id.setText(list.get(position).getId());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class mvh extends RecyclerView.ViewHolder{
TextView mydate,mydisc,id,day,time;
ImageView img;
    public mvh(@NonNull View itemView) {
        super(itemView);
mydate=itemView.findViewById(R.id.showdate);
mydisc=itemView.findViewById(R.id.showdisc);
img=itemView.findViewById(R.id.myevent);
id=itemView.findViewById(R.id.takeid);
day=itemView.findViewById(R.id.dayy);
time=itemView.findViewById(R.id.month);
    }
}
}
