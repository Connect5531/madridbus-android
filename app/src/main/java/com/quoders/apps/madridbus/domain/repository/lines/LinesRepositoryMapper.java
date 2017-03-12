package com.quoders.apps.madridbus.domain.repository.lines;

import android.support.annotation.NonNull;

import com.quoders.apps.madridbus.model.LineBase;
import com.quoders.apps.madridbus.model.rest.ListLineInfoEmt;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

public class LinesRepositoryMapper {

    public static List<LineBase> map(@NonNull Observable<ListLineInfoEmt> query) {

        return null;
    }

    public static List<LineBase> toList(@NonNull Iterable<LineBase> lineList) {
        List<LineBase> lines = new ArrayList<>();
        for (LineBase line : lineList) {
            lines.add(line);
        }
        return lines;
    }
}
