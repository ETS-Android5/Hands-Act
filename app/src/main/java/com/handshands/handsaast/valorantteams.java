package com.handshands.handsaast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collections;

public class valorantteams extends AppCompatActivity {
    RecyclerView r1;
    ArrayList<playerinformation> list1;
    DatabaseReference ref1;
    TextView textView;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_valorantteams);
        r1=findViewById(R.id.str);
        textView=findViewById(R.id.nameteam);
        imageView=findViewById(R.id.teamimg);
        list1=new ArrayList<>();
        r1.setLayoutManager(new LinearLayoutManager(this));
        Intent i=getIntent();
        String  team=i.getStringExtra("team");
        String img=i.getStringExtra("icon");
        textView.setText(team);
        Picasso.get().load(img).into(imageView);
        ref1= FirebaseDatabase.getInstance().getReference("valorantteams").child(team).child("people");
        ref1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list1.clear();
                for (DataSnapshot snapshot:dataSnapshot.getChildren()){
                    playerinformation playerinformation=new playerinformation();
                    playerinformation.setName(snapshot.child("name").getValue().toString());
                    playerinformation.setGoal(snapshot.child("kda").getValue().toString());
                    playerinformation.setAssist(snapshot.child("headshots").getValue().toString());
                    playerinformation.setImage(snapshot.child("image").getValue().toString());
                    list1.add(playerinformation);
                    Collections.sort(list1);
                }
                playeradapter  playeradapter=new playeradapter(valorantteams.this,list1);
                r1.setAdapter(playeradapter);
                playeradapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}