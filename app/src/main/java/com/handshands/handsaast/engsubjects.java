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

public class engsubjects extends AppCompatActivity {
RecyclerView r1;
DatabaseReference reference;
ArrayList<subjectinheret>list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_engsubjects);
        r1=findViewById(R.id.subjects);
        list=new ArrayList<>();
        Intent i=getIntent();
        r1.setLayoutManager(new LinearLayoutManager(this));
        String s=i.getStringExtra("dep");
        String p=i.getStringExtra("seme");
        reference= FirebaseDatabase.getInstance().getReference("study").child("engsubjects").child(s).child(p);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list.clear();
                for (DataSnapshot snapshot:dataSnapshot.getChildren()){
             subjectinheret subjectinheret=new subjectinheret();
subjectinheret.setName(snapshot.child("name").getValue().toString());
subjectinheret.setCode(snapshot.child("code").getValue().toString());
subjectinheret.setType(snapshot.child("link").getValue().toString());
                    subjectinheret.setBackground(snapshot.child("background").getValue().toString());
list.add(subjectinheret);

            }
                subjectsadapter subjectsadapter=new subjectsadapter(list,engsubjects.this);
                r1.setAdapter(subjectsadapter);
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
