package com.handshands.handsaast;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
public class livescorce extends Fragment {
    RecyclerView r1;
    DatabaseReference reference,ref2;
    ArrayList<liveinheret> list;
    TextView txt;
    public livescorce() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
            View v=inflater.inflate(R.layout.fragment_livescorce, container, false);
        r1=v.findViewById(R.id.showlive);
        txt=v.findViewById(R.id.day);
        ref2=FirebaseDatabase.getInstance().getReference();
        ref2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String m = dataSnapshot.child("matchestime").getValue().toString();
                txt.setText(m);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        list=new ArrayList<>();
        r1.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        reference= FirebaseDatabase.getInstance().getReference("livematches");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list.clear();
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                    final liveinheret liveinheret=new liveinheret();
                    liveinheret.setFirstname(snapshot.child("firstname").getValue().toString());
                    liveinheret.setSecname(snapshot.child("secondname").getValue().toString());
                    liveinheret.setLive(snapshot.child("live").getValue().toString());
                    liveinheret.setResult(snapshot.child("result").getValue().toString());
                    liveinheret.setGroupname(snapshot.child("groupname").getValue().toString());
                    liveinheret.setFirstimage(snapshot.child("firstimage").getValue().toString());
                    liveinheret.setSecimage(snapshot.child("secondimage").getValue().toString());
                    liveinheret.setFirstplan(snapshot.child("firstplan").getValue().toString());
                    liveinheret.setSecplan(snapshot.child("secondplan").getValue().toString());
                    liveinheret.setId(snapshot.child("id").getValue().toString());
                    liveinheret.setChat(snapshot.child("chat").getValue().toString());
                    list.add(liveinheret);
                }
                liveadapter liveadapter=new liveadapter(list,getActivity());
                r1.setAdapter(liveadapter);
                liveadapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        return v;
    }
}
