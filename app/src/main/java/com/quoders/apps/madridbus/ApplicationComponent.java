package com.quoders.apps.madridbus;

import android.content.SharedPreferences;

import com.quoders.apps.madridbus.domain.network.EmtRestApi;
import com.quoders.apps.madridbus.domain.network.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = {ApplicationModule.class, NetworkModule.class})
public interface ApplicationComponent {

  void inject(BaseActivity baseActivity);
  void inject(BaseFragment baseFragment);

  SharedPreferences providesSharedPreferences();
  EmtRestApi providesEmtApi();
  AppDatabase providesRoomDatabase();
}
