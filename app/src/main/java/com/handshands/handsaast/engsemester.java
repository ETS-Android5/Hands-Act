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

public class engsemester extends AppCompatActivity {
    RecyclerView re;
    ArrayList<engsemesterinheret> list;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_engsemester);
        re=findViewById(R.id.semerecy);
        list=new ArrayList<>();
        re.setLayoutManager(new LinearLayoutManager(this));
        Intent i=getIntent();
        String p=i.getStringExtra("cat");
        reference= FirebaseDatabase.getInstance().getReference("study").child("semesters").child(p);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list.clear();
for(DataSnapshot snapshot:dataSnapshot.getChildren()){
engsemesterinheret engsemesterinheret=new engsemesterinheret();
engsemesterinheret.setName(snapshot.child("name").getValue().toString());
    engsemesterinheret.setType(snapshot.child("type").getValue().toString());
    engsemesterinheret.setBackground(snapshot.child("background").getValue().toString());
    engsemesterinheret.setImage(snapshot.child("image").getValue().toString());
list.add(engsemesterinheret);
}
engsemesteradapter engsemesteradapter=new engsemesteradapter(list,engsemester.this);
re.setAdapter(engsemesteradapter);
engsemesteradapter.notifyDataSetChanged();
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

