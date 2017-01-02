
package com.quoders.apps.madridbus.model.rest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LineInfoEmt {

    @SerializedName("groupNumber")
    @Expose
    private String groupNumber;
    @SerializedName("dateFirst")
    @Expose
    private String dateFirst;
    @SerializedName("dateEnd")
    @Expose
    private String dateEnd;
    @SerializedName("line")
    @Expose
    private String line;
    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("nameA")
    @Expose
    private String nameA;
    @SerializedName("nameB")
    @Expose
    private String nameB;

    public String getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(String groupNumber) {
        this.groupNumber = groupNumber;
    }

    public String getDateFirst() {
        return dateFirst;
    }

    public void setDateFirst(String dateFirst) {
        this.dateFirst = dateFirst;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getNameA() {
        return nameA;
    }

    public void setNameA(String nameA) {
        this.nameA = nameA;
    }

    public String getNameB() {
        return nameB;
    }

    public void setNameB(String nameB) {
        this.nameB = nameB;
    }

}
