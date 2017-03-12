package com.quoders.apps.madridbus.domain.network;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    @Provides @Singleton
    EmtRestApi provideEmtRestApi() {

        Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(EmtRestDefs.API_URL)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        return retrofit.create(EmtRestApi.class);
    }
}

