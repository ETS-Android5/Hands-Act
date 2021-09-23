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

public class showmore1 extends AppCompatActivity {
RecyclerView r1;
DatabaseReference ref1;
        ArrayList<topinformation> list1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showmore1);
    r1=findViewById(R.id.showgoals);
    list1=new ArrayList<>();
    r1.setLayoutManager(new LinearLayoutManager(this));
        ref1= FirebaseDatabase.getInstance().getReference("top").child("goals");
        ref1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list1.clear();
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                    topinformation topinformation=new topinformation();
                    topinformation.setName(snapshot.child("name").getValue().toString());
                    topinformation.setPos(snapshot.child("pos").getValue().toString());
                    topinformation.setPoints(snapshot.child("points").getValue().toString());
                    topinformation.setImage(snapshot.child("image").getValue().toString());
                    list1.add(topinformation);
                    Collections.sort(list1);
                }
                topadapter topadapter=new topadapter(list1,showmore1.this);
                r1.setAdapter(topadapter);
                topadapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slideinbottom,R.anim.slideoutbuttom);
    }
}
