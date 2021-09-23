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

public class collegeadapter extends RecyclerView.Adapter<collegeadapter.mh> {
    ArrayList<collegeinheret> list;
    Activity context;

    public collegeadapter(ArrayList<collegeinheret> list, Activity context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public mh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.rawcollege,parent,false);
        return new mh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull mh holder, final int position) {
holder.name.setText(list.get(position).getName());
        Picasso.get().load(list.get(position).getImage()).into(holder.img);
        holder.desc.setText(list.get(position).getDescription());
        Picasso.get().load(list.get(position).getBackground()).into(holder.background);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position==0){
                    Intent i=new Intent(context,categorie.class);
                    i.putExtra("names",list.get(position).getName());
                    context.startActivity(i);
                    context.overridePendingTransition(R.anim.slideinright,R.anim.slideoutleft);

                }else {
                    Intent i=new Intent(context,semesters.class);
                    i.putExtra("name",list.get(position).getName());
                    context.startActivity(i);
                    context.overridePendingTransition(R.anim.slideinright,R.anim.slideoutleft);

                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class mh extends RecyclerView.ViewHolder{
        TextView name,desc;
        ImageView img,background;
        public mh(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.collegename);
            img=itemView.findViewById(R.id.collegephoto);
            background=itemView.findViewById(R.id.background);
            desc=itemView.findViewById(R.id.collegedesc);
        }
    }
}
