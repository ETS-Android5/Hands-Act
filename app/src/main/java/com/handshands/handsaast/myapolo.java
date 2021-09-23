package com.handshands.handsaast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class myapolo extends AppCompatActivity {
    int unicode=0x1F60A;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myapolo);
        textView=findViewById(R.id.apolo);
        String emoji=getemoji(unicode);
textView.setText("We hope you enjoyed the offer you selected,\nyou can enjoy other offers"+emoji);
    }
    public String getemoji(int uni){
        return new String(Character.toChars(uni));
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(myapolo.this,MainActivity.class));
    }
}