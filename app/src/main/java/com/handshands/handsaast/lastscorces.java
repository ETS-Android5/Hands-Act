package com.handshands.handsaast;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;


/**
 * A simple {@link Fragment} subclass.
 */
public class lastscorces extends Fragment {
RecyclerView r1;
DatabaseReference reference;
        ArrayList<lastinheret> list;

    public lastscorces() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
 View v=inflater.inflate(R.layout.fragment_lastscorces, container, false);
         r1=v.findViewById(R.id.showlast);
         list=new ArrayList<>();
         r1.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));

         reference= FirebaseDatabase.getInstance().getReference("matchesplayed");
         reference.addValueEventListener(new ValueEventListener() {
             @Override
             public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                 list.clear();
                 for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                     final lastinheret lastinheret=new lastinheret();
                     lastinheret.setFirstname(snapshot.child("firstname").getValue().toString());
                     lastinheret.setSecname(snapshot.child("secondname").getValue().toString());
                     lastinheret.setDate(snapshot.child("date").getValue().toString());
                     lastinheret.setResult(snapshot.child("result").getValue().toString());
                     lastinheret.setGroupname(snapshot.child("groupname").getValue().toString());
                     lastinheret.setFirstimage(snapshot.child("firstimage").getValue().toString());
                     lastinheret.setSecimage(snapshot.child("secondimage").getValue().toString());
                     lastinheret.setFirstplan(snapshot.child("firstplan").getValue().toString());
                     lastinheret.setSecplan(snapshot.child("secondplan").getValue().toString());
                     lastinheret.setId(snapshot.child("id").getValue().toString());
                     lastinheret.setChat(snapshot.child("chat").getValue().toString());
list.add(lastinheret);
                     Collections.sort(list);
                 }
                 lastadapter lastadapter=new lastadapter(list,getActivity());
                 r1.setAdapter(lastadapter);
                 lastadapter.notifyDataSetChanged();

             }

             @Override
             public void onCancelled(@NonNull DatabaseError databaseError) {

             }
         });

return v;
    }
}
