package com.quoders.apps.madridbus.model;

import java.util.List;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class LineBase extends RealmObject {

    public static final String CODE = "code";
    
    @PrimaryKey
    private String code;
    private String name;
    private String shortName;
    private List<StopBase> stops;
    private TransportType transportType;

    public LineBase(String name, String shortName, String code, List<StopBase> stops, TransportType transportType) {
        this.name = name;
        this.shortName = shortName;
        this.code = code;
        this.stops = stops;
        this.transportType = transportType;
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

    public List<StopBase> getStops() {
        return stops;
    }

    public TransportType getTransportType() {
        return transportType;
    }
}
