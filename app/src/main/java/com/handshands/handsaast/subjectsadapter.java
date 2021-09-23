package com.handshands.handsaast;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class subjectsadapter extends RecyclerView.Adapter<subjectsadapter.mh> {
    ArrayList<subjectinheret>list;
    Activity context;

    public subjectsadapter(ArrayList<subjectinheret> list, Activity context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public mh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
 View view= LayoutInflater.from(context).inflate(R.layout.rawengsubjects,parent,false);
        return new mh(view);
    }
    @Override
    public void onBindViewHolder(@NonNull mh holder, final int position) {
holder.name.setText(list.get(position).getName());
holder.code.setText(list.get(position).getCode());
holder.type.setText(list.get(position).getType());
        Picasso.get().load(list.get(position).getBackground()).into(holder.img);
holder.itemView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse(list.get(position).getType()));
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
        TextView name,code,type;
        ImageView img;
        public mh(@NonNull View itemView) {
            super(itemView);
        name=itemView.findViewById(R.id.subjname);
        code=itemView.findViewById(R.id.codename);
 type=itemView.findViewById(R.id.type2);
 img=itemView.findViewById(R.id.background3);
        }
    }
}
