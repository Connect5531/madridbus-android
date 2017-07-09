package com.quoders.apps.madridbus.domain.repository.favorites;

import com.quoders.apps.madridbus.domain.repository.Cache;
import com.quoders.apps.madridbus.model.favorites.FavoriteBase;

import javax.inject.Inject;

import io.reactivex.Observable;

public class FavoritesRepositoryImpl implements FavoritesRepository {


    private final FavoritesLocalRepository mLocalRepository;

    @Inject
    public FavoritesRepositoryImpl(FavoritesLocalRepository localRepository) {

        this.mLocalRepository = localRepository;
    }


    @Override
    public void releaseRepository() {
        mLocalRepository.close();
    }

    @Override
    public Observable<Iterable<FavoriteBase>> getFavorites() {
        return null;
    }
}
