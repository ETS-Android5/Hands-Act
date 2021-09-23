package com.handshands.handsaast;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;


/**
 * A simple {@link Fragment} subclass.
 */
public class groupafragment extends Fragment {
    TextView group1,group2,group3,group4,group5,group6,group7,group8,
   point1,point2,point3,point4,point5,point6,point7,point8,
     play1,play2,play3,play4,play5,play6,play7,play8,
     plus1,plus2,plus3,plus4,plus5,plus6,plus7,plus8,
    win1,win2,win3,win4,win5,win6,win7,win8;
 View view;
 RecyclerView recyclerView,r2,r3,r4,r5,r6,r7,r8;
FirebaseDatabase database,d2;
DatabaseReference reference,ref2,ref3,ref4,ref5,ref6,ref7,ref8,ref9,ref10,ref11,ref12,ref13,ref14,ref15,ref16;
ArrayList<groupainheret>list,list2,list3,list4,list5,list6,list7,list8;
    public groupafragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_groupafragment, container, false);
        recyclerView=view.findViewById(R.id.groupare);
        r2=view.findViewById(R.id.groupb);
        r3=view.findViewById(R.id.groupc);
        r4=view.findViewById(R.id.groupd);
        r5=view.findViewById(R.id.groupe);
        r6=view.findViewById(R.id.groupf);
        r7=view.findViewById(R.id.groupg);
        r8=view.findViewById(R.id.grouph);
        tool();
        ref9=FirebaseDatabase.getInstance().getReference().child("tools");
        ref9.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()){
                    String p = ds.child("group").getValue().toString();
                    String g = ds.child("play").getValue().toString();
                    String fa = ds.child("fa").getValue().toString();
                    String pl = ds.child("plus").getValue().toString();
                    String po = ds.child("points").getValue().toString();
                    group1.setText(p);
                    play1.setText(g);
                    win1.setText(fa);
                    plus1.setText(pl);
                    point1.setText(po);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        ref10=FirebaseDatabase.getInstance().getReference().child("tools2");
        ref10.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()){
                    String p = ds.child("group").getValue().toString();
                    String g = ds.child("play").getValue().toString();
                    String fa = ds.child("fa").getValue().toString();
                    String pl = ds.child("plus").getValue().toString();
                    String po = ds.child("points").getValue().toString();
                    group2.setText(p);
                    play2.setText(g);
                    win2.setText(fa);
                    plus2.setText(pl);
                    point2.setText(po);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        ref11=FirebaseDatabase.getInstance().getReference().child("tools3");
        ref11.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()){
                    String p = ds.child("group").getValue().toString();
                    String g = ds.child("play").getValue().toString();
                    String fa = ds.child("fa").getValue().toString();
                    String pl = ds.child("plus").getValue().toString();
                    String po = ds.child("points").getValue().toString();
                    group3.setText(p);
                    play3.setText(g);
                    win3.setText(fa);
                    plus3.setText(pl);
                    point3.setText(po);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        ref12=FirebaseDatabase.getInstance().getReference().child("tools4");
        ref12.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()){
                    String p = ds.child("group").getValue().toString();
                    String g = ds.child("play").getValue().toString();
                    String fa = ds.child("fa").getValue().toString();
                    String pl = ds.child("plus").getValue().toString();
                    String po = ds.child("points").getValue().toString();
                    group4.setText(p);
                    play4.setText(g);
                    win4.setText(fa);
                    plus4.setText(pl);
                    point4.setText(po);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        ref13=FirebaseDatabase.getInstance().getReference().child("tools5");
        ref13.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()){
                    String p = ds.child("group").getValue().toString();
                    String g = ds.child("play").getValue().toString();
                    String fa = ds.child("fa").getValue().toString();
                    String pl = ds.child("plus").getValue().toString();
                    String po = ds.child("points").getValue().toString();
                    group5.setText(p);
                    play5.setText(g);
                    win5.setText(fa);
                    plus5.setText(pl);
                    point5.setText(po);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        ref14=FirebaseDatabase.getInstance().getReference().child("tools6");
        ref14.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()){
                    String p = ds.child("group").getValue().toString();
                    String g = ds.child("play").getValue().toString();
                    String fa = ds.child("fa").getValue().toString();
                    String pl = ds.child("plus").getValue().toString();
                    String po = ds.child("points").getValue().toString();
                    group6.setText(p);
                    play6.setText(g);
                    win6.setText(fa);
                    plus6.setText(pl);
                    point6.setText(po);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        ref15=FirebaseDatabase.getInstance().getReference().child("tools7");
        ref15.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()){
                    String p = ds.child("group").getValue().toString();
                    String g = ds.child("play").getValue().toString();
                    String fa = ds.child("fa").getValue().toString();
                    String pl = ds.child("plus").getValue().toString();
                    String po = ds.child("points").getValue().toString();
                    group7.setText(p);
                    play7.setText(g);
                    win7.setText(fa);
                    plus7.setText(pl);
                    point7.setText(po);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        ref16=FirebaseDatabase.getInstance().getReference().child("tools8");
        ref16.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()){
                    String p = ds.child("group").getValue().toString();
                    String g = ds.child("play").getValue().toString();
                    String fa = ds.child("fa").getValue().toString();
                    String pl = ds.child("plus").getValue().toString();
                    String po = ds.child("points").getValue().toString();
                    group8.setText(p);
                    play8.setText(g);
                    win8.setText(fa);
                    plus8.setText(pl);
                    point8.setText(po);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        r2.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        r3.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        r4.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        r5.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        r6.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        r7.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        r8.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        list=new ArrayList<>();
        list2=new ArrayList<>();
        list3=new ArrayList<>();
        list4=new ArrayList<>();
        list5=new ArrayList<>();
        list6=new ArrayList<>();
        list7=new ArrayList<>();
        list8=new ArrayList<>();
      database=FirebaseDatabase.getInstance();
reference=database.getReference("groups");
        Query query=reference.child("groupa");
     query.addValueEventListener(new ValueEventListener() {
         @Override
         public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
             list.clear();
             for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                 groupainheret groupainheret=new groupainheret();
                 groupainheret.setTeam(snapshot.child("team").getValue().toString());
                 groupainheret.setPlayed(snapshot.child("played").getValue().toString());
                 groupainheret.setWinlose(snapshot.child("winlose").getValue().toString());
                 groupainheret.setCalculation(snapshot.child("calculation").getValue().toString());
                 groupainheret.setPoints(snapshot.child("points").getValue().toString());
                 groupainheret.setImage(snapshot.child("image").getValue().toString());
                 list.add(groupainheret);
                 Collections.sort(list);
             }
             groupaadapter  groupaadapter=new groupaadapter(list,getActivity());
             recyclerView.setAdapter(groupaadapter);


         }

         @Override
         public void onCancelled(@NonNull DatabaseError databaseError) {
         }
     });
     d2=FirebaseDatabase.getInstance();
     ref2=d2.getReference("groups");
        Query query2=reference.child("groupb");
        query2.addValueEventListener(new ValueEventListener() {
         @Override
         public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
             list2.clear();
             for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                 groupainheret groupainheret=new groupainheret();
                 groupainheret.setTeam(snapshot.child("team").getValue().toString());
                 groupainheret.setPlayed(snapshot.child("played").getValue().toString());
                 groupainheret.setWinlose(snapshot.child("winlose").getValue().toString());
                 groupainheret.setCalculation(snapshot.child("calculation").getValue().toString());
                 groupainheret.setPoints(snapshot.child("points").getValue().toString());
                 groupainheret.setImage(snapshot.child("image").getValue().toString());
                 list2.add(groupainheret);
                 Collections.sort(list2);
             }
             groupaadapter  groupaadapter=new groupaadapter(list2,getActivity());
             r2.setAdapter(groupaadapter);
         }

         @Override
         public void onCancelled(@NonNull DatabaseError databaseError) {

         }
     });
     ref3=FirebaseDatabase.getInstance().getReference("groups").child("groupc");
     ref3.addValueEventListener(new ValueEventListener() {
         @Override
         public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
             list3.clear();
             for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                 groupainheret groupainheret=new groupainheret();
                 groupainheret.setTeam(snapshot.child("team").getValue().toString());
                 groupainheret.setPlayed(snapshot.child("played").getValue().toString());
                 groupainheret.setWinlose(snapshot.child("winlose").getValue().toString());
                 groupainheret.setCalculation(snapshot.child("calculation").getValue().toString());
                 groupainheret.setPoints(snapshot.child("points").getValue().toString());
                 groupainheret.setImage(snapshot.child("image").getValue().toString());
                 list3.add(groupainheret);
                 Collections.sort(list3);

             }
             groupaadapter  groupaadapter=new groupaadapter(list3,getActivity());
             r3.setAdapter(groupaadapter);
         }

         @Override
         public void onCancelled(@NonNull DatabaseError databaseError) {

         }
     });
        ref4=FirebaseDatabase.getInstance().getReference("groups").child("groupd");
        ref4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list4.clear();
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                    groupainheret groupainheret=new groupainheret();
                    groupainheret.setTeam(snapshot.child("team").getValue().toString());
                    groupainheret.setPlayed(snapshot.child("played").getValue().toString());
                    groupainheret.setWinlose(snapshot.child("winlose").getValue().toString());
                    groupainheret.setCalculation(snapshot.child("calculation").getValue().toString());
                    groupainheret.setPoints(snapshot.child("points").getValue().toString());
                    groupainheret.setImage(snapshot.child("image").getValue().toString());
                    list4.add(groupainheret);
                    Collections.sort(list4);

                }
                groupaadapter  groupaadapter=new groupaadapter(list4,getActivity());
                r4.setAdapter(groupaadapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        ref5=FirebaseDatabase.getInstance().getReference("groups").child("groupe");
        ref5.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list5.clear();
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                    groupainheret groupainheret=new groupainheret();
                    groupainheret.setTeam(snapshot.child("team").getValue().toString());
                    groupainheret.setPlayed(snapshot.child("played").getValue().toString());
                    groupainheret.setWinlose(snapshot.child("winlose").getValue().toString());
                    groupainheret.setCalculation(snapshot.child("calculation").getValue().toString());
                    groupainheret.setPoints(snapshot.child("points").getValue().toString());
                    groupainheret.setImage(snapshot.child("image").getValue().toString());
                    list5.add(groupainheret);
                    Collections.sort(list5);

                }
                groupaadapter  groupaadapter=new groupaadapter(list5,getActivity());
                r5.setAdapter(groupaadapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        ref6=FirebaseDatabase.getInstance().getReference("groups").child("groupf");
        ref6.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list6.clear();
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                    groupainheret groupainheret=new groupainheret();
                    groupainheret.setTeam(snapshot.child("team").getValue().toString());
                    groupainheret.setPlayed(snapshot.child("played").getValue().toString());
                    groupainheret.setWinlose(snapshot.child("winlose").getValue().toString());
                    groupainheret.setCalculation(snapshot.child("calculation").getValue().toString());
                    groupainheret.setPoints(snapshot.child("points").getValue().toString());
                    groupainheret.setImage(snapshot.child("image").getValue().toString());
                    list6.add(groupainheret);
                    Collections.sort(list6);

                }
                groupaadapter  groupaadapter=new groupaadapter(list6,getActivity());
                r6.setAdapter(groupaadapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        ref7=FirebaseDatabase.getInstance().getReference("groups").child("groupg");
        ref7.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list7.clear();
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                    groupainheret groupainheret=new groupainheret();
                    groupainheret.setTeam(snapshot.child("team").getValue().toString());
                    groupainheret.setPlayed(snapshot.child("played").getValue().toString());
                    groupainheret.setWinlose(snapshot.child("winlose").getValue().toString());
                    groupainheret.setCalculation(snapshot.child("calculation").getValue().toString());
                    groupainheret.setPoints(snapshot.child("points").getValue().toString());
                    groupainheret.setImage(snapshot.child("image").getValue().toString());
                    list7.add(groupainheret);
                    Collections.sort(list7);

                }
                groupaadapter  groupaadapter=new groupaadapter(list7,getActivity());
                r7.setAdapter(groupaadapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        ref8=FirebaseDatabase.getInstance().getReference("groups").child("grouph");
        ref8.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list8.clear();
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                    groupainheret groupainheret=new groupainheret();
                    groupainheret.setTeam(snapshot.child("team").getValue().toString());
                    groupainheret.setPlayed(snapshot.child("played").getValue().toString());
                    groupainheret.setWinlose(snapshot.child("winlose").getValue().toString());
                    groupainheret.setCalculation(snapshot.child("calculation").getValue().toString());
                    groupainheret.setPoints(snapshot.child("points").getValue().toString());
                    groupainheret.setImage(snapshot.child("image").getValue().toString());
                    list8.add(groupainheret);
                    Collections.sort(list8);

                }
                groupaadapter  groupaadapter=new groupaadapter(list8,getActivity());
                r8.setAdapter(groupaadapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    return view;}
    private void tool() {
        group1=view.findViewById(R.id.group1);
        point1=view.findViewById(R.id.pts1);
        play1=view.findViewById(R.id.p1);
        win1=view.findViewById(R.id.fa1);
        plus1=view.findViewById(R.id.plus1);
        group2=view.findViewById(R.id.group2);
        point2=view.findViewById(R.id.pts2);
        play2=view.findViewById(R.id.p2);
        win2=view.findViewById(R.id.fa2);
        plus2=view.findViewById(R.id.plus2);
        group3=view.findViewById(R.id.group3);
        point3=view.findViewById(R.id.pts3);
        play3=view.findViewById(R.id.p3);
        win3=view.findViewById(R.id.fa3);
        plus3=view.findViewById(R.id.plus3);
        group4=view.findViewById(R.id.group4);
        point4=view.findViewById(R.id.pts4);
        play4=view.findViewById(R.id.p4);
        win4=view.findViewById(R.id.fa4);
        plus4=view.findViewById(R.id.plus4);
        group5=view.findViewById(R.id.group5);
        point5=view.findViewById(R.id.pts5);
        play5=view.findViewById(R.id.p5);
        win5=view.findViewById(R.id.fa5);
        plus5=view.findViewById(R.id.plus5);
        group6=view.findViewById(R.id.group6);
        point6=view.findViewById(R.id.pts6);
        play6=view.findViewById(R.id.p6);
        win6=view.findViewById(R.id.fa6);
        plus6=view.findViewById(R.id.plus6);
        group7=view.findViewById(R.id.group7);
        point7=view.findViewById(R.id.pts7);
        play7=view.findViewById(R.id.p7);
        win7=view.findViewById(R.id.fa7);
        plus7=view.findViewById(R.id.plus7);
        group8=view.findViewById(R.id.group8);
        point8=view.findViewById(R.id.pts8);
        play8=view.findViewById(R.id.p8);
        win8=view.findViewById(R.id.fa8);
        plus8=view.findViewById(R.id.plus8);
    }
}
