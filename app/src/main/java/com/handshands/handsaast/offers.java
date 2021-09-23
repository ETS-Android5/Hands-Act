package com.handshands.handsaast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class offers extends AppCompatActivity {
RecyclerView recyclerView;
ArrayList<offersinheret>list;
DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offers);
        recyclerView=findViewById(R.id.myofffers);
recyclerView.setLayoutManager(new LinearLayoutManager(this));
list=new ArrayList<>();
reference= FirebaseDatabase.getInstance().getReference("offers").child("items");
reference.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot snapshot) {
        list.clear();
        for(DataSnapshot dataSnapshot:snapshot.getChildren()){
            offersinheret offersinheret=new offersinheret();
            offersinheret.setPercentage(dataSnapshot.child("percentage").getValue().toString());
            offersinheret.setOffer(dataSnapshot.child("offer").getValue().toString());
            offersinheret.setDetails(dataSnapshot.child("details").getValue().toString());
            offersinheret.setBackground(dataSnapshot.child("background").getValue().toString());
            offersinheret.setImage(dataSnapshot.child("image").getValue().toString());
            offersinheret.setCode(dataSnapshot.child("code").getValue().toString());
list.add(offersinheret);
        }
        offersadapter offersadapter=new offersadapter(list,offers.this);
        recyclerView.setAdapter(offersadapter);
        offersadapter.notifyDataSetChanged();
    }

    @Override
    public void onCancelled(@NonNull DatabaseError error) {

    }
});



    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(offers.this,MainActivity.class));
        overridePendingTransition(R.anim.slideinleft,R.anim.slideoutright);
    }
}