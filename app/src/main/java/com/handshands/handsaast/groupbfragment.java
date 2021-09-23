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

import com.github.chrisbanes.photoview.PhotoView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class groupbfragment extends Fragment {
DatabaseReference reference,reference2;
RecyclerView r1;
ArrayList<knockoutinheret>list;
TextView textView;
    public groupbfragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_groupbfragment, container, false);
r1=view.findViewById(R.id.knockouts);
textView=view.findViewById(R.id.titleknockout);
r1.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        list=new ArrayList<>();
        reference2=FirebaseDatabase.getInstance().getReference("knockout");
        reference2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String s=snapshot.child("title").getValue().toString();
                textView.setText(s);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
reference=FirebaseDatabase.getInstance().getReference("knockout").child("teams");
reference.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot snapshot) {
        list.clear();
        for (DataSnapshot dataSnapshot:snapshot.getChildren()){
            knockoutinheret knockoutinheret=new knockoutinheret();
       knockoutinheret.setFirstimage(dataSnapshot.child("firstimage").getValue().toString());
       knockoutinheret.setFirstteam(dataSnapshot.child("firstteam").getValue().toString());
       knockoutinheret.setResult(dataSnapshot.child("result").getValue().toString());
       knockoutinheret.setSecondimage(dataSnapshot.child("secondimage").getValue().toString());
       knockoutinheret.setSecondteam(dataSnapshot.child("secondteam").getValue().toString());
            list.add(knockoutinheret);
        }
        knockoutadapter knockoutadapter=new knockoutadapter(list,getActivity());
        r1.setAdapter(knockoutadapter);
        knockoutadapter.notifyDataSetChanged();
    }
    @Override
    public void onCancelled(@NonNull DatabaseError error) {

    }
});
        return view;
    }
}
