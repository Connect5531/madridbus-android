package com.quoders.apps.madridbus.model;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class LineBase extends RealmObject {

    public static final String CODE = "code";
    
    @PrimaryKey
    private String code;
    private String name;
    private String shortName;
    private RealmList<StopBase> stops;
    private int transportType;

    public LineBase(String name, String shortName, String code, RealmList<StopBase> stops, int transportType) {
        this.name = name;
        this.shortName = shortName;
        this.code = code;
        this.stops = stops;
        this.transportType = transportType;
    }

    public LineBase() {
        code = "";
        name = "";
        shortName = "";
        stops = new RealmList<>();
        transportType = TransportType.BUS;
    }

    public String getName() {
        return name;
    }

    public String getShortName() {
        return shortName;
    }

    public String getCode() {
        return code;
    }

    public RealmList<StopBase> getStops() {
        return stops;
    }

    public int getTransportType() {
        return transportType;
    }
}
