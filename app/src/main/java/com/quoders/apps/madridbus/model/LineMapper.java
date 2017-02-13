package com.quoders.apps.madridbus.model;

import com.quoders.apps.madridbus.model.rest.LineInfoEmt;
import com.quoders.apps.madridbus.model.rest.ListLineInfoEmt;

import java.util.ArrayList;
import java.util.List;

public class LineMapper {

    public static LineBase MAP(LineInfoEmt lineInfoEmt) {
        return new LineBase(lineInfoEmt.getNameA(), lineInfoEmt.getNameB(),
                lineInfoEmt.getLine(), new ArrayList<StopBase>(), TransportType.BUS);
    }

    public static List<LineBase> MAP(ListLineInfoEmt listLineInfoEmt) {
        final List<LineInfoEmt> linesEmt = listLineInfoEmt.getResultValues();
        List<LineBase> linesList = new ArrayList<>(linesEmt.size());
        for (LineInfoEmt lineInfoEmt : linesEmt) {
            linesList.add(MAP(lineInfoEmt));
        }
        return linesList;
    }
}
