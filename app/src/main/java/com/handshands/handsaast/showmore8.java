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
import java.util.Collections;

public class showmore8 extends AppCompatActivity {
    RecyclerView r1;
    DatabaseReference ref1;
    ArrayList<topkeeperinfo> list1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showmore8);
        list1=new ArrayList<>();
        r1.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        ref1= FirebaseDatabase.getInstance().getReference("topleague").child("adc");
        ref1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list1.clear();
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                    topkeeperinfo topinformation=new topkeeperinfo();
                    topinformation.setName(snapshot.child("name").getValue().toString());
                    topinformation.setPos(snapshot.child("position").getValue().toString());
                    topinformation.setCleansheet(snapshot.child("kills").getValue().toString());
                    topinformation.setSave(snapshot.child("assists").getValue().toString());
                    topinformation.setImage(snapshot.child("image").getValue().toString());
                    list1.add(topinformation);
                    Collections.sort(list1);
                }
                topkeeperadapter topadapter=new topkeeperadapter(list1,showmore8.this);
                r1.setAdapter(topadapter);
                topadapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}