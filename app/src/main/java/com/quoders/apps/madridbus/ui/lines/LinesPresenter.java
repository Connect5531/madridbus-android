package com.quoders.apps.madridbus.ui.lines;

import com.quoders.apps.madridbus.domain.lines.LineListInteractorImpl;
import com.quoders.apps.madridbus.domain.lines.LinesListInteractor;
import com.quoders.apps.madridbus.domain.network.EmtRestApi;

import javax.inject.Inject;

public class LinesPresenter implements LinesContract.Presenter {

    private EmtRestApi mEmtRestApi;

    @Inject
    public LinesPresenter(EmtRestApi mEmtRestApi) {
        this.mEmtRestApi = mEmtRestApi;
    }

    @Override
    public void start() {
        LinesListInteractor interactor = new LineListInteractorImpl()
    }

    @Override
    public void stop() {

    }
}
