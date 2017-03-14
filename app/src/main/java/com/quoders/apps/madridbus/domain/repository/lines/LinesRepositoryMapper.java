package com.quoders.apps.madridbus.domain.repository.lines;

import android.support.annotation.NonNull;
import android.util.Log;

import com.quoders.apps.madridbus.model.LineBase;
import com.quoders.apps.madridbus.model.TransportType;
import com.quoders.apps.madridbus.model.rest.LineInfoEmt;
import com.quoders.apps.madridbus.model.rest.ListLineInfoEmt;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

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

    public static List<LineBase> toList(@NonNull Iterable<LineBase> lineList) {
        List<LineBase> lines = new ArrayList<>();
        for (LineBase line : lineList) {
            lines.add(line);
        }
        return lines;
    }
}
