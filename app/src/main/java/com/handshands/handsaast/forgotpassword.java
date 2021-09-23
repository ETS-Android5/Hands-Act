package com.handshands.handsaast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class forgotpassword extends AppCompatActivity {
EditText myemail;
CardView send;
FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpassword);
myemail=findViewById(R.id.send);
send=findViewById(R.id.confirm);
auth=FirebaseAuth.getInstance();
send.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
String email=myemail.getText().toString().trim();
if(TextUtils.isEmpty(email)){
    myemail.setError("Email should be provided !");
}else{
    auth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
        @Override
        public void onComplete(@NonNull Task<Void> task) {
if(task.isSuccessful()){
    Toast.makeText(forgotpassword.this, "Please check your mail...", Toast.LENGTH_SHORT).show();
    startActivity(new Intent(forgotpassword.this,welcomeactivity.class));
    overridePendingTransition(R.anim.slideinright,R.anim.slideoutleft);

}
else {
    String message=task.getException().getMessage();
    Toast.makeText(forgotpassword.this, "Error happened: "+message, Toast.LENGTH_SHORT).show();
}
        }
    });
}
    }
});

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slideinleft,R.anim.slideoutright);
    }
}