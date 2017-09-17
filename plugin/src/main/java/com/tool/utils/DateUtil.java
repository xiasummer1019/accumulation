package com.tool.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by XM on 2017/9/12.
 */
public class DateUtil {
    /**
     * 格式化时间  *
     * @return
     */
    public static String formatDate(Date date, String pattern) {
        SimpleDateFormat sdf=new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    /**
     * 获得当前时间     *
     * @return
     */
    public static String getDate(String pattern) {
        Calendar cale  = Calendar.getInstance();
        //cale.add(Calendar.MONTH, 1);
        SimpleDateFormat sdf=new SimpleDateFormat(pattern);
        return sdf.format(cale.getTime());
    }
}
