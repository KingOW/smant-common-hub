package com.smant.common.core.utils;

import com.smant.common.core.enums.DatePattern;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间工具类
 */
public final class DateUtils {

    /**
     * 获取当天日期
     *
     * @return
     */
    public static String formatCurrentDate() {
        return formatCurrentDate(DatePattern.YYYY_MM_DD);
    }

    public static String formatCurrentDate(DatePattern datePattern) {
        if (datePattern == null) {
            datePattern = DatePattern.YYYY_MM_DD;
        }
        SimpleDateFormat format = new SimpleDateFormat(datePattern.getValue());
        return format.format(new Date());
    }

    public static String formatDate(Date date) {
        return formatDate(date,DatePattern.YYYY_MM_DD);
    }

    public static String formatDate(Date date, DatePattern datePattern) {
        if (date == null) {
            date = new Date();
        }
        if (datePattern == null) {
            datePattern = DatePattern.YYYY_MM_DD;
        }
        SimpleDateFormat format = new SimpleDateFormat(datePattern.getValue());
        return format.format(date);
    }

    public static Date currentDate(){
        return new Date();
    }

}
