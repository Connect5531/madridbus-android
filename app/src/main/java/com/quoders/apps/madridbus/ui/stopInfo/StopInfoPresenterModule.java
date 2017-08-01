package com.quoders.apps.madridbus.ui.stopInfo;

import dagger.Module;
import dagger.Provides;

@Module
public class StopInfoPresenterModule {

    private final StopInfoContract.View mView;

    public StopInfoPresenterModule(StopInfoContract.View view) {
        mView = view;
    }

    @Provides
    StopInfoContract.View provideLinesContractView() {
        return mView;
    }
}
