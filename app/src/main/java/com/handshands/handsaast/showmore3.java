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

public class showmore3 extends AppCompatActivity {
    RecyclerView r3;
    ArrayList<topkeeperinfo> list;
    DatabaseReference ref4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showmore3);
        r3=findViewById(R.id.showcleans);
        list=new ArrayList<>();
        r3.setLayoutManager(new LinearLayoutManager(this));
        ref4= FirebaseDatabase.getInstance().getReference("top").child("cleansheets");
        ref4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list.clear();
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                    topkeeperinfo topkeeperinfo=new topkeeperinfo();
                    topkeeperinfo.setName(snapshot.child("name").getValue().toString());
                    topkeeperinfo.setPos(snapshot.child("pos").getValue().toString());
                    topkeeperinfo.setCleansheet(snapshot.child("cleansheet").getValue().toString());
                    topkeeperinfo.setImage(snapshot.child("image").getValue().toString());
                    topkeeperinfo.setSave(snapshot.child("save").getValue().toString());
                    list.add(topkeeperinfo);
                    Collections.sort(list);
                }
                topkeeperadapter topadapter=new topkeeperadapter(list,showmore3.this);
                r3.setAdapter(topadapter);
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
