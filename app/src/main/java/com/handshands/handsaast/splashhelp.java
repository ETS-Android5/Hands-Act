package com.handshands.handsaast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.VideoView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class splashhelp extends AppCompatActivity {
VideoView videoView;
DatabaseReference reference;
ArrayList<checkuser> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashhelp);
        videoView=findViewById(R.id.splashhelp);
        list=new ArrayList<>();
        videoView.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.video);
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
reference=FirebaseDatabase.getInstance().getReference("help").child("people");
reference.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot snapshot) {
        list.clear();
        for(DataSnapshot dataSnapshot:snapshot.getChildren()){
            checkuser checkuser=new checkuser();
            checkuser.setUid(dataSnapshot.child("uid").getValue().toString());
            checkuser.setType(dataSnapshot.child("type").getValue().toString());
            checkuser.setEmail(dataSnapshot.child("email").getValue().toString());
            checkuser.setDescription(dataSnapshot.child("description").getValue().toString());
            checkuser.setPhonenumber(dataSnapshot.child("phonenumber").getValue().toString());
list.add(checkuser);
if(FirebaseAuth.getInstance().getCurrentUser().getUid().toString().equals(checkuser.getUid().toString())&&checkuser.getType().toString().equals("Volunteer")){
    startActivity(new Intent(splashhelp.this,volunteers.class));}
    else if(FirebaseAuth.getInstance().getCurrentUser().getUid().toString().equals(checkuser.getUid().toString())&&checkuser.getType().toString().equals("Non Volunteer")){
    startActivity(new Intent(splashhelp.this,nonvolunteers.class));
}
    else {
    startActivity(new Intent(splashhelp.this,choosepage.class));

}

        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError error) {

    }
});
            }
        });
        videoView.start();
    }
}