package com.quoders.apps.madridbus.domain.interactors.favorites;


import com.quoders.apps.madridbus.domain.repository.favorites.FavoritesRepository;
import com.quoders.apps.madridbus.model.StopBase;
import com.quoders.apps.madridbus.model.favorites.FavoriteBase;

import javax.inject.Inject;

public class AddFavoriteInteractor {

    private FavoritesRepository mRepository;

    @Inject
    public AddFavoriteInteractor(FavoritesRepository favoritesRepository) {
        this.mRepository = favoritesRepository;
    }

    public void addFavorite(StopBase stop) {
        mRepository.addFavorite(new FavoriteBase(stop.getCode(), stop, stop.getName()));
    }
}
