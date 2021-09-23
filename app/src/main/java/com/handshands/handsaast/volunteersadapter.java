package com.handshands.handsaast;

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

import java.util.ArrayList;

public class volunteersadapter extends RecyclerView.Adapter<volunteersadapter.mh> {
    Context context;
    ArrayList<checkuser>list;

    public volunteersadapter(Context context, ArrayList<checkuser> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public volunteersadapter.mh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.raw_requests,parent,false);
        return new mh(v);
    }

    @Override
    public void onBindViewHolder(@NonNull volunteersadapter.mh holder, final int position) {
holder.text1.setText(list.get(position).getEmail().toString());
holder.text2.setText(list.get(position).getDescription().toString());
holder.image.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent i=new Intent(Intent.ACTION_DIAL);
        i.setData(Uri.parse("tel:"+list.get(position).getPhonenumber().toString()));
        context.startActivity(i);
    }
});

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class mh extends RecyclerView.ViewHolder{
        ImageView image;
        TextView text1,text2;
        public mh(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.call);
            text1=itemView.findViewById(R.id.emailreq);
            text2=itemView.findViewById(R.id.descreq);
        }
    }
}
