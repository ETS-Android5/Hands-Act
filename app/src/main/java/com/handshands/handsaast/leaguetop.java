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
import android.widget.ImageView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;


public class leaguetop extends Fragment {
    RecyclerView r1,r2,r3,r4,r5;
    ImageView img1 ,img2 ,img3, img4,img5;
    DatabaseReference ref1,ref2,ref3,ref4,ref5;
    ArrayList<topkeeperinfo> list,list1,list2,list3,list4;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_leaguetop, container, false);
        calling(v);
        list=new ArrayList<>();
        list1=new ArrayList<>();
        list2=new ArrayList<>();
        list3=new ArrayList<>();
        list4=new ArrayList<>();
        r1.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        r2.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        r3.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        r4.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        ref1= FirebaseDatabase.getInstance().getReference("topleague").child("top");
        ref1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list1.clear();
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                    topkeeperinfo topinformation=new topkeeperinfo();
                    topinformation.setName(snapshot.child("name").getValue().toString());
                    topinformation.setPos(snapshot.child("position").getValue().toString());
                    topinformation.setCleansheet(snapshot.child("kills").getValue().toString());
                    topinformation.setSave(snapshot.child("assists").getValue().toString());
                    topinformation.setImage(snapshot.child("image").getValue().toString());
                    list1.add(topinformation);
                    Collections.sort(list1);
                }
                topkeeperadapter topadapter=new topkeeperadapter(list1,getActivity());
                r1.setAdapter(topadapter);
                topadapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        ref2= FirebaseDatabase.getInstance().getReference("topleague").child("mid");
        ref2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list2.clear();
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                    topkeeperinfo topinformation=new topkeeperinfo();
                    topinformation.setName(snapshot.child("name").getValue().toString());
                    topinformation.setPos(snapshot.child("position").getValue().toString());
                    topinformation.setCleansheet(snapshot.child("kills").getValue().toString());
                    topinformation.setSave(snapshot.child("assists").getValue().toString());
                    topinformation.setImage(snapshot.child("image").getValue().toString());
                    list2.add(topinformation);
                    Collections.sort(list2);
                }
                topkeeperadapter topadapter=new topkeeperadapter(list2,getActivity());
                r2.setAdapter(topadapter);
                topadapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        ref3= FirebaseDatabase.getInstance().getReference("topleague").child("jungle");
        ref3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list3.clear();
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                    topkeeperinfo topinformation=new topkeeperinfo();
                    topinformation.setName(snapshot.child("name").getValue().toString());
                    topinformation.setPos(snapshot.child("position").getValue().toString());
                    topinformation.setCleansheet(snapshot.child("kills").getValue().toString());
                    topinformation.setSave(snapshot.child("assists").getValue().toString());
                    topinformation.setImage(snapshot.child("image").getValue().toString());
                    list3.add(topinformation);
                    Collections.sort(list3);
                }
                topkeeperadapter topadapter=new topkeeperadapter(list3,getActivity());
                r3.setAdapter(topadapter);
                topadapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        ref4= FirebaseDatabase.getInstance().getReference("topleague").child("adc");
        ref4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list.clear();
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                    topkeeperinfo topinformation=new topkeeperinfo();
                    topinformation.setName(snapshot.child("name").getValue().toString());
                    topinformation.setPos(snapshot.child("position").getValue().toString());
                    topinformation.setCleansheet(snapshot.child("kills").getValue().toString());
                    topinformation.setSave(snapshot.child("assists").getValue().toString());
                    topinformation.setImage(snapshot.child("image").getValue().toString());
                    list.add(topinformation);
                    Collections.sort(list);
                }
                topkeeperadapter topadapter=new topkeeperadapter(list,getActivity());
                r4.setAdapter(topadapter);
                topadapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        ref5= FirebaseDatabase.getInstance().getReference("topleague").child("sup");
        ref5.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list4.clear();
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                    topkeeperinfo topinformation=new topkeeperinfo();
                    topinformation.setName(snapshot.child("name").getValue().toString());
                    topinformation.setPos(snapshot.child("position").getValue().toString());
                    topinformation.setCleansheet(snapshot.child("assists").getValue().toString());
                    topinformation.setSave(snapshot.child("kills").getValue().toString());
                    topinformation.setImage(snapshot.child("image").getValue().toString());
                    list4.add(topinformation);
                    Collections.sort(list4);
                }
                topkeeperadapter topadapter=new topkeeperadapter(list4,getActivity());
                r5.setAdapter(topadapter);
                topadapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),showmore5.class));
                getActivity().overridePendingTransition(R.anim.slideinup,R.anim.slideoutup);

            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),showmore6.class));
                getActivity().overridePendingTransition(R.anim.slideinup,R.anim.slideoutup);

            }
        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),showmore7.class));
                getActivity().overridePendingTransition(R.anim.slideinup,R.anim.slideoutup);

            }
        });
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),showmore8.class));
                getActivity().overridePendingTransition(R.anim.slideinup,R.anim.slideoutup);

            }
        });
        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),showmore9.class));
                getActivity().overridePendingTransition(R.anim.slideinup,R.anim.slideoutup);

            }
        });
        return v;
    }

    private void calling(View v) {
        r1=v.findViewById(R.id.topg);
        r2=v.findViewById(R.id.topas);
        r3=v.findViewById(R.id.topcl);
        r4=v.findViewById(R.id.topw);
        r5=v.findViewById(R.id.tops);
        img1=v.findViewById(R.id.more1);
        img2=v.findViewById(R.id.more2);
        img3=v.findViewById(R.id.more3);
        img4=v.findViewById(R.id.more4);
        img5=v.findViewById(R.id.more5);
    }

}