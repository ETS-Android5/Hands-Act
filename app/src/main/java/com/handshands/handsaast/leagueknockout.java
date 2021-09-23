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


public class leagueknockout extends Fragment {


    DatabaseReference reference,reference2;
    RecyclerView r1;
    ArrayList<valorantknockoutmodel> list;
    TextView textView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_leagueknockout, container, false);
        r1=view.findViewById(R.id.knockouts);
        textView=view.findViewById(R.id.titleknockout);
        r1.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        list=new ArrayList<>();
        reference2= FirebaseDatabase.getInstance().getReference("leagueknockout");
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
        reference=FirebaseDatabase.getInstance().getReference("leagueknockout").child("teams");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list.clear();
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                    valorantknockoutmodel knockoutinheret=new valorantknockoutmodel();
                    knockoutinheret.setFirstimage(dataSnapshot.child("firstimage").getValue().toString());
                    knockoutinheret.setFirstteam(dataSnapshot.child("firstteam").getValue().toString());
                    knockoutinheret.setResult(dataSnapshot.child("result").getValue().toString());
                    knockoutinheret.setSecondimage(dataSnapshot.child("secondimage").getValue().toString());
                    knockoutinheret.setSecondteam(dataSnapshot.child("secondteam").getValue().toString());
                    list.add(knockoutinheret);
                }
                valorantknockoutadapter knockoutadapter=new valorantknockoutadapter(list,getActivity());
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