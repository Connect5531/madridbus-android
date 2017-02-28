package com.quoders.apps.madridbus.domain.repository;

import android.content.SharedPreferences;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public abstract class Cache {

    private static final long MAX_CACHE_DAYS = 7;
    private static final long MAX_CACHE_TIME = TimeUnit.DAYS.toMillis(MAX_CACHE_DAYS);

    private final SharedPreferences mSharedPreferences;

    public Cache(SharedPreferences sharedPreferences) {
        mSharedPreferences = sharedPreferences;
    }

    public abstract boolean isDataOutdated();

    protected boolean isDataOutdated(String prefsId) {
        long cached = mSharedPreferences.getLong(prefsId, 0);
        if(cached != 0) {
            Date today = new Date();
            if(today.getTime() - cached > MAX_CACHE_TIME) {
                return true;
            }
        }
        return false;
    }
}
