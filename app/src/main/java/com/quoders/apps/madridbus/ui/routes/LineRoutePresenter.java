package com.quoders.apps.madridbus.ui.routes;

import android.support.annotation.NonNull;
import android.util.Log;

import com.quoders.apps.madridbus.domain.interactors.route.RouteInteractor;
import com.quoders.apps.madridbus.domain.repository.routes.RouteCloudRepository;
import com.quoders.apps.madridbus.model.LineBase;
import com.quoders.apps.madridbus.model.StopBase;
import com.quoders.apps.madridbus.ui.home.HomeContract;
import com.quoders.apps.madridbus.ui.model.LineUI;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class LineRoutePresenter implements LineRouteContract.Presenter {

    private LineRouteContract.View mView;
    private LineUI mLine;
    private RouteInteractor mInteractor;

    @Inject
    public LineRoutePresenter(@NonNull LineRouteContract.View view, @NonNull LineUI line,
                              @NonNull RouteInteractor interactor) {
        mView = view;
        mLine = line;
        mInteractor = interactor;
    }

    @Override
    public void start() {
        mView.showProgressBar();

        mInteractor.execute(new Observer<Iterable<StopBase>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Iterable<StopBase> stopBases) {
                if(stopBases != null && stopBases.iterator().hasNext()) {
                    for (StopBase stop: stopBases) {
                        Log.i("STOP_", stop.getCode() + "-" + stop.getName());
                    }
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

    }

}
