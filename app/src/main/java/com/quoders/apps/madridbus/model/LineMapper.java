package com.quoders.apps.madridbus.model;

import com.quoders.apps.madridbus.model.lines.LineInfoEmt;
import com.quoders.apps.madridbus.model.lines.ListLineInfoEmt;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmList;

public class LineMapper {

    public static LineBase MAP(LineInfoEmt lineInfoEmt) {
        return new LineBase(lineInfoEmt.getNameA(), lineInfoEmt.getNameB(),
                lineInfoEmt.getLabel(), lineInfoEmt.getLine(), new RealmList<StopBase>(), TransportType.BUS);
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
