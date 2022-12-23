package com.universe.spring.util;

import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间工具类
 * @author lx
 *
 */
public class DateUtil {

    /** format */
    public static final String DATE_TIME_STAMP = "yyyy-MM-dd HH:mm:ss.SSS";
    public static final String DATE_TIME = "yyyy-MM-dd HH:mm:ss";
    public static final String YYYY_MM_DD = "yyyy-MM-dd";
    public static final String YYYYMMDD = "yyyyMMdd";
    public static final String YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";
    public static final String YYYY_MM_DD_YEAR = "yyyy年-MM月-dd日";
    public final static String MM_DD = "MM月dd日";
    public final static String MMDD = "MMdd";
    public static final String HH_MM = "HH:mm";
    private final static String[] weeks = {"星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"};

    private final static long DAY = 24 * 60 * 60 * 1000;
    private final static long HOUR = 60 * 60 * 1000;
    private final static long MINUTE = 60 * 1000;
    private final static String DIFF_TIME_DAY_STR = "%s天%s小时%s分钟";
    private final static String DIFF_TIME_HOUR_STR = "%s小时%s分钟";
    private final static String DIFF_TIME_MINUTE_STR = "%s分钟";


    public static void main(String[] args) {
//        System.out.println(format(new Date(),DATE_TIME));
//        System.out.println(getDiffTime(new Date(1671258855000L),null));
//        System.out.println(getDay(new Date()));
        System.out.println(addTime(new Date(),1,Calendar.DAY_OF_MONTH));
        System.out.println(getLastTimeOfMonth(new Date()));
    }

    /**
     * 格式化 date to String
     *
     * @param date
     * @param pattern
     * @return
     */
    public static String format(Date date, String pattern) {
        return new SimpleDateFormat(pattern).format(date);
    }

    /**
     * 计算时间差，得出指定的格式。afterDate可为空，如果为空则按照当前时间计算时间差
     * @param beforeDate
     * @param afterDate
     * @return
     */
    public static String getDiffTime(Date beforeDate, Date afterDate) {

        if (beforeDate == null) {
            return null;
        }
        if (afterDate == null) {
            afterDate = new Date();
        }

        long diff = afterDate.getTime() - beforeDate.getTime();
        if (diff < 0) {
            return null;
        }

        long day, hour, minute;
        day = diff / DAY;
        hour = (diff - day * DAY) / HOUR;
        minute = (diff - day * DAY - hour * HOUR) / MINUTE;
        if (day == 0) {
            if (hour == 0) {
                return String.format(DIFF_TIME_MINUTE_STR, minute);
            }
            return String.format(DIFF_TIME_HOUR_STR, hour, minute);
        }
        return String.format(DIFF_TIME_DAY_STR, day, hour, minute);
    }

    /**
     * 获取当前日期 X日
     * @param date
     * @return
     */
    public static int getDay(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DATE);
    }

    /**
     * Date 加减 时间
     *
     * @param date
     * @param duration
     * @param dateType Calendar.SECOND;Calendar.MINUTE;Calendar.HOUR;
     * @return
     */
    public static Date addTime(Date date, int duration, int dateType) {
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
        rightNow.add(dateType, duration);
        return rightNow.getTime();
    }

    /**
     * 获取某月的最后时刻
     * @param date
     * @return
     */
    public static Date getLastTimeOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH,cal.getActualMaximum(Calendar.DATE));
        cal.set(Calendar.HOUR_OF_DAY,cal.getActualMaximum(Calendar.HOUR_OF_DAY));
        cal.set(Calendar.MINUTE,cal.getActualMaximum(Calendar.MINUTE));
        cal.set(Calendar.SECOND,cal.getActualMaximum(Calendar.SECOND));
        cal.set(Calendar.MILLISECOND,0);
        return  cal.getTime();
    }

    /**
     * 获取某月的最早时刻
     * @param date
     * @return
     */
    public static Date getFirstTimeOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH,cal.getMinimum(Calendar.DATE));
        cal.set(Calendar.HOUR_OF_DAY,cal.getMinimum(Calendar.HOUR_OF_DAY));
        cal.set(Calendar.MINUTE,cal.getMinimum(Calendar.MINUTE));
        cal.set(Calendar.SECOND,cal.getMinimum(Calendar.SECOND));
        cal.set(Calendar.MILLISECOND,0);
        return   cal.getTime();
    }

    /**
     * 日期按照格式进行格式化
     *
     * @param date
     * @param pattern
     * @return
     */
    public static String DateToString(Date date, String pattern) {
        return date == null ? null : format(date,pattern);
    }


    /**
     * 判断指定时间是否在某个时段(双开区间)
     * @param startTime 开始时间(格式:10:00:00)
     * @param endTime 结束时间(格式:12:00:00)
     * @param compareTime 判断时间(格式:11:00:00)
     */
    public static boolean isWhetherMiddle(String startTime, String endTime, String compareTime) {
        if (StringUtils.isBlank(startTime) || StringUtils.isBlank(endTime) || StringUtils.isBlank(compareTime)) {
            return Boolean.FALSE;
        }
        LocalTime st = LocalTime.parse(startTime);
        LocalTime et = LocalTime.parse(endTime);
        LocalTime ct = LocalTime.parse(compareTime);

        if (ct.isBefore(st)) {
            return Boolean.FALSE;
        }

        if (ct.isAfter(et)) {
            return Boolean.FALSE;
        }

        if (ct.isAfter(st) && ct.isBefore(et)) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

}
