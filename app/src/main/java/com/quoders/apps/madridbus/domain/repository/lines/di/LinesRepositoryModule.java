package com.quoders.apps.madridbus.domain.repository.lines.di;

import android.content.SharedPreferences;

import com.quoders.apps.madridbus.di.FragmentScoped;
import com.quoders.apps.madridbus.domain.network.EmtRestApi;
import com.quoders.apps.madridbus.domain.repository.lines.LinesCloudRepository;
import com.quoders.apps.madridbus.domain.repository.lines.LinesLocalRepository;
import com.quoders.apps.madridbus.domain.repository.lines.LinesRepository;
import com.quoders.apps.madridbus.domain.repository.lines.LinesRepositoryCache;
import com.quoders.apps.madridbus.domain.repository.lines.LinesRepositoryImpl;

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
}
