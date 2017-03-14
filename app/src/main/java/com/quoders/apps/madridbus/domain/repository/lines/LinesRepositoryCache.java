package com.quoders.apps.madridbus.domain.repository.lines;


import android.content.SharedPreferences;

import com.quoders.apps.madridbus.domain.repository.Cache;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

public class LinesRepositoryCache extends Cache {

    private static final long MAX_CACHE_DAYS = 7;
    private static final long MAX_CACHE_TIME = TimeUnit.DAYS.toMillis(MAX_CACHE_DAYS);

    private static final String PREFS_LAST_LINES_LIST_CACHED_DATE = "quoders.madridbus.PREFS_LAST_LINES_LIST_CACHED_DATE";


    @Inject
    public LinesRepositoryCache(SharedPreferences sharedPreferences) {
        super(sharedPreferences);
    }

    @Override
    public void setCache() {
        super.setCache(PREFS_LAST_LINES_LIST_CACHED_DATE, new Date().getTime());
    }

    @Override
    public boolean isDataOutdated() {
        return super.isDataOutdated(PREFS_LAST_LINES_LIST_CACHED_DATE, MAX_CACHE_TIME);
    }
}
