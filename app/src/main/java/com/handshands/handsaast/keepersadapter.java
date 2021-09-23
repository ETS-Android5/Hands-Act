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

public class keepersadapter extends RecyclerView.Adapter<keepersadapter.mh> {
    Context context;
    ArrayList<keepersinformation> list;

    public keepersadapter(Context context, ArrayList<keepersinformation> list) {
        this.context = context;
        this.list = list;
    }
    @NonNull
    @Override
    public mh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.rawgoal,parent,false);
        return new mh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull mh holder, int position) {
holder.name.setText(list.get(position).getName());
        holder.pos.setText(list.get(position).getPos());
        holder.clean.setText(list.get(position).getCleansheet());
        holder.saves.setText(list.get(position).getSave());
        Picasso.get().load(list.get(position).getImage()).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class mh extends RecyclerView.ViewHolder{
        TextView name,pos,clean,saves;
        ImageView img;
        public mh(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.keepname);
            pos=itemView.findViewById(R.id.keeppos);
            clean=itemView.findViewById(R.id.cleansheet);
            img=itemView.findViewById(R.id.imgkeep);
            saves=itemView.findViewById(R.id.saves);
        }
    }
}
