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

public class categorie extends AppCompatActivity {
RecyclerView re;
DatabaseReference reference;
    ArrayList<collegeinheret> list;
    String s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorie);
    re=findViewById(R.id.catrece);
    list=new ArrayList<>();
    re.setLayoutManager(new LinearLayoutManager(this));
    Intent i=getIntent();
    s=i.getStringExtra("names");
    reference= FirebaseDatabase.getInstance().getReference("study").child("categories").child(s);
    reference.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            list.clear();
            for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                collegeinheret collegeinheret=new collegeinheret();
                collegeinheret.setName(snapshot.child("name").getValue().toString());
                collegeinheret.setImage(snapshot.child("image").getValue().toString());
                collegeinheret.setBackground(snapshot.child("background").getValue().toString());
                list.add(collegeinheret);
            }
categoriesadapter categoriesadapter=new categoriesadapter(list,categorie.this);
        re.setAdapter(categoriesadapter);
            categoriesadapter.notifyDataSetChanged();
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
