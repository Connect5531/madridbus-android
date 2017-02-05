package com.quoders.apps.madridbus;

import android.app.Application;

public class MadridBusApplication extends Application {

    private MadridBusAppComponent mMadridBusAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mMadridBusAppComponent = DaggerMadridBusAppComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public MadridBusAppComponent getApplicationComponent() {
        return mMadridBusAppComponent;
    }

}
