package com.quoders.apps.madridbus.model.favorites;


import com.quoders.apps.madridbus.model.StopBase;

import java.io.Serializable;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class FavoriteBase extends RealmObject implements Serializable {

    public static final String ID = "id";

    @PrimaryKey
    private String id;
    private String stopName;
    private StopBase stopBase;
    private String timeNext;


    public FavoriteBase(String id, StopBase stopBase, String stopName) {
        this.id = id;
        this.stopBase = stopBase;
        this.stopName = stopName;
    }
    public FavoriteBase() {
        this.id = "";
        this.stopBase = new StopBase();
        this.stopName = "";
    }

    public StopBase getStop() {
        return stopBase;
    }

    public String getName() {
        return stopName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setStopName(String stopName) {
        this.stopName = stopName;
    }

    public void setStopBase(StopBase stopBase) {
        this.stopBase = stopBase;
    }

    public String getTimeNext() {
        return timeNext;
    }

    public void setTimeNext(String timeNext) {
        this.timeNext = timeNext;
    }
}
