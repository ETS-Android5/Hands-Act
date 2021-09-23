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

import com.github.chrisbanes.photoview.PhotoView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collections;

public class liveresult extends AppCompatActivity {
    RecyclerView r1;
    ArrayList<lastchatinheret> list;
    DatabaseReference reference;
    TextView name1,name2,myresult;
    Dialog dialog,dialog2;
    ImageView img1,img2,p1,p2,mylive;
    LinearLayout l1,l2;
    PhotoView photoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liveresult);
        calling();
        list=new ArrayList<>();
        final Intent i=getIntent();
        final String fn=i.getStringExtra("firstname");
        String sn=i.getStringExtra("secname");
        String r=i.getStringExtra("result");
        String d=i.getStringExtra("live");
        String c=i.getStringExtra("chat");
        final String fi=i.getStringExtra("img1");
        final String si=i.getStringExtra("img2");
        final String pla1=i.getStringExtra("plan1");
        final String pla2=i.getStringExtra("plan2");
        name1.setText(fn);
        name2.setText(sn);
Picasso.get().load(d).into(mylive);
        myresult.setText(r);
        Picasso.get().load(fi).into(img1);
        Picasso.get().load(si).into(img2);
        p1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog=new Dialog(liveresult.this);
                dialog.setContentView(R.layout.plan1);
                photoView=dialog.findViewById(R.id.plann);
                Picasso.get().load(pla1).into(photoView);
                dialog.show();
            }
        });

        p2.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
                                      dialog2=new Dialog(liveresult.this);
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
                Intent j=new Intent(liveresult.this,information.class);
                j.putExtra("team",name1.getText().toString());
                j.putExtra("icon",fi);
                startActivity(j);
            }
        });
        l2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(liveresult.this,information.class);
                i.putExtra("team",name2.getText().toString());
                i.putExtra("icon",si);
                startActivity(i);

            }
        });
        r1.setLayoutManager(new LinearLayoutManager(this));
        reference = FirebaseDatabase.getInstance().getReference("livechat").child(c);
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
                lastchatadapter lastchatadapter=new lastchatadapter(list,liveresult.this);
                r1.setAdapter(lastchatadapter);
                lastchatadapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    private void calling() {
        r1=findViewById(R.id.livechat);
        name1=findViewById(R.id.livetextresult1);
        name2=findViewById(R.id.livetextresult2);
        myresult=findViewById(R.id.livetextresult);
        mylive=findViewById(R.id.lives);
        img1=findViewById(R.id.liveimgresult1);
        img2=findViewById(R.id.liveimgresult2);
        p1=findViewById(R.id.liveplan1);
        p2=findViewById(R.id.liveplan2);
        l1=findViewById(R.id.livemyly1);
        l2=findViewById(R.id.liveresult2);

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slideinleft,R.anim.slideoutright);
    }
}
