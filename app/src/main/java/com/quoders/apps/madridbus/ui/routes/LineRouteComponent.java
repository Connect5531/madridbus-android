package com.quoders.apps.madridbus.ui.routes;


import com.quoders.apps.madridbus.ApplicationComponent;
import com.quoders.apps.madridbus.di.FragmentScoped;
import com.quoders.apps.madridbus.domain.repository.favorites.FavoritesRepositoryModule;
import com.quoders.apps.madridbus.domain.repository.routes.RouteRepository;
import com.quoders.apps.madridbus.domain.repository.routes.RoutesRepositoryModule;

import dagger.Component;

@FragmentScoped
@Component(dependencies = ApplicationComponent.class, modules = {LineRoutePresenterModule.class, RoutesRepositoryModule.class, FavoritesRepositoryModule.class})
public interface LineRouteComponent {

    void inject(LineRouteActivity lineRouteActivity);
}
