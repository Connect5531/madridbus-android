package com.quoders.apps.madridbus.domain.interactors.favorites;


import com.quoders.apps.madridbus.BaseInteractor;
import com.quoders.apps.madridbus.domain.repository.favorites.FavoritesRepository;
import com.quoders.apps.madridbus.model.StopBase;

import javax.inject.Inject;

import io.reactivex.Observable;

public class AddFavoriteInteractor extends BaseInteractor {

    FavoritesRepository mRepository;
    private StopBase mStop;

    @Inject
    public AddFavoriteInteractor(FavoritesRepository favoritesRepository, StopBase stop) {
        this.mRepository = favoritesRepository;
        this.mStop = stop;
    }

    @Override
    public void release() {
        mRepository.releaseRepository();
    }

    @Override
    protected Observable buildInteractorObservable() {
        return mRepository.getFavorites();
    }
}
