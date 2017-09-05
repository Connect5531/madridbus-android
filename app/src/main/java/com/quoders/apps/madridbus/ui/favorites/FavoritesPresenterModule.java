package com.quoders.apps.madridbus.ui.favorites;

import dagger.Module;
import dagger.Provides;

@Module
public class FavoritesPresenterModule {

    private final FavoritesContract.View mView;

    public FavoritesPresenterModule(FavoritesContract.View view) {
        mView = view;
    }

    @Provides
    FavoritesContract.View provideFavoritesContractView() {
        return mView;
    }
}
