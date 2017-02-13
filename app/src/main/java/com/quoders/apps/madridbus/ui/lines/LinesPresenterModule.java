package com.quoders.apps.madridbus.ui.lines;

import com.quoders.apps.madridbus.domain.interactors.lines.LineListInteractorImpl;
import com.quoders.apps.madridbus.domain.interactors.lines.LinesListInteractor;
import com.quoders.apps.madridbus.domain.network.EmtRestApi;
import com.quoders.apps.madridbus.domain.repository.lines.LinesLocalRepository;

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
    LinesListInteractor provideLinesListInteractor(EmtRestApi emtRestApi, LinesLocalRepository repository) {
        return new LineListInteractorImpl(emtRestApi, repository);
    }
}
