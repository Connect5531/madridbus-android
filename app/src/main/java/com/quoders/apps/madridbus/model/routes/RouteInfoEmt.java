
package com.quoders.apps.madridbus.model.routes;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RouteInfoEmt {

    @SerializedName("resultCode")
    @Expose
    private Integer resultCode;
    @SerializedName("resultDescription")
    @Expose
    private String resultDescription;
    @SerializedName("resultValues")
    @Expose
    private List<ResultValue> resultValues = null;

    public Integer getResultCode() {
        return resultCode;
    }

    public void setResultCode(Integer resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultDescription() {
        return resultDescription;
    }

    public void setResultDescription(String resultDescription) {
        this.resultDescription = resultDescription;
    }

    public List<ResultValue> getResultValues() {
        return resultValues;
    }

    public void setResultValues(List<ResultValue> resultValues) {
        this.resultValues = resultValues;
    }

}
