package com.quoders.apps.madridbus.model.favorites;


import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.quoders.apps.madridbus.model.StopEntity;


@Entity(tableName = "favorite")
public class FavoriteBase {

    @PrimaryKey @NonNull private String id;
    @Embedded private StopEntity stopEntity;
    private String stopName;
    private String timeNext;

    @Ignore
    public FavoriteBase(@NonNull String id, @NonNull StopEntity stopEntity, @NonNull String stopName) {
        this.id = id;
        this.stopEntity = stopEntity;
        this.stopName = stopName;
    }
    public FavoriteBase() {
        this.id = "";
        this.stopEntity = new StopEntity();
        this.stopName = "";
    }

    public StopEntity getStopEntity() {
        return stopEntity;
    }

    public String getStopName() {
        return stopName;
    }

    public String getId() {
        return id;
    }

    public String getTimeNext() {
        return timeNext;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setStopName(String stopName) {
        this.stopName = stopName;
    }

    public void setStopEntity(StopEntity stopEntity) {
        this.stopEntity = stopEntity;
    }

    public void setTimeNext(String timeNext) {
        this.timeNext = timeNext;
    }
}
