package com.handshands.handsaast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.client.Firebase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collections;

public class information extends AppCompatActivity {
RecyclerView r1,r2,r3,r4,r5;
ArrayList<keepersinformation> list2;
    ArrayList<playerinformation> list1;
    ArrayList<playerinformation> list3;
    ArrayList<playerinformation> list4;
ArrayList<coachinformation>list5;
keepersadapter keepersadapter;
DatabaseReference ref1,ref2,ref3,ref4,ref5;
TextView textView;
ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        Firebase.setAndroidContext(this);
        calling();
        list1=new ArrayList<>();
        list2=new ArrayList<>();
        list3=new ArrayList<>();
        list4=new ArrayList<>();
        list5=new ArrayList<>();
r1.setLayoutManager(new LinearLayoutManager(this));
        r2.setLayoutManager(new LinearLayoutManager(this));
        r3.setLayoutManager(new LinearLayoutManager(this));
        r4.setLayoutManager(new LinearLayoutManager(this));
        r5.setLayoutManager(new LinearLayoutManager(this));
        Intent i=getIntent();
           String  team=i.getStringExtra("team");
        String img=i.getStringExtra("icon");
        textView.setText(team);
            Picasso.get().load(img).into(imageView);
        ref1= FirebaseDatabase.getInstance().getReference("teams").child(team).child("strikers");
        ref1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
list1.clear();
                for (DataSnapshot snapshot:dataSnapshot.getChildren()){
                    playerinformation playerinformation=new playerinformation();
                    playerinformation.setName(snapshot.child("name").getValue().toString());
                    playerinformation.setPos(snapshot.child("pos").getValue().toString());
                    playerinformation.setGoal(snapshot.child("goal").getValue().toString());
                    playerinformation.setAssist(snapshot.child("assist").getValue().toString());
                    playerinformation.setImage(snapshot.child("image").getValue().toString());
                    list1.add(playerinformation);
                    Collections.sort(list1);
                }
          playeradapter  playeradapter=new playeradapter(information.this,list1);
                r1.setAdapter(playeradapter);
                playeradapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        ref2=FirebaseDatabase.getInstance().getReference("teams").child(team).child("midfielders");
        ref2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list4.clear();
                for (DataSnapshot snapshot:dataSnapshot.getChildren()){

                    playerinformation playerinformation=new playerinformation();
                    playerinformation.setName(snapshot.child("name").getValue().toString());
                    playerinformation.setPos(snapshot.child("pos").getValue().toString());
                    playerinformation.setGoal(snapshot.child("goal").getValue().toString());
                    playerinformation.setAssist(snapshot.child("assist").getValue().toString());
                    playerinformation.setImage(snapshot.child("image").getValue().toString());
                    list4.add(playerinformation);
                    Collections.sort(list4);

                }
                playeradapter  playeradapter=new playeradapter(information.this,list4);
                r2.setAdapter(playeradapter);
                playeradapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
ref3=FirebaseDatabase.getInstance().getReference("teams").child(team).child("defenders");
ref3.addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                            list3.clear();
                                            for (DataSnapshot snapshot:dataSnapshot.getChildren()){
                                                playerinformation playerinformation=new playerinformation();
                                                playerinformation.setName(snapshot.child("name").getValue().toString());
                                                playerinformation.setPos(snapshot.child("pos").getValue().toString());
                                                playerinformation.setGoal(snapshot.child("goal").getValue().toString());
                                                playerinformation.setAssist(snapshot.child("assist").getValue().toString());
                                                playerinformation.setImage(snapshot.child("image").getValue().toString());
                                                list3.add(playerinformation);
                                                Collections.sort(list3);
                                            }
                                            playeradapter  playeradapter=new playeradapter(information.this,list3);
                                            r3.setAdapter(playeradapter);
                                            playeradapter.notifyDataSetChanged();

                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                        }
                                    }
);
ref4=FirebaseDatabase.getInstance().getReference("teams").child(team).child("goalkeepers");
ref4.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        list2.clear();
        for (DataSnapshot snapshot:dataSnapshot.getChildren()){
            keepersinformation playerinformation=new keepersinformation();
            playerinformation.setName(snapshot.child("name").getValue().toString());
            playerinformation.setPos(snapshot.child("pos").getValue().toString());
          playerinformation.setCleansheet(snapshot.child("cleansheet").getValue().toString());
            playerinformation.setImage(snapshot.child("image").getValue().toString());
            playerinformation.setSave(snapshot.child("save").getValue().toString());
            list2.add(playerinformation);
            Collections.sort(list2);
        }
        keepersadapter=new keepersadapter(information.this,list2);
        r4.setAdapter(keepersadapter);
        keepersadapter.notifyDataSetChanged();
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }
});
ref5=FirebaseDatabase.getInstance().getReference("teams").child(team).child("coach");
ref5.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        list5.clear();
        for(DataSnapshot snapshot:dataSnapshot.getChildren()){
            coachinformation coachinformation=new coachinformation();
            coachinformation.setName(snapshot.child("name").getValue().toString());
            coachinformation.setPosition(snapshot.child("position").getValue().toString());
            coachinformation.setWins(snapshot.child("wins").getValue().toString());
            coachinformation.setImage(snapshot.child("image").getValue().toString());
            list5.add(coachinformation);
            Collections.sort(list5);
        }
        coachadapter coachadapter=new coachadapter(list5,information.this);
        r5.setAdapter(coachadapter);
        coachadapter.notifyDataSetChanged();
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {
    }
});
    }
    private void calling() {
        r1=findViewById(R.id.str);
        r2=findViewById(R.id.mid);
        r3=findViewById(R.id.def);
        r4=findViewById(R.id.goal);
        r5=findViewById(R.id.coach);
        textView=findViewById(R.id.nameteam);
        imageView=findViewById(R.id.teamimg);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slideinleft,R.anim.slideoutright);
    }
}
