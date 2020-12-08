package com.data.dormitory.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

/**
 * 公共方法类
 */
public class Tools {

    private static Logger LOGGER = LoggerFactory.getLogger(Tools.class);

    /**
     * 获取当前时间戳
     */
    public static Long getCurrentStamp() {
        return System.currentTimeMillis();
    }

    /**
     * 向yyyy-mm-dd转换
     */
    public static String getDate(Long dataStamp) {

        Date date = new Date(dataStamp);
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }

    /**
     * 获取当天日期
     */
    public static String getLocalDate() {

        LocalDate date = LocalDate.now();
        return String.valueOf(date);
    }

    /**
     * 将Date日期转换为Calender形式
     */
    public static Calendar getCal(String date) throws ParseException {

        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd"); //输入与上述字符串相同格式
        Date d = s.parse(date); //指定字符串转换为日期
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        return calendar;
    }

////方法 二
//Calendar.getInstance().getTimeInMillis();
////方法 三
//new Date().getTime();
}
