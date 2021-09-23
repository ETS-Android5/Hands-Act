package com.handshands.handsaast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class nonvolunteers extends AppCompatActivity {
Button send,delete;
DatabaseReference reference1, reference2,reference3;
ArrayList<checkuser> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nonvolunteers);
        calling();
        list=new ArrayList<>();
   send.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {
           reference1= FirebaseDatabase.getInstance().getReference("help").child("people");
           reference1.addValueEventListener(new ValueEventListener() {
               @Override
               public void onDataChange(@NonNull DataSnapshot snapshot) {
list.clear();
for (DataSnapshot dataSnapshot:snapshot.getChildren()){
    checkuser checkuser=new checkuser();
    checkuser.setUid(dataSnapshot.child("uid").getValue().toString());
    checkuser.setEmail(dataSnapshot.child("email").getValue().toString());
    checkuser.setPhonenumber(dataSnapshot.child("phonenumber").getValue().toString());
    checkuser.setType(dataSnapshot.child("type").getValue().toString());
    checkuser.setDescription(dataSnapshot.child("description").getValue().toString());
list.add(checkuser);
if(FirebaseAuth.getInstance().getCurrentUser().getUid().equals(checkuser.getUid().toString())&&checkuser.getType().equals("Non Volunteer")){
    reference2=FirebaseDatabase.getInstance().getReference("help").child("requests");
    checkuser checkuser1=new checkuser(checkuser.getDescription(),checkuser.getEmail(),checkuser.getType(),checkuser.getUid(),checkuser.getPhonenumber());
reference2.child(FirebaseAuth.getInstance().getCurrentUser().getUid().toString()).setValue(checkuser1);
    Toast.makeText(nonvolunteers.this, "Successful Request, Someone will call you soon !❤", Toast.LENGTH_SHORT).show();
}
}
               }

               @Override
               public void onCancelled(@NonNull DatabaseError error) {

               }
           });
       }
   });
   delete.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {
           reference3=FirebaseDatabase.getInstance().getReference("help").child("requests");
           reference3.child(FirebaseAuth.getInstance().getCurrentUser().getUid().toString()).removeValue();
           Toast.makeText(nonvolunteers.this, "Your request is deleted, Hope we can help you as possible !❤ ", Toast.LENGTH_SHORT).show();

       }
   });
    }

    private void calling() {
        send=findViewById(R.id.sendreq);
        delete=findViewById(R.id.endreq);
    }
}