package com.quoders.apps.madridbus.ui.lines;

import com.quoders.apps.madridbus.domain.lines.LineListInteractorImpl;
import com.quoders.apps.madridbus.domain.lines.LinesListInteractor;
import com.quoders.apps.madridbus.domain.network.EmtRestApi;

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

    @Provides
    LinesListInteractor provideLinesListInteractor(EmtRestApi emtRestApi) {
        return new LineListInteractorImpl(emtRestApi);
    }
}
