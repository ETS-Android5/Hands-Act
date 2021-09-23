package com.handshands.handsaast;

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

public class valorantknockoutadapter extends RecyclerView.Adapter<valorantknockoutadapter.mh> {
    ArrayList<valorantknockoutmodel> list;
    Context context;

    public valorantknockoutadapter(ArrayList<valorantknockoutmodel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public valorantknockoutadapter.mh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.rawknockout,parent,false);
        return new mh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull valorantknockoutadapter.mh holder, int position) {
        holder.fname.setText(list.get(position).getFirstteam());
        holder.sname.setText(list.get(position).getSecondteam());
        holder.result.setText(list.get(position).getResult());
        Picasso.get().load(list.get(position).getFirstimage()).into(holder.fimg);
        Picasso.get().load(list.get(position).getSecondimage()).into(holder.simg);
        holder.l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(context,valorantteams.class);
                i.putExtra("team",list.get(position).getFirstteam());
                i.putExtra("icon",list.get(position).getFirstimage());

                context.startActivity(i);
            }
        });
        holder.l2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j=new Intent(context,valorantteams.class);
                j.putExtra("team",list.get(position).getSecondteam());
                j.putExtra("icon",list.get(position).getSecondimage());
                context.startActivity(j);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class mh extends RecyclerView.ViewHolder{
        TextView fname,sname,result;
        ImageView fimg,simg;
        LinearLayout l1,l2;
        public mh(@NonNull View itemView) {
            super(itemView);
            fname=itemView.findViewById(R.id.firstteam);
            sname=itemView.findViewById(R.id.secteam);
            fimg=itemView.findViewById(R.id.firstimg);
            simg=itemView.findViewById(R.id.secondimg);
            result=itemView.findViewById(R.id.resultknockout);
            l1=itemView.findViewById(R.id.firstlay);
            l2=itemView.findViewById(R.id.seclay);
        }
    }
}
