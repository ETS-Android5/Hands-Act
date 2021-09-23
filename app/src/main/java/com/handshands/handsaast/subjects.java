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

public class subjects extends AppCompatActivity {
RecyclerView r;
DatabaseReference reference;
ArrayList<subjectinheret> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subjects);
        r=findViewById(R.id.subjectrecy);
        r.setLayoutManager(new LinearLayoutManager(this));
        list=new ArrayList<>();
        Intent i=getIntent();
        String s=i.getStringExtra("dep");
        String p=i.getStringExtra("seme");
        reference= FirebaseDatabase.getInstance().getReference("study").child("subjects").child(s).child(p);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list.clear();
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){
           subjectinheret subjectinheret=new subjectinheret();
           subjectinheret.setName(snapshot.child("name").getValue().toString());
                    subjectinheret.setType(snapshot.child("link").getValue().toString());
                    subjectinheret.setCode(snapshot.child("code").getValue().toString());
                    subjectinheret.setBackground(snapshot.child("background").getValue().toString());
                    list.add(subjectinheret);
                }
                subjectsadapter subjectsadapter=new subjectsadapter(list,subjects.this);
                r.setAdapter(subjectsadapter);
                subjectsadapter.notifyDataSetChanged();
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
