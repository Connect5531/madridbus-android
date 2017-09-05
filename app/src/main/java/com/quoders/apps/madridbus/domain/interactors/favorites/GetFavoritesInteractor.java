package com.quoders.apps.madridbus.domain.interactors.favorites;


import com.quoders.apps.madridbus.BaseInteractor;
import com.quoders.apps.madridbus.domain.repository.favorites.FavoritesRepository;


import javax.inject.Inject;

import io.reactivex.Observable;

public class GetFavoritesInteractor extends BaseInteractor {

    private FavoritesRepository repository;

    @Inject
    public GetFavoritesInteractor(FavoritesRepository favoritesRepository) {
        this.repository = favoritesRepository;
    }


    @Override
    public void release() {
        repository.releaseRepository();
    }

    @Override
    protected Observable buildInteractorObservable() {
        return repository.getFavorites();
    }
}
