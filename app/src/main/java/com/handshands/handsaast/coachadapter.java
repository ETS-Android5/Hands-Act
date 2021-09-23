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

public class coachadapter extends RecyclerView.Adapter<coachadapter.mh> {
    ArrayList<coachinformation> list;
    Context context;

    public coachadapter(ArrayList<coachinformation> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public mh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.rawcoach,parent,false);
        return new mh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull mh holder, int position) {
holder.name.setText(list.get(position).getName());
        holder.pos.setText(list.get(position).getPosition());
        holder.win.setText(list.get(position).getWins());
        Picasso.get().load(list.get(position).getImage()).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class mh extends RecyclerView.ViewHolder{
        TextView name,win,pos;
        ImageView img;
        public mh(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.cname);
            win=itemView.findViewById(R.id.wins);
            pos=itemView.findViewById(R.id.cpos);
            img=itemView.findViewById(R.id.imgc);

        }
    }
}
