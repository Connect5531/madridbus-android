package com.quoders.apps.madridbus.ui.lines;

import dagger.Module;
import dagger.Provides;

@Module
public class LinesPresenterModule {

    private final LinesContract.View mView;

    public LinesPresenterModule(LinesContract.View view) {
        mView = view;
    }

    @Provides
    LinesContract.View provideLinesContractView() {
        return mView;
    }
}
