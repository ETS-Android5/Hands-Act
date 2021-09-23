package com.handshands.handsaast;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class matchesvalorant extends Fragment {
    RecyclerView r1;
    DatabaseReference reference;
    ArrayList<matchesvalorantmodel> list;

    public matchesvalorant() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_matchesvalorant, container, false);
        list=new ArrayList<>();
        r1=view.findViewById(R.id.matchesvalorant);
        reference= FirebaseDatabase.getInstance().getReference("valorantmatches");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list.clear();
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                    final matchesvalorantmodel liveinheret=new matchesvalorantmodel();
                    liveinheret.setFirstname(snapshot.child("firstname").getValue().toString());
                    liveinheret.setSecname(snapshot.child("secondname").getValue().toString());
                    liveinheret.setLive(snapshot.child("live").getValue().toString());
                    liveinheret.setResult(snapshot.child("result").getValue().toString());
                    liveinheret.setGroupname(snapshot.child("groupname").getValue().toString());
                    liveinheret.setFirstimage(snapshot.child("firstimage").getValue().toString());
                    liveinheret.setSecimage(snapshot.child("secondimage").getValue().toString());
                    liveinheret.setDate(snapshot.child("date").getValue().toString());
                    liveinheret.setId(snapshot.child("id").getValue().toString());
                    liveinheret.setChat(snapshot.child("chat").getValue().toString());
                    liveinheret.setMap(snapshot.child("map").getValue().toString());
                    liveinheret.setScoretable(snapshot.child("scoretable").getValue().toString());
                    list.add(liveinheret);
                }
                r1.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
                matchesvalorantadapter liveadapter=new matchesvalorantadapter(list,getActivity());
                r1.setAdapter(liveadapter);
                liveadapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        return view;
    }
}
