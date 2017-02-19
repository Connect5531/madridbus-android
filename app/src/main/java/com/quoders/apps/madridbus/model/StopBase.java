package com.quoders.apps.madridbus.model;

import io.realm.RealmList;
import io.realm.RealmObject;

public class StopBase extends RealmObject {

    private String name;
    private String code;
    private int transportType;
    private RealmList<LineBase> lines;

    public StopBase() {
        this.name = "";
        this.code = "";
        this.transportType = TransportType.BUS;
        this.lines = new RealmList<>();
    }

    public StopBase(String name, String code, int transportType, RealmList<LineBase> lines) {
        this.name = name;
        this.code = code;
        this.transportType = transportType;
        this.lines = lines;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public int getTransportType() {
        return transportType;
    }

    public RealmList<LineBase> getLines() {
        return lines;
    }
}
