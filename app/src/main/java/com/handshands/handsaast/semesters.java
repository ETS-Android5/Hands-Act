package com.handshands.handsaast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class semesters extends AppCompatActivity {
RecyclerView r1;
DatabaseReference reference;
ArrayList<engsemesterinheret>list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semesters);
        r1=findViewById(R.id.othersemester);
        r1.setLayoutManager(new LinearLayoutManager(this));
        list=new ArrayList<>();
        Intent i=getIntent();
        String s=i.getStringExtra("name");
        reference=FirebaseDatabase.getInstance().getReference("study").child("othersemesters").child(s);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list.clear();
                for (DataSnapshot snapshot:dataSnapshot.getChildren()){
           engsemesterinheret engsemesterinheret=new engsemesterinheret();
           engsemesterinheret.setName(snapshot.child("name").getValue().toString());
           engsemesterinheret.setType(snapshot.child("type").getValue().toString());
           engsemesterinheret.setImage(snapshot.child("image").getValue().toString());
                    engsemesterinheret.setBackground(snapshot.child("background").getValue().toString());
                    list.add(engsemesterinheret);
                }
                othersemestersadapter othersemestersadapter=new othersemestersadapter(list,semesters.this);
                r1.setAdapter(othersemestersadapter);
                othersemestersadapter.notifyDataSetChanged();
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
