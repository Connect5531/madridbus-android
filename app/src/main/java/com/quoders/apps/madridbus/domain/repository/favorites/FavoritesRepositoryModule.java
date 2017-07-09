package com.quoders.apps.madridbus.domain.repository.favorites;

import com.quoders.apps.madridbus.di.FragmentScoped;
import com.quoders.apps.madridbus.domain.interactors.favorites.FavoritesInteractor;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;

@Module
public class FavoritesRepositoryModule {

    @Provides
    @FragmentScoped
    FavoritesRepository provideFavoritesRepository(Realm realm) {
        return new FavoritesRepositoryImpl(new FavoritesLocalRepository(realm));
    }

    @Provides @FragmentScoped
    FavoritesInteractor providesFavoritesInteractor(FavoritesRepository favoritesRepository) {
        return new FavoritesInteractor(favoritesRepository);
    }

}
