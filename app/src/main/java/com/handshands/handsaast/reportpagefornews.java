package com.handshands.handsaast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.client.Firebase;
import com.github.chrisbanes.photoview.PhotoView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class reportpagefornews extends AppCompatActivity {
PhotoView imageView;
TextView textView,t1,t2;
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reportpagefornews);
        Firebase.setAndroidContext(this);
        imageView=findViewById(R.id.secimg);
        textView=findViewById(R.id.report);
    t1=findViewById(R.id.datepage);
    t2=findViewById(R.id.titlepage);
    Intent myintent=getIntent();
    String d= myintent.getStringExtra("date");
    String t= myintent.getStringExtra("title");
    String img= myintent.getStringExtra("image");
    String report=myintent.getStringExtra("re");
    Picasso.get().load(img).into(imageView);
textView.setText(report);
t1.setText(d);
t2.setText(t);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slideinleft,R.anim.slideoutright);
    }
}
