package com.quoders.apps.madridbus;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.quoders.apps.madridbus.model.favorites.FavoriteBase;
import com.quoders.apps.madridbus.model.favorites.FavoriteDao;

@Database(entities = {FavoriteBase.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract FavoriteDao favoriteDao();
}
