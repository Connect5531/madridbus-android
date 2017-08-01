
package com.quoders.apps.madridbus.model.arrivals;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Arrive {

    @SerializedName("stopId")
    @Expose
    private Integer stopId;
    @SerializedName("lineId")
    @Expose
    private String lineId;
    @SerializedName("isHead")
    @Expose
    private String isHead;
    @SerializedName("destination")
    @Expose
    private String destination;
    @SerializedName("busId")
    @Expose
    private String busId;
    @SerializedName("busTimeLeft")
    @Expose
    private Integer busTimeLeft;
    @SerializedName("busDistance")
    @Expose
    private Integer busDistance;
    @SerializedName("longitude")
    @Expose
    private Double longitude;
    @SerializedName("latitude")
    @Expose
    private Double latitude;
    @SerializedName("busPositionType")
    @Expose
    private Integer busPositionType;

    public Integer getStopId() {
        return stopId;
    }

    public void setStopId(Integer stopId) {
        this.stopId = stopId;
    }

    public String getLineId() {
        return lineId;
    }

    public void setLineId(String lineId) {
        this.lineId = lineId;
    }

    public String getIsHead() {
        return isHead;
    }

    public void setIsHead(String isHead) {
        this.isHead = isHead;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getBusId() {
        return busId;
    }

    public void setBusId(String busId) {
        this.busId = busId;
    }

    public Integer getBusTimeLeft() {
        return busTimeLeft;
    }

    public void setBusTimeLeft(Integer busTimeLeft) {
        this.busTimeLeft = busTimeLeft;
    }

    public Integer getBusDistance() {
        return busDistance;
    }

    public void setBusDistance(Integer busDistance) {
        this.busDistance = busDistance;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Integer getBusPositionType() {
        return busPositionType;
    }

    public void setBusPositionType(Integer busPositionType) {
        this.busPositionType = busPositionType;
    }

}
