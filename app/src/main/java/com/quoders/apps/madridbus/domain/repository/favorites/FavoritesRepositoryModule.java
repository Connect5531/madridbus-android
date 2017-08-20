package com.quoders.apps.madridbus.domain.repository.favorites;

import com.quoders.apps.madridbus.di.FragmentScoped;
import com.quoders.apps.madridbus.domain.interactors.favorites.GetFavoritesInteractor;

import dagger.Module;
import dagger.Provides;

@Module
public class FavoritesRepositoryModule {

    public FavoritesRepositoryModule() {
    }

    @Provides
    @FragmentScoped
    FavoritesRepository provideFavoritesRepository() {
        return new FavoritesRepositoryImpl(new FavoritesLocalRepository());
    }

    @Provides @FragmentScoped
    GetFavoritesInteractor providesGetFavoritesInteractor(FavoritesRepository favoritesRepository) {
        return new GetFavoritesInteractor(favoritesRepository);
    }
}
