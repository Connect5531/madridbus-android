package com.quoders.apps.madridbus.domain.repository.routes;


import android.content.SharedPreferences;
import android.support.annotation.NonNull;

import com.quoders.apps.madridbus.domain.repository.Cache;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

public class RouteRepositoryCache extends Cache {

    private static final long MAX_CACHE_DAYS = 7;
    private static final long MAX_CACHE_TIME = TimeUnit.DAYS.toMillis(MAX_CACHE_DAYS);

    private static final String PREFS_LAST_ROUTE_LIST_CACHED_DATE = "quoders.madridbus.PREFS_LAST_ROUTE_LIST_CACHED_DATE:";


    @Inject
    public RouteRepositoryCache(SharedPreferences sharedPreferences) {
        super(sharedPreferences);
    }

    @Override
    public void setCache(@NonNull String id) {
        super.setCache(PREFS_LAST_ROUTE_LIST_CACHED_DATE + id, new Date().getTime());
    }

    @Override
    public boolean isDataOutdated(@NonNull String id) {
        return super.isDataOutdated(PREFS_LAST_ROUTE_LIST_CACHED_DATE + id, MAX_CACHE_TIME);
    }
}
