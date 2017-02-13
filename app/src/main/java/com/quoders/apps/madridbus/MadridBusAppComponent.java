package com.quoders.apps.madridbus;

import android.content.Context;

import com.quoders.apps.madridbus.domain.network.EmtRestApi;
import com.quoders.apps.madridbus.domain.network.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;
import io.realm.Realm;
import retrofit2.Retrofit;


@Singleton
@Component(modules = {ApplicationModule.class, NetworkModule.class})
public interface MadridBusAppComponent {

  Context getAppContext();

  Retrofit getRetrofit();

  EmtRestApi getEmtRestApi();

  Realm getRealm();
}
