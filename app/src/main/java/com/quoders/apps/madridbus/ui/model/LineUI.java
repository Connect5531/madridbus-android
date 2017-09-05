package com.quoders.apps.madridbus.ui.model;

import com.quoders.apps.madridbus.model.StopBase;

import java.io.Serializable;
import java.util.List;

public class LineUI implements Serializable {

    private String code;
    private String nameA;
    private String nameB;
    private String shortName;
    private List<StopBase> route;

    public LineUI(String code, String nameA, String nameB, String shortName, int transportType) {
        this.code = code;
        this.nameA = nameA;
        this.nameB = nameB;
        this.shortName = shortName;
        this.transportType = transportType;
    }

    private int transportType;


    public String getCode() {
        return code;
    }

    public String getNameA() {
        return nameA;
    }

    public String getNameB() {
        return nameB;
    }

    public String getShortName() {
        return shortName;
    }

    public int getTransportType() {
        return transportType;
    }

    public List<StopBase> getRoute() {
        return route;
    }

    public void setRoute(List<StopBase> route) {
        this.route = route;
    }
}
