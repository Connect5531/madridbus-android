package com.quoders.apps.madridbus.ui.favorites;


import com.quoders.apps.madridbus.domain.interactors.favorites.FavoritesInteractor;
import com.quoders.apps.madridbus.domain.repository.favorites.FavoritesRepositoryMapper;
import com.quoders.apps.madridbus.domain.repository.lines.LinesRepositoryMapper;
import com.quoders.apps.madridbus.model.LineBase;
import com.quoders.apps.madridbus.model.favorites.FavoriteBase;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;

class FavoritesPresenter implements FavoritesContract.Presenter {

    private final FavoritesContract.View mView;
    private final FavoritesInteractor mFavoritesInteractor;
    private final CompositeDisposable mDisposables = new CompositeDisposable();

    @Inject
    public FavoritesPresenter(FavoritesContract.View view, FavoritesInteractor favoritesInteractor) {
        this.mView = view;
        this.mFavoritesInteractor = favoritesInteractor;
    }

    @Override
    public void start() {

        DisposableObserver<Iterable<FavoriteBase>> observer = new DisposableObserver<Iterable<FavoriteBase>>() {
            @Override
            public void onNext(Iterable<FavoriteBase> favorites) {
                if(favorites != null && favorites.iterator().hasNext()) {
                    mView.setFavoritesList(FavoritesRepositoryMapper.toUIList(favorites));
                } else {
                    mView.dismissProgressBar();
                    mView.showErrorLoadingList();
                }
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };

        mDisposables.add(observer);

    }

    @Override
    public void stop() {

    }
}
