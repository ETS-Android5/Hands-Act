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

public class engsemesteradapter extends RecyclerView.Adapter<engsemesteradapter.mh> {
    ArrayList<engsemesterinheret> list;
    Activity context;

    public engsemesteradapter(ArrayList<engsemesterinheret> list, Activity context) {
        this.list = list;
        this.context = context;
    }
    @NonNull
    @Override
    public mh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.rawengsemester,parent,false);
        return new mh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull mh holder, final int position) {
holder.name.setText(list.get(position).getName());
holder.type.setText(list.get(position).getType());
        Picasso.get().load(list.get(position).getImage()).into(holder.img2);
        Picasso.get().load(list.get(position).getBackground()).into(holder.img1);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent i=new Intent(context,engsubjects.class);
        i.putExtra("dep",list.get(position).getType());
        i.putExtra("seme",list.get(position).getName());
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
        TextView name,type;
ImageView img1,img2;
        public mh(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.engsemename);
            type=itemView.findViewById(R.id.type);
            img1=itemView.findViewById(R.id.background2);
            img2=itemView.findViewById(R.id.semenumber);
        }
    }
}
