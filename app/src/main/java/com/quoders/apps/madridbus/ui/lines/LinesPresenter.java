package com.quoders.apps.madridbus.ui.lines;

import com.quoders.apps.madridbus.domain.interactors.lines.LinesListInteractor;
import com.quoders.apps.madridbus.domain.utils.DateUtils;
import com.quoders.apps.madridbus.model.LineBase;
import com.quoders.apps.madridbus.model.rest.ListLineInfoEmt;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
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

        mLinesListInteractor.getLinesList(DateUtils.getTodayShortFormat())
                .subscribe(new Observer<List<LineBase>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(List<LineBase> lineList) {
                        if(lineList != null && !lineList.isEmpty()) {
                            mView.setLinesList(lineList);
                        } else {
                            mView.dismissProgressBar();
                            mView.showErrorLoadingList();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.dismissProgressBar();
                        mView.showErrorLoadingList();
                    }

                    @Override
                    public void onComplete() {
                        mView.dismissProgressBar();
                    }
                });

    }

    @Override
    public void stop() {
        mDisposables.clear();
    }
}
