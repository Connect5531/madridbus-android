package com.quoders.apps.madridbus.domain.repository.favorites;

import com.quoders.apps.madridbus.di.FragmentScoped;
import com.quoders.apps.madridbus.domain.interactors.favorites.AddFavoriteInteractor;
import com.quoders.apps.madridbus.domain.interactors.favorites.GetFavoritesInteractor;
import com.quoders.apps.madridbus.model.StopBase;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;

@Module
public class FavoritesRepositoryModule {

    private StopBase mStopBase;

    public FavoritesRepositoryModule(StopBase stop) {
        this.mStopBase = stop;
    }

    @Provides
    @FragmentScoped
    FavoritesRepository provideFavoritesRepository(Realm realm) {
        return new FavoritesRepositoryImpl(new FavoritesLocalRepository(realm));
    }

    @Provides @FragmentScoped
    GetFavoritesInteractor providesGetFavoritesInteractor(FavoritesRepository favoritesRepository) {
        return new GetFavoritesInteractor(favoritesRepository);
    }

    @Provides @FragmentScoped
    AddFavoriteInteractor providesAddFavoritesInteractor(FavoritesRepository favoritesRepository) {
        return new AddFavoriteInteractor(favoritesRepository);
    }
}
