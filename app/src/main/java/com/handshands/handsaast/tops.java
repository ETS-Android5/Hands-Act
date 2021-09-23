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


/**
 * A simple {@link Fragment} subclass.
 */
public class tops extends Fragment {
RecyclerView r1,r2,r3,r4;
ImageView img1 ,img2 ,img3, img4;
DatabaseReference ref1,ref2,ref3,ref4;
View v;
ArrayList<topinformation> list1,list2,list3;
ArrayList<topkeeperinfo> list;
    public tops() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.fragment_tops, container, false);
calling();
list=new ArrayList<>();
        list1=new ArrayList<>();
        list2=new ArrayList<>();
        list3=new ArrayList<>();
        r1.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        r2.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        r3.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        r4.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
ref1= FirebaseDatabase.getInstance().getReference("top").child("goals");
ref1.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        list1.clear();
        for(DataSnapshot snapshot:dataSnapshot.getChildren()){
            topinformation topinformation=new topinformation();
            topinformation.setName(snapshot.child("name").getValue().toString());
            topinformation.setPos(snapshot.child("pos").getValue().toString());
            topinformation.setPoints(snapshot.child("points").getValue().toString());
            topinformation.setImage(snapshot.child("image").getValue().toString());
list1.add(topinformation);
            Collections.sort(list1);
        }
        topadapter topadapter=new topadapter(list1,getActivity());
        r1.setAdapter(topadapter);
        topadapter.notifyDataSetChanged();
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }
});
        ref2= FirebaseDatabase.getInstance().getReference("top").child("assists");
        ref2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list2.clear();
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                    topinformation topinformation=new topinformation();
                    topinformation.setName(snapshot.child("name").getValue().toString());
                    topinformation.setPos(snapshot.child("pos").getValue().toString());
                    topinformation.setPoints(snapshot.child("points").getValue().toString());
                    topinformation.setImage(snapshot.child("image").getValue().toString());
                    list2.add(topinformation);
                    Collections.sort(list2);
                }
                topadapter topadapter=new topadapter(list2,getActivity());
                r2.setAdapter(topadapter);
                topadapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        ref3= FirebaseDatabase.getInstance().getReference("top").child("wins");
        ref3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list3.clear();
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                    topinformation topinformation=new topinformation();
                    topinformation.setName(snapshot.child("name").getValue().toString());
                    topinformation.setPos(snapshot.child("pos").getValue().toString());
                    topinformation.setPoints(snapshot.child("points").getValue().toString());
                    topinformation.setImage(snapshot.child("image").getValue().toString());
                    list3.add(topinformation);
                    Collections.sort(list3);
                }
                topadapter topadapter=new topadapter(list3,getActivity());
                r4.setAdapter(topadapter);
                topadapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        ref4= FirebaseDatabase.getInstance().getReference("top").child("cleansheets");
        ref4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list.clear();
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                    topkeeperinfo topkeeperinfo=new topkeeperinfo();
                    topkeeperinfo.setName(snapshot.child("name").getValue().toString());
                 topkeeperinfo.setPos(snapshot.child("pos").getValue().toString());
                    topkeeperinfo.setCleansheet(snapshot.child("cleansheet").getValue().toString());
                    topkeeperinfo.setImage(snapshot.child("image").getValue().toString());
                    topkeeperinfo.setSave(snapshot.child("save").getValue().toString());
                    list.add(topkeeperinfo);
                    Collections.sort(list);
                }
topkeeperadapter topadapter=new topkeeperadapter(list,getActivity());
            r3.setAdapter(topadapter);
                topadapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
img1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity(new Intent(getActivity(),showmore1.class));
        getActivity().overridePendingTransition(R.anim.slideinup,R.anim.slideoutup);

    }
});
img2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity(new Intent(getActivity(),showmore2.class));
        getActivity().overridePendingTransition(R.anim.slideinup,R.anim.slideoutup);

    }
});
img3.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity(new Intent(getActivity(),showmore3.class));
        getActivity().overridePendingTransition(R.anim.slideinup,R.anim.slideoutup);

    }
});
img4.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity(new Intent(getActivity(),showmore4.class));
        getActivity().overridePendingTransition(R.anim.slideinup,R.anim.slideoutup);

    }
});
        return v;
    }

    private void calling() {
        r1=v.findViewById(R.id.topg);
        r2=v.findViewById(R.id.topas);
        r3=v.findViewById(R.id.topcl);
        r4=v.findViewById(R.id.topw);
        img1=v.findViewById(R.id.more1);
        img2=v.findViewById(R.id.more2);
        img3=v.findViewById(R.id.more3);
        img4=v.findViewById(R.id.more4);
    }

}
