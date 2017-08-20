package com.quoders.apps.madridbus.ui.favorites;


import com.quoders.apps.madridbus.domain.interactors.favorites.GetFavoritesInteractor;
import com.quoders.apps.madridbus.domain.repository.favorites.FavoritesRepositoryMapper;
import com.quoders.apps.madridbus.model.favorites.FavoriteBase;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;

class FavoritesPresenter implements FavoritesContract.Presenter {

    private final FavoritesContract.View mView;
    private final GetFavoritesInteractor mGetFavoritesInteractor;
    private final CompositeDisposable mDisposables = new CompositeDisposable();

    @Inject
    public FavoritesPresenter(FavoritesContract.View view, GetFavoritesInteractor getFavoritesInteractor) {
        this.mView = view;
        this.mGetFavoritesInteractor = getFavoritesInteractor;
    }

    @Override
    public void start() {

        DisposableObserver<Iterable<FavoriteBase>> observer = new DisposableObserver<Iterable<FavoriteBase>>() {
            @Override
            public void onNext(Iterable<FavoriteBase> favorites) {
                if(favorites != null && favorites.iterator().hasNext()) {
                    mView.setFavoritesList(FavoritesRepositoryMapper.toUIList(favorites));
                    mView.hideEmptyFavoritesMessage();
                } else {
                    mView.showEmptyFavoritesMessage();
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

        mGetFavoritesInteractor.execute(observer);
    }

    @Override
    public void stop() {
        mGetFavoritesInteractor.release();
    }
}
