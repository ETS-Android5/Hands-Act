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

public class splash_screen extends AppCompatActivity {
    VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        videoView=findViewById(R.id.myvideo);
        videoView.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.video);
videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {

        if (FirebaseAuth.getInstance().getCurrentUser() != null) {

                            startActivity(new Intent(splash_screen.this, MainActivity.class));
                            overridePendingTransition(R.anim.slideinright, R.anim.slideoutleft);
        }else {
            startActivity(new Intent(splash_screen.this, welcomeactivity.class));
            overridePendingTransition(R.anim.slideinright, R.anim.slideoutleft);
        }
    }
});
videoView.start();
    }
}