
package com.quoders.apps.madridbus.model.routes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResultValue {

    @SerializedName("line")
    @Expose
    private Integer line;
    @SerializedName("secDetail")
    @Expose
    private Integer secDetail;
    @SerializedName("orderDetail")
    @Expose
    private String orderDetail;
    @SerializedName("node")
    @Expose
    private Integer node;
    @SerializedName("distance")
    @Expose
    private Integer distance;
    @SerializedName("distancePreviousStop")
    @Expose
    private Integer distancePreviousStop;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("latitude")
    @Expose
    private Double latitude;
    @SerializedName("longitude")
    @Expose
    private Double longitude;

    public Integer getLine() {
        return line;
    }

    public void setLine(Integer line) {
        this.line = line;
    }

    public Integer getSecDetail() {
        return secDetail;
    }

    public void setSecDetail(Integer secDetail) {
        this.secDetail = secDetail;
    }

    public String getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(String orderDetail) {
        this.orderDetail = orderDetail;
    }

    public Integer getNode() {
        return node;
    }

    public void setNode(Integer node) {
        this.node = node;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Integer getDistancePreviousStop() {
        return distancePreviousStop;
    }

    public void setDistancePreviousStop(Integer distancePreviousStop) {
        this.distancePreviousStop = distancePreviousStop;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

}
