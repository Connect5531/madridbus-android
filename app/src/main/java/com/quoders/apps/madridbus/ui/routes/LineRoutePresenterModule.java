package com.quoders.apps.madridbus.ui.routes;

import com.quoders.apps.madridbus.ui.model.LineUI;

import dagger.Module;
import dagger.Provides;

@Module
public class LineRoutePresenterModule {

    private final LineRouteContract.View mView;
    private final LineUI mLine;

    public LineRoutePresenterModule(LineRouteContract.View view, LineUI line) {
        mView = view;
        mLine = line;
    }

    @Provides
    LineRouteContract.View provideHomeContractView() {
        return mView;
    }

    @Provides
    LineUI provideLineBase() {
        return mLine;
    }
}
