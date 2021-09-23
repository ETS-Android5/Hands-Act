package com.handshands.handsaast;

import android.content.Context;
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

public class lastchatadapter extends RecyclerView.Adapter<lastchatadapter.mh> {
    ArrayList<lastchatinheret> list;
    Context  context;

    public lastchatadapter(ArrayList<lastchatinheret> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public mh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.rawlastchat,parent,false);
        return new mh(v);
    }

    @Override
    public void onBindViewHolder(@NonNull mh holder, int position) {
        holder.lchat.setText(list.get(position).getLefttext());
        holder.rchat.setText(list.get(position).getRighttext());
        holder.time.setText(list.get(position).getTime());
            holder.id.setText(list.get(position).getId());
            Picasso.get().load(list.get(position).getLeftimg()).into(holder.img1);
            Picasso.get().load(list.get(position).getRightimg()).into(holder.img2);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class  mh extends RecyclerView.ViewHolder{
        TextView lchat,time,rchat,id;
        ImageView img1,img2;
        public mh(@NonNull View itemView) {
            super(itemView);
            lchat=itemView.findViewById(R.id.status1);
            rchat=itemView.findViewById(R.id.status2);
            time=itemView.findViewById(R.id.timematch);
            img1=itemView.findViewById(R.id.logo1);
            img2=itemView.findViewById(R.id.logo2);
id=itemView.findViewById(R.id.myi);

        }
    }
}
