package com.quoders.apps.madridbus.domain.repository.routes;

import android.content.SharedPreferences;

import com.quoders.apps.madridbus.di.FragmentScoped;
import com.quoders.apps.madridbus.domain.interactors.route.RouteInteractor;
import com.quoders.apps.madridbus.domain.network.EmtRestApi;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;

@Module
public class RoutesRepositoryModule {

    private String mLineCode;

    public RoutesRepositoryModule(String lineCode) {
        mLineCode = lineCode;
    }

    @Provides @FragmentScoped
    RouteRepository provideLinesRepository(Realm realm, EmtRestApi emtRestApi, SharedPreferences sharedPreferences) {

        return new RouteRepositoryImpl(new RouteRepositoryCache(sharedPreferences),
                new RouteCloudRepository(emtRestApi, mLineCode), new RouteLocalRepository(realm));
    }

    @Provides @FragmentScoped
    RouteInteractor providesRouteInteractor(RouteRepository routeRepository) {
        return new RouteInteractor(routeRepository, mLineCode);
    }
}
