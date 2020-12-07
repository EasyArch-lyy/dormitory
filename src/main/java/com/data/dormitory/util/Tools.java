package com.data.dormitory.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Calendar;

/**
 * 公共方法类
 */
public class Tools {

    private static Logger LOGGER = LoggerFactory.getLogger(Tools.class);

    public static Long getCurrentTimestamp(){
        return System.currentTimeMillis();
    }

    public static void main(String[] args) {

        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(calendar.HOUR_OF_DAY);
        System.out.println(hour);
    }

    /**
     * 获取当前日期
     * @return Calendar
     */
    public static Calendar getToday() {

        return Calendar.getInstance();
    }

    /**
     * 获取当前时间戳
     */
    public Long getCurrentStamp() {
        return System.currentTimeMillis();
    }
////方法 二
//Calendar.getInstance().getTimeInMillis();
////方法 三
//new Date().getTime();
}
