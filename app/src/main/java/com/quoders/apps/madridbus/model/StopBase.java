package com.quoders.apps.madridbus.model;

import java.util.List;

public class StopBase {

    private String name;
    private String code;
    private TransportType transportType;
    private List<LineBase> lines;

    public StopBase(String name, String code, TransportType transportType, List<LineBase> lines) {
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

    public TransportType getTransportType() {
        return transportType;
    }

    public List<LineBase> getLines() {
        return lines;
    }
}
