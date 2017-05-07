package com.quoders.apps.madridbus.domain.repository.lines;

import android.support.annotation.NonNull;

import com.quoders.apps.madridbus.model.LineBase;
import com.quoders.apps.madridbus.model.TransportType;
import com.quoders.apps.madridbus.model.lines.LineInfoEmt;
import com.quoders.apps.madridbus.model.lines.ListLineInfoEmt;
import com.quoders.apps.madridbus.ui.model.LineUI;

import java.util.ArrayList;
import java.util.List;

public class LinesRepositoryMapper {

    public static List<LineBase> map(@NonNull ListLineInfoEmt emtInfoList) {
        List<LineBase> lines = new ArrayList<>();
        if(emtInfoList != null && emtInfoList.getResultValues() != null) {
            for (LineInfoEmt lineInfoEmt : emtInfoList.getResultValues()) {
                LineBase line = new LineBase(removeEndSpaces(lineInfoEmt.getNameA()),
                        removeEndSpaces(lineInfoEmt.getNameB()), lineInfoEmt.getLabel(),
                        lineInfoEmt.getLine(), null, TransportType.BUS);
                lines.add(line);
            }
        }
        return lines;
    }

    private static String removeEndSpaces(@NonNull String string) {
        return string.replaceAll("\\s+$", "");
    }

    public static List<LineUI> toUIList(@NonNull Iterable<LineBase> lineList) {
        List<LineUI> lines = new ArrayList<>();
        for (LineBase line : lineList) {
            lines.add(new LineUI(line.getCode(), line.getNameA(), line.getNameB(), line.getShortName(), line.getTransportType()));
        }
        return lines;
    }
}
