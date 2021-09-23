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
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class volunteers extends AppCompatActivity {
RecyclerView recyclerView;
DatabaseReference reference;
ArrayList<checkuser> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteers);
        recyclerView=findViewById(R.id.volunteerrec);
        list=new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        reference= FirebaseDatabase.getInstance().getReference("help").child("requests");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list.clear();
                for(DataSnapshot dataSnapshot:snapshot.getChildren()){
                    checkuser checkuser=new checkuser();
                    checkuser.setUid(dataSnapshot.child("uid").getValue().toString());
                    checkuser.setEmail(dataSnapshot.child("email").getValue().toString());
                    checkuser.setPhonenumber(dataSnapshot.child("phonenumber").getValue().toString());
                    checkuser.setType(dataSnapshot.child("type").getValue().toString());
                    checkuser.setDescription(dataSnapshot.child("description").getValue().toString());
                    list.add(checkuser);
                }
                volunteersadapter volunteersadapter=new volunteersadapter(volunteers.this,list);
                recyclerView.setAdapter(volunteersadapter);
                volunteersadapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}