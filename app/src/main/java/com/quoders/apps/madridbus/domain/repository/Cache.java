package com.quoders.apps.madridbus.domain.repository;

import android.content.SharedPreferences;

import java.util.Date;

public abstract class Cache {

    private final SharedPreferences mSharedPreferences;

    public Cache(SharedPreferences sharedPreferences) {
        mSharedPreferences = sharedPreferences;
    }

    public abstract boolean isDataOutdated();

    protected boolean isDataOutdated(String prefsId, long maxCaheTimeMillis) {
        long cached = mSharedPreferences.getLong(prefsId, 0);
        if(cached != 0) {
            Date today = new Date();
            if(today.getTime() - cached > maxCaheTimeMillis) {
                return true;
            }
        }
        return false;
    }
}
