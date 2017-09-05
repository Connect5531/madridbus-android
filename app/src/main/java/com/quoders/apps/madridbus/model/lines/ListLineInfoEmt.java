
package com.quoders.apps.madridbus.model.lines;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ListLineInfoEmt {

    @SerializedName("resultCode")
    @Expose
    private Integer resultCode;
    @SerializedName("resultDescription")
    @Expose
    private String resultDescription;
    @SerializedName("resultValues")
    @Expose
    private List<LineInfoEmt> resultValues;

    public ListLineInfoEmt() {
        resultValues = new ArrayList<>();
    }

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

    public List<LineInfoEmt> getResultValues() {
        return resultValues;
    }

    public void setResultValues(List<LineInfoEmt> resultValues) {
        this.resultValues = resultValues;
    }

}
