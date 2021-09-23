package com.handshands.handsaast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class choosegame extends AppCompatActivity {
    CardView football, valo, pubg,league;
    DatabaseReference reference3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choosegame);
        calling();
        football.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reference3 = FirebaseDatabase.getInstance().getReference("changes").child("accessfootball");

                reference3.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String id = snapshot.child("check").getValue().toString();
                        String message = snapshot.child("message").getValue().toString();
                        String title = snapshot.child("title").getValue().toString();
                        if (id.equals("off")) {
                            showdialog3(message, title);
                        } else {
                            startActivity(new Intent(choosegame.this, football.class));
                            overridePendingTransition(R.anim.slideinright, R.anim.slideoutleft);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }
        });
        valo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(choosegame.this,valorant.class));
                overridePendingTransition(R.anim.slideinright, R.anim.slideoutleft);

            }
        });
        league.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(choosegame.this,leagueoflegends.class));
                overridePendingTransition(R.anim.slideinright, R.anim.slideoutleft);

            }
        });
    }


    private void calling() {
        league=findViewById(R.id.legaueoflegends);
        football = findViewById(R.id.second);
        valo = findViewById(R.id.first);
        pubg = findViewById(R.id.third);
    }

    private void showdialog3(String p, String t) {
        final AlertDialog alertDialog3 = new AlertDialog.Builder(this).setIcon(R.drawable.thumbnail2).setTitle(t).setMessage(p).setPositiveButton("OK", null).show();
        alertDialog3.setCancelable(true);
        Button button = alertDialog3.getButton(AlertDialog.BUTTON_POSITIVE);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog3.dismiss();
            }
        });
    }

}