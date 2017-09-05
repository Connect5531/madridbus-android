package com.quoders.apps.madridbus.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class StopBase extends RealmObject {

    public static final String ID = "code";

    @PrimaryKey
    private String code;

    private String name;
    private int transportType;
    private Double latitude;
    private Double longitude;
    private int distance;
    private int distancePrevious;
    private int order;
    private String line;


    public StopBase(String name, String code, int transportType, Double latitude, Double longitude,
                    int distance, int distancePrevious, int order, String line) {
        this.name = name;
        this.code = code;
        this.transportType = transportType;
        this.latitude = latitude;
        this.longitude = longitude;
        this.distance = distance;
        this.distancePrevious = distancePrevious;
        this.order = order;
        this.line = line;
    }

    public StopBase() {
        this.name = "";
        this.code = "";
        this.transportType = TransportType.BUS;
        this.latitude = 0d;
        this.longitude = 0d;
        this.distance = 0;
        this.distancePrevious = 0;
        this.order = 0;
        this.line = "";
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public int getDistance() {
        return distance;
    }

    public int getDistancePrevious() {
        return distancePrevious;
    }

    public int getOrder() {
        return order;
    }

    public String getLine() {
        return line;
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
}
