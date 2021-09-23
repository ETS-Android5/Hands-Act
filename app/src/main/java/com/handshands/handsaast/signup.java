package com.handshands.handsaast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.GoogleAuthProvider;
public class signup extends AppCompatActivity {
EditText mali,pass,phone;
CardView cardView;
TextView textView;
FirebaseAuth auth2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        calling();
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(signup.this, signin.class));
                overridePendingTransition(R.anim.slideinright,R.anim.slideoutleft);
            }
        });
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String em = mali.getText().toString().trim();
                String pa = pass.getText().toString().trim();
                auth2 = FirebaseAuth.getInstance();
                auth2.createUserWithEmailAndPassword(em, pa).addOnCompleteListener(signup.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            startActivity(new Intent(signup.this, signin.class));
                            overridePendingTransition(R.anim.slideinright,R.anim.slideoutleft);
                            Toast.makeText(signup.this, "Successful register", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(signup.this, "Something wrong !,please try again..", Toast.LENGTH_SHORT).show();
                        }
                    }
                });


            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slideinleft,R.anim.slideoutright);

    }

    private void calling() {
        mali=findViewById(R.id.signupemail);
        pass=findViewById(R.id.signuppassword);
        phone=findViewById(R.id.phonenumber);
        cardView=findViewById(R.id.register);
        textView=findViewById(R.id.backsign);
    }
}