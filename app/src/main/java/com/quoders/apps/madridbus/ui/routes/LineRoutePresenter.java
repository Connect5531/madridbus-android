package com.quoders.apps.madridbus.ui.routes;

import android.support.annotation.NonNull;

import com.quoders.apps.madridbus.domain.interactors.favorites.AddFavoriteInteractor;
import com.quoders.apps.madridbus.domain.interactors.favorites.GetFavoritesInteractor;
import com.quoders.apps.madridbus.domain.interactors.route.RouteInteractor;
import com.quoders.apps.madridbus.model.StopBase;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;

public class LineRoutePresenter implements LineRouteContract.Presenter {

    private final LineRouteContract.View mView;
    private final RouteInteractor mRouteInteractor;
    private final GetFavoritesInteractor mGetFavoritesInteractor;
    private final AddFavoriteInteractor mAddFavoriteInteractor;

    private final CompositeDisposable mDisposables = new CompositeDisposable();


    @Inject
    public LineRoutePresenter(@NonNull LineRouteContract.View view, @NonNull RouteInteractor routeInteractor,
                              @NonNull GetFavoritesInteractor getFavoritesInteractor,
                              @NonNull AddFavoriteInteractor addFavoritesInteractor) {
        mView = view;
        mRouteInteractor = routeInteractor;
        mGetFavoritesInteractor = getFavoritesInteractor;
        mAddFavoriteInteractor = addFavoritesInteractor;
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

        mRouteInteractor.execute(observer);
    }

    @Override
    public void stop() {
        mDisposables.clear();
    }

    @Override
    public void onStopClicked(StopBase item) {
        mView.displayStopDetail(item);
    }

    @Override
    public void onAddStopToFavoritesClick(StopBase stop) {
        mAddFavoriteInteractor.execute(new DisposableObserver() {
            @Override
            public void onNext(Object o) {
                mView.showFavoriteAddedSuccessMessage();
            }

            @Override
            public void onError(Throwable e) {
                mView.showErrorAddingFavoriteMessage();
            }

            @Override
            public void onComplete() {

            }
        });
    }
}
