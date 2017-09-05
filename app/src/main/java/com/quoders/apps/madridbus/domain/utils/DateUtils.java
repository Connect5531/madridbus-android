package com.quoders.apps.madridbus.domain.utils;


import android.support.annotation.NonNull;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static @NonNull String getTodayShortFormat() {
        Date today = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        return format.format(today);
    }
}
