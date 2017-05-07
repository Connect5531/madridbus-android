package com.quoders.apps.madridbus.model;

import static com.quoders.apps.madridbus.model.TransportType.BUS;

public class StopBaseBuilder {
    private String name;
    private String code;
    private int transportType = BUS;
    private Double latitude;
    private Double longitude;
    private int distance = 0;
    private int distancePrevious = 0;
    private int order = 0;
    private String line = "";

    public StopBaseBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public StopBaseBuilder setCode(String code) {
        this.code = code;
        return this;
    }

    public StopBaseBuilder setTransportType(int transportType) {
        this.transportType = transportType;
        return this;
    }

    public StopBaseBuilder setLatitude(Double latitude) {
        this.latitude = latitude;
        return this;
    }

    public StopBaseBuilder setLongitude(Double longitude) {
        this.longitude = longitude;
        return this;
    }

    public StopBaseBuilder setDistance(int distance) {
        this.distance = distance;
        return this;
    }

    public StopBaseBuilder setDistancePrevious(int distancePrevious) {
        this.distancePrevious = distancePrevious;
        return this;
    }

    public StopBaseBuilder setOrder(int order) {
        this.order = order;
        return this;
    }

    public StopBaseBuilder setLine(String line) {
        this.line = line;
        return this;
    }

    public StopBase createStopBase() {
        return new StopBase(name, code, transportType, latitude, longitude, distance, distancePrevious, order, line);
    }
}