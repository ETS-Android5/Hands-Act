package com.handshands.handsaast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Studying extends AppCompatActivity {
RecyclerView r;
DatabaseReference reference;
ArrayList<collegeinheret> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studying);
        r=findViewById(R.id.collegerecycle);
        list=new ArrayList<>();
        r.setLayoutManager(new LinearLayoutManager(this));
        reference= FirebaseDatabase.getInstance().getReference("study").child("colleges");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list.clear();
                for (DataSnapshot snapshot:dataSnapshot.getChildren()){
                    collegeinheret collegeinheret=new collegeinheret();
                    collegeinheret.setName(snapshot.child("name").getValue().toString());
                    collegeinheret.setImage(snapshot.child("image").getValue().toString());
                    collegeinheret.setDescription(snapshot.child("description").getValue().toString());
                    collegeinheret.setBackground(snapshot.child("background").getValue().toString());
                    list.add(collegeinheret);

                }
collegeadapter collegeadapter=new collegeadapter(list,Studying.this);
            r.setAdapter(collegeadapter);
            collegeadapter.notifyDataSetChanged();
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
