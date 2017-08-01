package com.quoders.apps.madridbus.domain.repository.stopInfo;

import com.quoders.apps.madridbus.di.FragmentScoped;
import com.quoders.apps.madridbus.domain.interactors.stopInfo.StopInfoInteractor;
import com.quoders.apps.madridbus.domain.network.EmtRestApi;

import dagger.Module;
import dagger.Provides;

@Module
public class StopInfoRepositoryModule {

    private String mStopCode;

    public StopInfoRepositoryModule(String stopCode) {
        mStopCode = stopCode;
    }

    @Provides @FragmentScoped
    StopInfoInteractor providesStopInfoInteractor(EmtRestApi emtRestApi) {
        return new StopInfoInteractor(mStopCode, emtRestApi);
    }
}
