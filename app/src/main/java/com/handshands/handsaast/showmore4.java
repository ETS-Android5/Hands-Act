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

public class showmore4 extends AppCompatActivity {
    RecyclerView r4;
    ArrayList<topinformation> list3;
    DatabaseReference ref3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showmore4);
     r4=findViewById(R.id.showwins);
     list3=new ArrayList<>();
     r4.setLayoutManager(new LinearLayoutManager(this));
        ref3= FirebaseDatabase.getInstance().getReference("top").child("wins");
        ref3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list3.clear();
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                    topinformation topinformation=new topinformation();
                    topinformation.setName(snapshot.child("name").getValue().toString());
                    topinformation.setPos(snapshot.child("pos").getValue().toString());
                    topinformation.setPoints(snapshot.child("points").getValue().toString());
                    topinformation.setImage(snapshot.child("image").getValue().toString());
                    list3.add(topinformation);
                    Collections.sort(list3);
                }
                topadapter topadapter=new topadapter(list3,showmore4.this);
                r4.setAdapter(topadapter);
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
