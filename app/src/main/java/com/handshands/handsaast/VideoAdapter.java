package com.handshands.handsaast;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.exoplayer2.source.ClippingMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.mh> {
    ArrayList<videoModel>list;
    Context context;

    public VideoAdapter(ArrayList<videoModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public VideoAdapter.mh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.videocard,parent,
                false);

        return new mh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoAdapter.mh holder, int position) {
        holder.title.setText(list.get(position).getTitle());
        Picasso.get().load(list.get(position).getPicture()).into(holder.image);
        holder.videoView.setVideoURI(Uri.parse(list.get(position).getLink()));
        int duration =holder.videoView.getDuration();
        holder.videoView.start();

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,showvideo.class);
                intent.putExtra("link",list.get(position).getLink());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class mh extends RecyclerView.ViewHolder{
        TextView title;
        ImageView image;
        VideoView videoView;
        public mh(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.titlevideo);
            image=itemView.findViewById(R.id.imagevideo);
            videoView=itemView.findViewById(R.id.video);

        }
    }
}
