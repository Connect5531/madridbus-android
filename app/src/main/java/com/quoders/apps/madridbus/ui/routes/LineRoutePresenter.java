package com.quoders.apps.madridbus.ui.routes;

import android.support.annotation.NonNull;
import android.util.Log;

import com.quoders.apps.madridbus.domain.interactors.route.RouteInteractor;
import com.quoders.apps.madridbus.domain.repository.routes.RouteCloudRepository;
import com.quoders.apps.madridbus.model.LineBase;
import com.quoders.apps.madridbus.model.StopBase;
import com.quoders.apps.madridbus.ui.home.HomeContract;
import com.quoders.apps.madridbus.ui.model.LineUI;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;

public class LineRoutePresenter implements LineRouteContract.Presenter {

    private LineRouteContract.View mView;
    private RouteInteractor mInteractor;
    private final CompositeDisposable mDisposables = new CompositeDisposable();

    @Inject
    public LineRoutePresenter(@NonNull LineRouteContract.View view, @NonNull RouteInteractor interactor) {
        mView = view;
        mInteractor = interactor;
    }

    @Override
    public void start() {
        mView.showProgressBar();

        DisposableObserver<List<StopBase>> observer = new DisposableObserver<List<StopBase>>() {
            @Override
            public void onNext(List<StopBase> stops) {
                if(stops != null && stops.iterator().hasNext()) {
                    mView.displayRoute(stops);
                } else {
                    onError(null);
                }
            }

            @Override
            public void onError(Throwable e) {
                mView.showErrorLoadingList();
            }

            @Override
            public void onComplete() {
                mView.dismissProgressBar();
            }
        };

        mDisposables.add(observer);

        mInteractor.execute(observer);
    }

    @Override
    public void stop() {
        mDisposables.clear();
    }

}
