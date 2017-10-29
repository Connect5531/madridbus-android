package com.quoders.apps.madridbus.model.favorites;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface FavoriteDao {

    @Query("SELECT * FROM favorite")
    List<FavoriteBase> getAll();

    @Query("SELECT * FROM favorite WHERE id IN (:idList)")
    List<FavoriteBase> loadAllByIds(String[] idList);

    @Insert
    void insertAll(FavoriteBase... favorite);

    @Delete
    void delete(FavoriteBase user);
}
