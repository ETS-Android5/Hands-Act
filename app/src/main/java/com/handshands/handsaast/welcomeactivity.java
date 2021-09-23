package com.handshands.handsaast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookAuthorizationException;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginBehavior;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.FirebaseDatabase;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class welcomeactivity extends AppCompatActivity {
Button signin,signup;
ImageView cardView,cardview2;
private GoogleSignInClient googleSignInClient;
private FirebaseAuth auth;
CallbackManager callbackManager;
private int RC_SIGN_IN=123;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcomeactivity);
        calling();
        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager= CallbackManager.Factory.create();
        cardview2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<String> permission =
                        new ArrayList<>();
                permission.add("email");
                permission.add("public_profile");
                LoginManager.getInstance().setLoginBehavior(LoginBehavior.NATIVE_WITH_FALLBACK).logInWithReadPermissions(welcomeactivity.this, permission);
                LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        handlefacebookaccesstoken(loginResult.getAccessToken());
                    }

                    @Override
                    public void onCancel() {
                        Toast.makeText(welcomeactivity.this, "canceled", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(FacebookException error) {
                        if (error instanceof FacebookAuthorizationException) {
                            if (AccessToken.getCurrentAccessToken() != null) {
                                LoginManager.getInstance().logOut();
                            }
                            else {
                                Toast.makeText(welcomeactivity.this, error.toString(), Toast.LENGTH_SHORT).show();
                            }
                        }    else {
                            Toast.makeText(welcomeactivity.this, error.toString(), Toast.LENGTH_SHORT).show();
                        }                }
                });
            }
        });
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(welcomeactivity.this, signin.class));
                overridePendingTransition(R.anim.slideinright,R.anim.slideoutleft);

            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(welcomeactivity.this, signup.class));
                overridePendingTransition(R.anim.slideinright,R.anim.slideoutleft);

            }
        });
        auth=FirebaseAuth.getInstance();
        createrequest();
    cardView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            signin();
        }
    });
    }
    private void handlefacebookaccesstoken(AccessToken accessToken) {
        AuthCredential credential= FacebookAuthProvider.getCredential(accessToken.getToken());
        auth.signInWithCredential(credential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    startActivity(new Intent(welcomeactivity.this,MainActivity.class));
                    overridePendingTransition(R.anim.slideinright,R.anim.slideoutleft);
                }
            }
        });
    }

    private void createrequest() {
        GoogleSignInOptions gso=new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestIdToken(getString(R.string.default_web_client_id)).requestEmail().build();
        googleSignInClient=GoogleSignIn.getClient(this,gso);
    }
    private void signin(){
        Intent intent=googleSignInClient.getSignInIntent();
        startActivityForResult(intent,RC_SIGN_IN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode,resultCode,data);
        if(requestCode==RC_SIGN_IN){
            Task<GoogleSignInAccount>task=GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                GoogleSignInAccount account=task.getResult(ApiException.class);
                firebaseauthwithgoogle(account);
            } catch (ApiException e) {
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void firebaseauthwithgoogle(GoogleSignInAccount account) {
        AuthCredential credential=GoogleAuthProvider.getCredential(account.getIdToken(),null);
        auth.signInWithCredential(credential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
if(task.isSuccessful()){
    Intent intent=new Intent(getApplicationContext(),MainActivity.class);
    startActivity(intent);
    overridePendingTransition(R.anim.slideinright,R.anim.slideoutleft);

}
else {
    Toast.makeText(welcomeactivity.this, "please try again !", Toast.LENGTH_SHORT).show();
}
            }
        });
    }




    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }



    private void calling() {
        signin=findViewById(R.id.signin);
        signup=findViewById(R.id.signup);
        cardView=findViewById(R.id.welcomegoogle);
        cardview2=findViewById(R.id.welcomefacebook);
    }
}