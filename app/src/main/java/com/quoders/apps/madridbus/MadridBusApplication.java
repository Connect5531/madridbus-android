package com.quoders.apps.madridbus;

import android.app.Application;

public class MadridBusApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

/*
        mRepositoryComponent = DaggerTasksRepositoryComponent.builder()
                .applicationModule(new ApplicationModule((getApplicationContext())))
                .build();
*/
    }

    /*public TasksRepositoryComponent getTasksRepositoryComponent() {
        return mRepositoryComponent;
    }*/
}
