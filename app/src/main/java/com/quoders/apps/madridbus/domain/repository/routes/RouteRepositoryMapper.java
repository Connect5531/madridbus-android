package com.quoders.apps.madridbus.domain.repository.routes;

import android.support.annotation.NonNull;

import com.quoders.apps.madridbus.model.LineBase;
import com.quoders.apps.madridbus.model.StopBase;
import com.quoders.apps.madridbus.model.StopBaseBuilder;
import com.quoders.apps.madridbus.model.routes.ResultValue;
import com.quoders.apps.madridbus.model.routes.RouteInfoEmt;
import com.quoders.apps.madridbus.ui.model.LineUI;

import java.util.ArrayList;
import java.util.List;

public class RouteRepositoryMapper {

    public static List<StopBase> map(@NonNull RouteInfoEmt emtInfoList) {
        List<StopBase> route = new ArrayList<>();
        if(emtInfoList != null && emtInfoList.getResultValues() != null) {
            for (ResultValue resultValue : emtInfoList.getResultValues()) {
                StopBase stop = new StopBaseBuilder()
                        .setLine(resultValue.getLine().toString())
                        .setCode(resultValue.getNode().toString())
                        .setName(resultValue.getName())
                        .setLatitude(resultValue.getLatitude())
                        .setLongitude(resultValue.getLongitude())
                        .setDistancePrevious(resultValue.getDistancePreviousStop())
                        .setDistance(resultValue.getDistance())
                        .createStopBase();
                route.add(stop);
            }
        }
        return route;
    }

    public static List<LineUI> toUIList(@NonNull Iterable<LineBase> lineList) {
        List<LineUI> lines = new ArrayList<>();
        for (LineBase line : lineList) {
            lines.add(new LineUI(line.getCode(), line.getNameA(), line.getNameB(), line.getShortName(), line.getTransportType()));
        }
        return lines;
    }
}
