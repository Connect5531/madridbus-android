
package com.quoders.apps.madridbus.model.arrivals;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Arrivals {

    @SerializedName("arrives")
    @Expose
    private List<Arrive> arrives = null;

    public List<Arrive> getArrives() {
        return arrives;
    }

    public void setArrives(List<Arrive> arrives) {
        this.arrives = arrives;
    }

}
