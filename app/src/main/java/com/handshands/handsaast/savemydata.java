package com.handshands.handsaast;

import android.app.Application;

import com.google.firebase.database.FirebaseDatabase;

public class savemydata extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    }
}
