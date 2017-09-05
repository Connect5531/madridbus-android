package com.quoders.apps.madridbus.domain.repository.favorites;

import android.support.annotation.NonNull;

import com.quoders.apps.madridbus.model.LineBase;
import com.quoders.apps.madridbus.model.TransportType;
import com.quoders.apps.madridbus.model.favorites.FavoriteBase;
import com.quoders.apps.madridbus.model.lines.LineInfoEmt;
import com.quoders.apps.madridbus.model.lines.ListLineInfoEmt;

import java.util.ArrayList;
import java.util.List;

public class FavoritesRepositoryMapper {

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

    public static List<FavoriteBase> toUIList(Iterable<FavoriteBase> favorites) {
        List<FavoriteBase> favoritesList = new ArrayList<>();
        for (FavoriteBase favorite : favorites) {
            favoritesList.add(new FavoriteBase(favorite.getId(), favorite.getStop(), favorite.getName()));
        }
        return favoritesList;
    }

    /*public static List<StopBase§> toUIList(@NonNull Iterable<FavoriteBase> favorites) {
        List<FavoriteBase> favoritesList = new ArrayList<>();
        for (FavoriteBase line : favorites) {
            //lines.add(new LineUI(line.getCode(), line.getNameA(), line.getNameB(), line.getShortName(), line.getTransportType()));
        }
        return favoritesList;
    }*/
}
