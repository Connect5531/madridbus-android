package com.quoders.apps.madridbus.model.favorites;


import com.quoders.apps.madridbus.model.LineBase;
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
    private LineBase lineBase;
    private String timeNext;


    public FavoriteBase(String id, StopBase stopBase, String stopName, LineBase lineBase) {
        this.id = id;
        this.stopBase = stopBase;
        this.stopName = stopName;
        this.lineBase = lineBase;
    }
    public FavoriteBase() {
        this.id = "";
        this.stopBase = new StopBase();
        this.stopName = "";
        this.lineBase = new LineBase();
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

    public LineBase getLineBase() {
        return lineBase;
    }

    public void setLineBase(LineBase lineBase) {
        this.lineBase = lineBase;
    }

    public String getTimeNext() {
        return timeNext;
    }

    public void setTimeNext(String timeNext) {
        this.timeNext = timeNext;
    }
}
