package com.quoders.apps.madridbus.domain.repository;

import android.content.SharedPreferences;

import java.util.Date;

public abstract class Cache {

    private final SharedPreferences mSharedPreferences;

    public Cache(SharedPreferences sharedPreferences) {
        mSharedPreferences = sharedPreferences;
    }

    public abstract void setCache();

    protected void setCache(String prefsId, long cacheTimeMillis) {
        mSharedPreferences.edit().putLong(prefsId, cacheTimeMillis).apply();
    }

    public abstract boolean isDataOutdated();

    protected boolean isDataOutdated(String prefsId, long maxCacheTimeMillis) {
        boolean cacheOutdated = true;
        long cached = mSharedPreferences.getLong(prefsId, 0);
        if(cached != 0) {
            Date today = new Date();
            cacheOutdated = (today.getTime() - cached) > maxCacheTimeMillis;
        }
        return cacheOutdated;
    }
}
