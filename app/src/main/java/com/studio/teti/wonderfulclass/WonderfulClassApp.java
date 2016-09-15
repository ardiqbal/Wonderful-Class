package com.studio.teti.wonderfulclass;

/**
 * Created by msipc on 08/09/2016.
 */

import com.firebase.client.Firebase;

public class WonderfulClassApp extends android.app.Application{

    @Override
    public void onCreate() {
        super.onCreate();
        /*Init FireBase*/
        Firebase.setAndroidContext(this);
        /*Disk Persistence*/
        Firebase.getDefaultConfig().setPersistenceEnabled(true);
    }
}
