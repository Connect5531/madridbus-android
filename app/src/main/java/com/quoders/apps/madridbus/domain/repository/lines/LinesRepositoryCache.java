package com.quoders.apps.madridbus.domain.repository.lines;


import android.content.SharedPreferences;

import com.quoders.apps.madridbus.domain.repository.Cache;

import javax.inject.Inject;

public class LinesRepositoryCache extends Cache {

    private static final String PREFS_LAST_LINES_LIST_CACHED_DATE = "quoders.madridbus.PREFS_LAST_LINES_LIST_CACHED_DATE";

    @Inject
    public LinesRepositoryCache(SharedPreferences sharedPreferences) {
        super(sharedPreferences);
    }

    @Override
    public boolean isDataOutdated() {
        return super.isDataOutdated(PREFS_LAST_LINES_LIST_CACHED_DATE);
    }
}
