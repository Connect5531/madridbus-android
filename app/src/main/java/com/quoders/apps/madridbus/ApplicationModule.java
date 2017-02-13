package com.quoders.apps.madridbus;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;

@Module
public class ApplicationModule {

    private final Context mContext;

    ApplicationModule(Context context) {
        mContext = context;
    }

    @Provides
    Context provideContext() {
        return mContext;
    }

    @Singleton
    @Provides
    Realm provideRealm() {
        Realm.init(mContext);
        return Realm.getDefaultInstance();
    }

}
