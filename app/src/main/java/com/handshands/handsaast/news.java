package com.handshands.handsaast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.widget.RemoteViews;

import com.firebase.client.Firebase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.messaging.FirebaseMessagingService;

import java.util.ArrayList;
import java.util.Collections;

public class news extends AppCompatActivity  {
RecyclerView re;
FirebaseDatabase database;
DatabaseReference reference;
newsadapter newsadapter;
ArrayList<newsinheret> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        Firebase.setAndroidContext(this);
        re=findViewById(R.id.newsreyc);
        re.setLayoutManager(new LinearLayoutManager(this));
        arrayList=new ArrayList<>();

        database=FirebaseDatabase.getInstance();
        reference=database.getReference();
        Query query=reference.child("news");
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                arrayList.clear();
                for( DataSnapshot snapshot:dataSnapshot.getChildren()){
                    newsinheret newsinheret=new newsinheret();
                    newsinheret.setDate(snapshot.child("date").getValue().toString());
                    newsinheret.setDescription(snapshot.child("description").getValue().toString());
                    newsinheret.setImage(snapshot.child("image").getValue().toString());
                    newsinheret.setWideimage(snapshot.child("wide image").getValue().toString());
                    newsinheret.setReport(snapshot.child("report").getValue().toString());
newsinheret.setTitle(snapshot.child("title").getValue().toString());
newsinheret.setId(snapshot.child("id").getValue().toString());
                arrayList.add(newsinheret);
                    Collections.sort(arrayList);


                }
                newsadapter=new newsadapter(news.this,arrayList);
                re.setAdapter(newsadapter);
                newsadapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slideinleft,R.anim.slideoutright);
    }
}
