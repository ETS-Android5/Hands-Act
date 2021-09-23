package com.handshands.handsaast;

import android.content.Context;
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

public class valorantdetailsadapter extends RecyclerView.Adapter<valorantdetailsadapter.mh> {
    ArrayList<valorantdetailsmodel>list;
    Context context;

    public valorantdetailsadapter(ArrayList<valorantdetailsmodel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public valorantdetailsadapter.mh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.rawlastchat,parent,false);
        return new mh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull valorantdetailsadapter.mh holder, int position) {
        holder.lchat.setText(list.get(position).getLefttext());
        holder.rchat.setText(list.get(position).getRighttext());holder.id.setText(list.get(position).getId());
        Picasso.get().load(list.get(position).getLeftimage()).into(holder.img1);
        Picasso.get().load(list.get(position).getRightimage()).into(holder.img2);

        if(holder.rchat.getText().toString().equals(" ")){
            holder.layout.setBackgroundColor(Color.parseColor("#E91E63"));
        }
        if(holder.lchat.getText().toString().equals("Round")){
            holder.layout.setBackgroundColor(Color.TRANSPARENT);
        }
        if (holder.lchat.getText().toString().equals(" ")) {
            holder.layout.setBackgroundColor(Color.parseColor("#ADB8E6"));
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class mh extends RecyclerView.ViewHolder{
        TextView lchat,rchat,id;
        ImageView img1,img2;
        LinearLayout layout;
        public mh(@NonNull View itemView) {
            super(itemView);
            lchat=itemView.findViewById(R.id.status1);
            rchat=itemView.findViewById(R.id.status2);
            img1=itemView.findViewById(R.id.logo1);
            img2=itemView.findViewById(R.id.logo2);
            id=itemView.findViewById(R.id.myi);
            layout=itemView.findViewById(R.id.myla);
        }
    }
}
