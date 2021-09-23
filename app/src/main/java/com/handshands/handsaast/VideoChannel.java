package com.handshands.handsaast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.functions.FirebaseFunctions;

import java.util.ArrayList;
import java.util.Collections;

public class VideoChannel extends AppCompatActivity {
RecyclerView recyclerView;
ArrayList<videoModel> list2=new ArrayList<>();
    FirebaseDatabase database;
    DatabaseReference reference;
    VideoAdapter videoAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_channel);
        recyclerView=findViewById(R.id.videorec);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list2=new ArrayList<>();
        database=FirebaseDatabase.getInstance();
        reference=database.getReference();
        Query query=reference.child("videos");
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list2.clear();
                for( DataSnapshot dataSnapshot:snapshot.getChildren()){
                    videoModel videoModel=new videoModel();
                    videoModel.setTitle(dataSnapshot.child("title").getValue().toString());
                    videoModel.setPicture(dataSnapshot.child("picture").getValue().toString());
                    videoModel.setId(dataSnapshot.child("id").getValue().toString());
                    videoModel.setLink(dataSnapshot.child("link").getValue().toString());
                    list2.add(videoModel);
                    Collections.sort(list2);
                }
                videoAdapter=new VideoAdapter(list2,VideoChannel.this);
                recyclerView.setAdapter(videoAdapter);
                videoAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}