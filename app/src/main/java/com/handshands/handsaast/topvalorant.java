package com.handshands.handsaast;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;


public class topvalorant extends Fragment {
    RecyclerView r1;
    DatabaseReference ref1;
    ArrayList<topvalorantmodel>list;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_topvalorant, container, false);
        r1=view.findViewById(R.id.topg);
        list=new ArrayList<>();
        r1.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        ref1= FirebaseDatabase.getInstance().getReference("topvalorant").child("kills");
        ref1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list.clear();
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                    topvalorantmodel topinformation=new topvalorantmodel();
                    topinformation.setName(snapshot.child("name").getValue().toString());
                    topinformation.setTeam(snapshot.child("team").getValue().toString());
                    topinformation.setPoints(snapshot.child("points").getValue().toString());
                    topinformation.setImage(snapshot.child("image").getValue().toString());
                    list.add(topinformation);
                    Collections.sort(list);
                }
                topvalorantadapter topadapter=new topvalorantadapter(list,getActivity());
                r1.setAdapter(topadapter);
                topadapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



        return view;

    }
}