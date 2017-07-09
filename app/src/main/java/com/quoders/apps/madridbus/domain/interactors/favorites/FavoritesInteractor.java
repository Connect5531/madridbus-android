package com.quoders.apps.madridbus.domain.interactors.favorites;


import com.quoders.apps.madridbus.domain.repository.favorites.FavoritesRepository;
import com.quoders.apps.madridbus.model.favorites.FavoriteBase;


import javax.inject.Inject;

import io.reactivex.Observable;

public class FavoritesInteractor {

    FavoritesRepository repository;

    @Inject
    public FavoritesInteractor(FavoritesRepository favoritesRepository) {
        this.repository = favoritesRepository;
    }

    Observable<Iterable<FavoriteBase>> getFavorites() {
        return repository.getFavorites();
    }

}
