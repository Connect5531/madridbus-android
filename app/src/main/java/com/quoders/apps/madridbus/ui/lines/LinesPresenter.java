package com.quoders.apps.madridbus.ui.lines;

import com.quoders.apps.madridbus.domain.interactors.lines.LineListInteractor;
import com.quoders.apps.madridbus.domain.repository.lines.LinesRepositoryMapper;
import com.quoders.apps.madridbus.model.LineBase;
import com.quoders.apps.madridbus.ui.model.LineUI;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;

public class LinesPresenter implements LinesContract.Presenter {

    private LinesContract.View mView;
    private LineListInteractor mLinesListInteractor;
    private final CompositeDisposable mDisposables = new CompositeDisposable();

    @Inject
    public LinesPresenter(LinesContract.View view, LineListInteractor lineListInteractor) {
        this.mView = view;
        this.mLinesListInteractor = lineListInteractor;
    }

    @Override
    public void start() {

        mView.showProgressBar();

        DisposableObserver<Iterable<LineBase>> observer = new DisposableObserver<Iterable<LineBase>>() {
            @Override
            public void onNext(Iterable<LineBase> lineList) {
                if(lineList != null && lineList.iterator().hasNext()) {
                    mView.setLinesList(LinesRepositoryMapper.toUIList(lineList));
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
        };

        mDisposables.add(observer);

        mLinesListInteractor.execute(observer);
    }

    @Override
    public void stop() {
        mDisposables.clear();
        mLinesListInteractor.release();
    }
}
