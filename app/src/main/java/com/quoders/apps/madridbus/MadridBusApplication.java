package com.quoders.apps.madridbus;

import android.app.Application;

import com.quoders.apps.madridbus.domain.network.NetworkModule;

public class MadridBusApplication extends Application {

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .networkModule(new NetworkModule())
                .build();

    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }

}
