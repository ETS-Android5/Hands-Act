package com.handshands.handsaast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.firebase.client.Firebase;
import com.github.chrisbanes.photoview.PhotoView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collections;

public class lastresult extends AppCompatActivity {
RecyclerView r1;
ArrayList<lastchatinheret>list;
DatabaseReference reference;
TextView name1,name2,mydate,myresult;
Dialog dialog,dialog2;
ImageView img1,img2,p1,p2;
LinearLayout l1,l2;
PhotoView photoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lastresult);
        Firebase.setAndroidContext(this);
        calling();
        list=new ArrayList<>();

Intent i=getIntent();
final String fn=i.getStringExtra("firstname");
        String sn=i.getStringExtra("secname");
        String r=i.getStringExtra("result");
        String d=i.getStringExtra("date");
        String c=i.getStringExtra("chat");
        final String fi=i.getStringExtra("img1");
        final String si=i.getStringExtra("img2");
final String pla1=i.getStringExtra("plan1");
        final String pla2=i.getStringExtra("plan2");

name1.setText(fn);
name2.setText(sn);
mydate.setText(d);
myresult.setText(r);
        Picasso.get().load(fi).into(img1);
        Picasso.get().load(si).into(img2);
        p1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog=new Dialog(lastresult.this);
                dialog.setContentView(R.layout.plan1);
                photoView=dialog.findViewById(R.id.plann);
                Picasso.get().load(pla1).into(photoView);
                dialog.show();
            }
        });

        p2.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
                                      dialog2=new Dialog(lastresult.this);
                                      dialog2.setContentView(R.layout.plan1);
                                      photoView=dialog2.findViewById(R.id.plann);
                                      Picasso.get().load(pla2).into(photoView);
                                      dialog2.show();
                                  }
                              }
        );
        l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(lastresult.this,information.class);
                i.putExtra("team",name1.getText().toString());
                i.putExtra("icon",fi);
                startActivity(i);
            }
        });
        l2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(lastresult.this,information.class);
                i.putExtra("team",name2.getText().toString());
                i.putExtra("icon",si);

                startActivity(i);
            }
        });
        r1.setLayoutManager(new LinearLayoutManager(this));
        reference =FirebaseDatabase.getInstance().getReference("lastchat").child(c);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list.clear();
                for (DataSnapshot snapshot:dataSnapshot.getChildren()){
                    lastchatinheret lastchatinheret=new lastchatinheret();
                    lastchatinheret.setLefttext(snapshot.child("lefttext").getValue().toString());
                    lastchatinheret.setRighttext(snapshot.child("righttext").getValue().toString());
                    lastchatinheret.setId(snapshot.child("id").getValue().toString());
                    lastchatinheret.setTime(snapshot.child("time").getValue().toString());
                    lastchatinheret.setLeftimg(snapshot.child("leftimage").getValue().toString());
                    lastchatinheret.setRightimg(snapshot.child("rightimage").getValue().toString());
list.add(lastchatinheret);
Collections.sort(list);
                }
                lastchatadapter lastchatadapter=new lastchatadapter(list,lastresult.this);
                r1.setAdapter(lastchatadapter);
                lastchatadapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }




    private void calling() {
        r1=findViewById(R.id.lastchat);
        name1=findViewById(R.id.textresult1);
        name2=findViewById(R.id.textresult2);
        myresult=findViewById(R.id.textresult);
        mydate=findViewById(R.id.textdate);
        img1=findViewById(R.id.imgresult1);
        img2=findViewById(R.id.imgresult2);
p1=findViewById(R.id.plan1);
p2=findViewById(R.id.plan2);
        l1=findViewById(R.id.myly1);
        l2=findViewById(R.id.result2);

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slideinleft,R.anim.slideoutright);
    }
}
