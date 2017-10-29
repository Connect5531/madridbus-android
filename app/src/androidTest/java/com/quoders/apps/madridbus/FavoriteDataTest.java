package com.quoders.apps.madridbus;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.SmallTest;
import android.support.test.runner.AndroidJUnit4;

import com.quoders.apps.madridbus.model.StopBase;
import com.quoders.apps.madridbus.model.StopEntity;
import com.quoders.apps.madridbus.model.favorites.FavoriteBase;
import com.quoders.apps.madridbus.model.favorites.FavoriteDao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.List;

import static junit.framework.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
@SmallTest
public class FavoriteDataTest {

    private FavoriteDao mFavoriteDao;
    private AppDatabase mDb;

    @Before
    public void setUp() {
        Context context = InstrumentationRegistry.getTargetContext();
        mDb = Room.inMemoryDatabaseBuilder(context, AppDatabase.class).build();
        mFavoriteDao = mDb.favoriteDao();
    }

    @After
    public void finishTests() throws IOException {
        mDb.close();
    }

    @Test
    public void writeFavoriteAndReadInList() {
        FavoriteBase favorite = new FavoriteBase("favorite1", new StopEntity("1234", "Gran Via 12"), "Gran Via 12");
        mFavoriteDao.insertAll(favorite);
        List<FavoriteBase> favorites = mFavoriteDao.getAll();

        FavoriteBase readFavorite = favorites.get(0);

        assertEquals(readFavorite.getId(), favorite.getId());
        assertEquals(readFavorite.getStopName(), favorite.getStopName());
        assertEquals(readFavorite.getStopEntity().getCode(), favorite.getStopEntity().getCode());
        assertEquals(readFavorite.getStopEntity().getName(), favorite.getStopEntity().getName());
    }
}