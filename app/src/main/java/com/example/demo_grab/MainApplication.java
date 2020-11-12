package com.example.demo_grab;

import android.app.Application;
import com.grab.partner.sdk.GrabIdPartner;

public final class MainApplication extends Application {
    public void onCreate() {
        super.onCreate();
        GrabIdPartner grabIdPartner = (GrabIdPartner) GrabIdPartner.Companion.getInstance();
        grabIdPartner.initialize(getApplicationContext());
    }
}