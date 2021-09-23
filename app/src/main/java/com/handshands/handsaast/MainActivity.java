package com.handshands.handsaast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;
import com.khoiron.actionsheets.ActionSheet;
import com.khoiron.actionsheets.callback.ActionSheetCallBack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    CardView card1;
    CardView card2;
    CardView card3;
    CardView card4;
    CardView card5;
    CardView card6;
    CardView card7;
    CardView card8;
    FirebaseRemoteConfig remoteConfig;
    DatabaseReference reference2,reference3,reference4,getReference2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calling();
        ArrayList<String> data=new ArrayList<>();
FirebaseDatabase.getInstance().getReference().keepSynced(true);
        data.add("Facebook");
        data.add("Instagram");
        data.add("Youtube");
        card8.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
new ActionSheet(MainActivity.this,data)
        .setTitle("Follow us in social media !")
        .setCancelTitle("Cancel")
        .setColorSelected(Color.BLUE)
        .setColorTitle(Color.LTGRAY)
        .setColorTitleCancel(Color.RED)
        .setColorData(Color.BLUE)
        .create(new ActionSheetCallBack() {
            @Override
            public void data(String s, int i) {
switch (i){
    case 0:
        startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.facebook.com/HandsAct")));
        overridePendingTransition(R.anim.slideinright,R.anim.slideoutleft);
        break;
    case 1:
        startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.instagram.com/handsact/")));
        overridePendingTransition(R.anim.slideinright,R.anim.slideoutleft);
        break;
    case 2:
        startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.youtube.com/user/HandsAct")));
        overridePendingTransition(R.anim.slideinright,R.anim.slideoutleft);
        break;
}
            }
        });
    }
});
        card6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FirebaseAuth.getInstance().signOut();
                                startActivity(new Intent(MainActivity.this,welcomeactivity.class));
                overridePendingTransition(R.anim.slideinleft,R.anim.slideoutright);
                         }
        });
        card1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(MainActivity.this,events.class));
            overridePendingTransition(R.anim.slideinright,R.anim.slideoutleft);
        }
    });
        card2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(MainActivity.this,choosegame.class));
            overridePendingTransition(R.anim.slideinright,R.anim.slideoutleft);
        }
    });
        card3.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
startActivity(new Intent(MainActivity.this,news.class));
            overridePendingTransition(R.anim.slideinright,R.anim.slideoutleft);

        }
    });
        card4.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            reference2=FirebaseDatabase.getInstance().getReference("changes").child("accessstudy");
            reference2.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    String id=snapshot.child("check").getValue().toString();
                    String message=snapshot.child("message").getValue().toString();
                    String title=snapshot.child("title").getValue().toString();
                    if (id.equals("off")) {
                        showthedialog2(message,title);
                    }
                    else {
                        startActivity(new Intent(MainActivity.this,Studying.class));
                        overridePendingTransition(R.anim.slideinright,R.anim.slideoutleft);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }

            });

        }
    });
        card5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reference4=FirebaseDatabase.getInstance().getReference("changes").child("accessoffer");
                reference4.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String id=snapshot.child("check").getValue().toString();
                        String message=snapshot.child("message").getValue().toString();
                        String title=snapshot.child("title").getValue().toString();
                        if (id.equals("off")) {
                            showdialog4(message,title);
                        }
                        else {
                            startActivity(new Intent(MainActivity.this,offers.class));
                            overridePendingTransition(R.anim.slideinright,R.anim.slideoutleft);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }
        });
        HashMap<String,Object>defaults=new HashMap<>();
        defaults.put("new_version_code",String.valueOf(getversioncode()));
        remoteConfig=FirebaseRemoteConfig.getInstance();
        FirebaseRemoteConfigSettings configSettings=new FirebaseRemoteConfigSettings.Builder().setMinimumFetchIntervalInSeconds(10).build();
        remoteConfig.setConfigSettingsAsync(configSettings);
        remoteConfig.setDefaultsAsync(defaults);
        remoteConfig.fetchAndActivate().addOnCompleteListener(this, new OnCompleteListener<Boolean>() {
            @Override
            public void onComplete(@NonNull Task<Boolean> task) {
                    if(task.isSuccessful()){
final String new_version_code=remoteConfig.getString("new_version_code");
if(Integer.parseInt(new_version_code)>getversioncode())
    showthedialog();
                    }
            }
        });
        card7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,VideoChannel.class));
                overridePendingTransition(R.anim.slideinright,R.anim.slideoutleft);

            }
        });

    }
    private void showdialog4(String p,String t){
        final AlertDialog alertDialog4=new AlertDialog.Builder(this).setIcon(R.drawable.thumbnail2).setTitle(t).setMessage(p).setPositiveButton("OK",null).show();
        alertDialog4.setCancelable(true);
        Button button=alertDialog4.getButton(AlertDialog.BUTTON_POSITIVE);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog4.dismiss();
            }
        });
    }
    private void showthedialog2(String m,String k) {
        final AlertDialog alertDialog2=new AlertDialog.Builder(this).setTitle(k).setMessage(m).setIcon(R.drawable.thumbnail2).setPositiveButton("OK",null).show();
        alertDialog2.setCancelable(true);
        Button button=alertDialog2.getButton(AlertDialog.BUTTON_POSITIVE);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog2.dismiss();
            }
        });
    }
    private void showthedialog(){
        final AlertDialog alertDialog=new AlertDialog.Builder(this).setTitle("New Version available").setIcon(R.drawable.thumbnail2).setMessage("HANDS recommends that you update to the latest version to avoid any crash could be happen.").setPositiveButton("Update",null).setNegativeButton("NO THANKS",null).show();
    Button positiveButton=alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);
    Button negativebutton=alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE);
    positiveButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://play.google.com/store/apps/details?id=com.handshands.handsaast")));
            overridePendingTransition(R.anim.slideinright,R.anim.slideoutleft);
        }
    });
    negativebutton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            alertDialog.dismiss();
        }
    });
    }
private PackageInfo pinfo;
    public int getversioncode(){
        pinfo=null;
        try {
            pinfo=getPackageManager().getPackageInfo(getPackageName(),0);
        } catch (PackageManager.NameNotFoundException e) {
            Log.i("MYLOG","NameNotFoundException: "+e.getMessage());
        }return pinfo.versionCode;
    }
    private void calling() {
        card1=findViewById(R.id.first);
        card2=findViewById(R.id.second);
        card3=findViewById(R.id.third);
        card4=findViewById(R.id.four);
        card5=findViewById(R.id.five);
        card6=findViewById(R.id.six);
        card7=findViewById(R.id.channel);
        card8=findViewById(R.id.About);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }
}
