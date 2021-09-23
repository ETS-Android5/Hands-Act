package com.handshands.handsaast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class choosepage extends AppCompatActivity {
EditText name,phone,description;
Button done;
ArrayList<checkuser>list;
RadioGroup radioGroup;
DatabaseReference reference;
RadioButton radioButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choosepage);
        calling();
        list=new ArrayList<>();
radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i){
            case R.id.volunteer:
                description.setEnabled(false);
                description.setFocusableInTouchMode(false);
                break;
            case R.id.nonvolunteer:
                description.setEnabled(true);
                description.setFocusableInTouchMode(true);
                break;
            default:
                description.setEnabled(false);
                description.setFocusableInTouchMode(false);
                break;
        }
    }
});
done.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        int selectbutton=radioGroup.getCheckedRadioButtonId();
        radioButton=findViewById(selectbutton);
        reference= FirebaseDatabase.getInstance().getReference("help").child("people");
        checkuser checkuser=new checkuser(description.getText().toString(), FirebaseAuth.getInstance().getCurrentUser().getEmail().toString(),radioButton.getText().toString(),FirebaseAuth.getInstance().getCurrentUser().getUid().toString(),phone.getText().toString());
reference.child(FirebaseAuth.getInstance().getCurrentUser().getUid().toString()).setValue(checkuser);
    }
});

    }

    private void calling() {
        name=findViewById(R.id.namevol);
        phone=findViewById(R.id.phonevol);
        description=findViewById(R.id.description);
        done=findViewById(R.id.done);
        radioGroup=findViewById(R.id.choose);

    }


    }
