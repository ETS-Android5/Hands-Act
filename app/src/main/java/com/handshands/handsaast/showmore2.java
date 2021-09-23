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

public class showmore2 extends AppCompatActivity {
RecyclerView r2;
DatabaseReference ref2;
ArrayList<topinformation> list2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showmore2);
r2=findViewById(R.id.showassist);
r2.setLayoutManager(new LinearLayoutManager(this));
    list2=new ArrayList<>();
        ref2= FirebaseDatabase.getInstance().getReference("top").child("assists");
        ref2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list2.clear();
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                    topinformation topinformation=new topinformation();
                    topinformation.setName(snapshot.child("name").getValue().toString());
                    topinformation.setPos(snapshot.child("pos").getValue().toString());
                    topinformation.setPoints(snapshot.child("points").getValue().toString());
                    topinformation.setImage(snapshot.child("image").getValue().toString());
                    list2.add(topinformation);
                    Collections.sort(list2);
                }
                topadapter topadapter=new topadapter(list2,showmore2.this);
                r2.setAdapter(topadapter);
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
