package com.oms_infotech.www.gmatguru;

import com.firebase.client.Firebase;

/**
 * Created by Himanshu on 11/23/2016.
 */
public class Cloud extends android.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
