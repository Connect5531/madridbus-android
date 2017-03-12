package com.quoders.apps.madridbus.ui.lines;

import com.quoders.apps.madridbus.domain.interactors.lines.LineListInteractor;
import com.quoders.apps.madridbus.domain.repository.lines.LinesRepository;
import com.quoders.apps.madridbus.domain.repository.lines.LinesRepositoryMapper;
import com.quoders.apps.madridbus.model.LineBase;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class LinesPresenter implements LinesContract.Presenter {

    private LinesContract.View mView;
    private LineListInteractor mLinesListInteractor;
    private final CompositeDisposable mDisposables = new CompositeDisposable();

    @Inject
    public LinesPresenter(LinesContract.View view, LinesRepository linesRepository) {
        this.mView = view;

    }

    @Override
    public void start() {

        mView.showProgressBar();

        mLinesListInteractor.execute(new Observer<Iterable<LineBase>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Iterable<LineBase> lineList) {
                if(lineList != null && !lineList.iterator().hasNext()) {
                    mView.setLinesList(LinesRepositoryMapper.toList(lineList));
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
