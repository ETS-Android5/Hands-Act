package com.handshands.handsaast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.functions.FirebaseFunctions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class events extends AppCompatActivity {
RecyclerView recyclerView;
TextView month;
FirebaseDatabase database;
DatabaseReference reference;
    FirebaseDatabase database2;
    DatabaseReference reference2;
eventsadapter eventsadapter;
ArrayList<eventsinherent> arrayList;
FirebaseFunctions firebaseFunctions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        Firebase.setAndroidContext(this);
        calling();
        database2=FirebaseDatabase.getInstance();
        reference2=database2.getReference();

       reference2.addValueEventListener(new ValueEventListener() {

           @Override
           public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                   String m = dataSnapshot.child("eventmonth").getValue().toString();
                   month.setText(m);

           }

           @Override
           public void onCancelled(@NonNull DatabaseError databaseError) {

           }
       });
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        arrayList=new ArrayList<>();
        database=FirebaseDatabase.getInstance();
        reference=database.getReference();
        Query query=reference.child("events");
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                arrayList.clear();
                for( DataSnapshot snapshot:dataSnapshot.getChildren()){
                    eventsinherent eventsinherent=new eventsinherent();
                    eventsinherent.setTime(snapshot.child("time").getValue().toString());
                    eventsinherent.setDay(snapshot.child("day").getValue().toString());
                    eventsinherent.setMonth(snapshot.child("month").getValue().toString());
                    eventsinherent.setDescription(snapshot.child("description").getValue().toString());
                    eventsinherent.setImage(snapshot.child("image").getValue().toString());
eventsinherent.setId(snapshot.child("id").getValue().toString());
                    arrayList.add(eventsinherent);
                    Collections.sort(arrayList);
                    firebaseFunctions=FirebaseFunctions.getInstance();
                }

eventsadapter=new eventsadapter(arrayList,events.this);
recyclerView.setAdapter(eventsadapter);
eventsadapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    private void calling() {
        recyclerView=findViewById(R.id.eventsreyc);
        month=findViewById(R.id.eventstxt);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slideinleft,R.anim.slideoutright);
    }

}


