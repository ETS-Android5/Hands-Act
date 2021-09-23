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

public class leaguedetails extends AppCompatActivity {
    RecyclerView r1, r2;
    ArrayList<valorantdetailsmodel> list;
    ArrayList<valorantscoremodel> list2;
    DatabaseReference reference, reference2;
    TextView name1, name2, myresult;
    ImageView img1, img2,  mylive;
    LinearLayout l1, l2;
    PhotoView photoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaguedetails);
        calling();
        list = new ArrayList<>();
        list2 = new ArrayList<>();
        final Intent i = getIntent();
        final String fn = i.getStringExtra("firstname");
        String sn = i.getStringExtra("secname");
        String r = i.getStringExtra("result");
        String d = i.getStringExtra("live");
        String c = i.getStringExtra("chat");
        String s = i.getStringExtra("score");
        final String fi = i.getStringExtra("img1");
        final String si = i.getStringExtra("img2");
        name1.setText(fn);
        name2.setText(sn);
        Picasso.get().load(d).into(mylive);
        myresult.setText(r);
        Picasso.get().load(fi).into(img1);
        Picasso.get().load(si).into(img2);
        l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j=new Intent(leaguedetails.this,valorantteams.class);
                j.putExtra("team",name1.getText().toString());
                j.putExtra("icon",fi);
                startActivity(j);
            }
        });
        l2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(leaguedetails.this,valorantteams.class);
                i.putExtra("team",name2.getText().toString());
                i.putExtra("icon",si);
                startActivity(i);

            }
        });
        r1.setLayoutManager(new LinearLayoutManager(this));
        reference = FirebaseDatabase.getInstance().getReference("leaguedetails").child(c);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    valorantdetailsmodel lastchatinheret = new valorantdetailsmodel();
                    lastchatinheret.setLefttext(snapshot.child("lefttext").getValue().toString());
                    lastchatinheret.setRighttext(snapshot.child("righttext").getValue().toString());
                    lastchatinheret.setId(snapshot.child("id").getValue().toString());
                    lastchatinheret.setLeftimage(snapshot.child("leftimage").getValue().toString());
                    lastchatinheret.setRightimage(snapshot.child("rightimage").getValue().toString());
                    list.add(lastchatinheret);
                    Collections.sort(list);
                }
                valorantdetailsadapter lastchatadapter = new valorantdetailsadapter(list, leaguedetails.this);
                r1.setAdapter(lastchatadapter);
                lastchatadapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        r2.setLayoutManager(new LinearLayoutManager(this));
        reference2 = FirebaseDatabase.getInstance().getReference("leaguescores").child(s);
        reference2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list2.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    valorantscoremodel lastchatinheret = new valorantscoremodel();
                    lastchatinheret.setImage(snapshot.child("image").getValue().toString());
                    lastchatinheret.setKda(snapshot.child("kda").getValue().toString());
                    lastchatinheret.setName(snapshot.child("name").getValue().toString());
                    list2.add(lastchatinheret);
                }
                valorantscoreadapter lastchatadapter = new valorantscoreadapter(list2, leaguedetails.this);
                r2.setAdapter(lastchatadapter);
                lastchatadapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void calling() {
        r1 = findViewById(R.id.livechat);
        r2 = findViewById(R.id.score);
        name1 = findViewById(R.id.livetextresult1);
        name2 = findViewById(R.id.livetextresult2);
        myresult = findViewById(R.id.livetextresult);
        mylive = findViewById(R.id.lives);
        img1 = findViewById(R.id.liveimgresult1);
        img2 = findViewById(R.id.liveimgresult2);
        l1 = findViewById(R.id.livemyly1);
        l2 = findViewById(R.id.liveresult2);
    }
}