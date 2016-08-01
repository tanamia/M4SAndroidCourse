package com.example.aminatambengue.firebasestudent;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by Aminata Mbengue on 29/07/2016.
 */

public class Config extends Application {

    @Override
    public void onCreate(){
        super.onCreate();
        Firebase.setAndroidContext(this);

    }
}
