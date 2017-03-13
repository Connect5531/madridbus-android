package com.quoders.apps.madridbus.domain.repository.lines;

import android.content.SharedPreferences;

import com.quoders.apps.madridbus.di.FragmentScoped;
import com.quoders.apps.madridbus.domain.interactors.lines.LineListInteractor;
import com.quoders.apps.madridbus.domain.network.EmtRestApi;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;

@Module
public class LinesRepositoryModule {

    @Provides @FragmentScoped
    LinesRepository provideLinesRepository(Realm realm, EmtRestApi emtRestApi, SharedPreferences sharedPreferences) {

        return new LinesRepositoryImpl(new LinesRepositoryCache(sharedPreferences),
                new LinesCloudRepository(emtRestApi), new LinesLocalRepository(realm));
    }

    @Provides @FragmentScoped
    LineListInteractor providesLinesListInteractor(LinesRepository linesRepository) {
        return new LineListInteractor(linesRepository);
    }
}
