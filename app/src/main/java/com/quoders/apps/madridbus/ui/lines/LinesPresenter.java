package com.quoders.apps.madridbus.ui.lines;

import com.quoders.apps.madridbus.domain.lines.LinesListInteractor;
import com.quoders.apps.madridbus.domain.utils.DateUtils;
import com.quoders.apps.madridbus.model.rest.ListLineInfoEmt;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

public class LinesPresenter implements LinesContract.Presenter {

    private LinesContract.View mView;
    private LinesListInteractor mLinesListInteractor;
    private final CompositeDisposable mDisposables = new CompositeDisposable();

    @Inject
    public LinesPresenter(LinesContract.View view, LinesListInteractor linesListInteractor) {
        this.mView = view;
        this.mLinesListInteractor = linesListInteractor;
    }

    @Override
    public void start() {

        mView.showProgressBar();

        mDisposables.add(mLinesListInteractor.getLinesList(DateUtils.getTodayShortFormat())
                .subscribe(new Consumer<ListLineInfoEmt>() {
                    @Override
                    public void accept(ListLineInfoEmt listLineInfoEmt) throws Exception {
                        mView.dismissProgressBar();
                        if(listLineInfoEmt != null && !listLineInfoEmt.getResultValues().isEmpty()) {
                            mView.setLinesList(listLineInfoEmt.getResultValues());
                        } else {
                            mView.showErrorLoadingList();
                        }
                    }
                }));
    }

    @Override
    public void stop() {
        mDisposables.clear();
    }
}
