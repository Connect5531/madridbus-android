package com.quoders.apps.madridbus.ui.favorites;

import com.quoders.apps.madridbus.ApplicationComponent;
import com.quoders.apps.madridbus.di.FragmentScoped;
import com.quoders.apps.madridbus.domain.repository.favorites.FavoritesRepositoryModule;

import dagger.Component;

@FragmentScoped
@Component(dependencies = ApplicationComponent.class, modules = {FavoritesPresenterModule.class, FavoritesRepositoryModule.class})
public interface FavoritesComponent {

    void inject(FavoritesFragment favoritesFragment);
}
