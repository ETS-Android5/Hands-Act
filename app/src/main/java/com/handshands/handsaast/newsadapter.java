package com.handshands.handsaast;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class    newsadapter extends RecyclerView.Adapter<newsadapter.mh> {
    Activity context;
    ArrayList<newsinheret>list;
    public  newsadapter(Activity c, ArrayList<newsinheret> l){
        this.context=c;
        this.list=l;
    }

    @NonNull
    @Override
    public mh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.rawnews,parent,false);
        return new mh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull mh holder, final int position) {
holder.date.setText(list.get(position).getDate());
holder.des.setText(list.get(position).getDescription());
Picasso.get().load(list.get(position).getImage()).into(holder.imag);
        Picasso.get().load(list.get(position).getWideimage()).into(holder.img2);
holder.tit.setText(list.get(position).getTitle());
holder.report.setText(list.get(position).getReport());
holder.id.setText(list.get(position).getId());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent i=new Intent(context,reportpagefornews.class);
        i.putExtra("title",list.get(position).getTitle());
        i.putExtra("date",list.get(position).getDate());
        i.putExtra("image",list.get(position).getWideimage());
        i.putExtra("re",list.get(position).getReport());
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
        TextView date,des,id,tit,report;
                ImageView imag,img2;
        public mh(@NonNull View itemView) {
            super(itemView);
            date=itemView.findViewById(R.id.datee);
            des=itemView.findViewById(R.id.desc);
            imag=itemView.findViewById(R.id.myimg);
tit=itemView.findViewById(R.id.titlee);
report=itemView.findViewById(R.id.reporti);
id=itemView.findViewById(R.id.idi);
img2=itemView.findViewById(R.id.img2);
        }
    }
}
