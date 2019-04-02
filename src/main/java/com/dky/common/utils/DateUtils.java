package com.dky.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
*describe: 时间工具类
*
*@author bowen
*@date 2018/5/3
*/
public class DateUtils {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private static DateUtils dateUtils;

    @PostConstruct
    public void init() {
        dateUtils = this;
    }

    /**
     * 获取当前时间所在年的周数
      */
    public static int getWeekOfYear(Date date) {
        Calendar c = new GregorianCalendar();
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.setMinimalDaysInFirstWeek(7);
        c.setTime(date);

        return c.get(Calendar.WEEK_OF_YEAR);
    }

    /**
     * 获取当前时间所在年的最大周数
     * @param year
     * @return
     */
    public static int getMaxWeekNumOfYear(int year) {
        Calendar c = new GregorianCalendar();
        c.set(year, Calendar.DECEMBER, 31, 23, 59, 59);

        return getWeekOfYear(c.getTime());
    }

    // 获取某年的第几周的开始日期
    public static Date getFirstDayOfWeek(int year, int week) {
        Calendar c = new GregorianCalendar();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, Calendar.JANUARY);
        c.set(Calendar.DATE, 1);

        Calendar cal = (GregorianCalendar) c.clone();
        cal.add(Calendar.DATE, week * 7);

        return getFirstDayOfWeek(cal.getTime());
    }

    // 获取某年的第几周的结束日期
    public static Date getLastDayOfWeek(int year, int week) {
        Calendar c = new GregorianCalendar();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, Calendar.JANUARY);
        c.set(Calendar.DATE, 1);

        Calendar cal = (GregorianCalendar) c.clone();
        cal.add(Calendar.DATE, week * 7);

        return getLastDayOfWeek(cal.getTime());
    }

    // 获取当前时间所在周的开始日期
    public static Date getFirstDayOfWeek(Date date) {
        Calendar c = new GregorianCalendar();
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek()); // Monday
        return c.getTime();
    }

    // 获取当前时间所在周的结束日期
    public static Date getLastDayOfWeek(Date date) {
        Calendar c = new GregorianCalendar();
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek() + 6); // Sunday
        return c.getTime();
    }

    // 获取某年的某周第几天的日期
    public static Date getDayDateOfWeek(int year, int week,int num) {
        Calendar c = new GregorianCalendar();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, Calendar.JANUARY);
        c.set(Calendar.DATE, 1);

        Calendar cal = (GregorianCalendar) c.clone();
        cal.add(Calendar.DATE, week * 7);

        return getDayDateOfWeek(cal.getTime(),num);
    }

    // 获取某年的某周第几天的日期
    public static Date getDayDateOfWeek(Date date,int num)
    {
        Calendar c = new GregorianCalendar();
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek() + num - 1); // Sunday
        return c.getTime();
    }

    //获取当前时间是一周的第几天
    public static int getDayNumofWeek(Date date)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        long whichDay = cal.get(Calendar.DAY_OF_WEEK);
        if(whichDay == 1){
            return 7;
        }else{
            return (int)whichDay-1;
        }
    }

    //获取当前年
    public static int getCurrentYear()
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        long year = cal.get(Calendar.YEAR);
        return (int)year;
    }

    //获取当前日期
    public static String getCurrentDate(){
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        return sdf.format(date);
    }

    //获取当前日期
    public static String getCurrentDateTime(){
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        return sdf.format(date);
    }

    //获取当前年月
    public static String getCurrentYearMonth(){
        SimpleDateFormat sdf =new SimpleDateFormat("yyyyMM");
        Date date = new Date();
        return sdf.format(date);
    }

    //获取上个月的年月
    public static String getLastYearMonth() {
        SimpleDateFormat sdf =new SimpleDateFormat("yyyyMM");
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, -1);
        return sdf.format(cal.getTime());
    }

    //获取去年的年份
    public static String getLastYear() {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.YEAR, -1);
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy");
        return sdf.format(cal.getTime());
    }

    //获取上个月的月
    public static String getLastMonth(int num) {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, num);
        SimpleDateFormat sdf =new SimpleDateFormat("MM");
        return sdf.format(cal.getTime());
    }

    //获取上个月的月
    public static String getCurrentMonth() {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        SimpleDateFormat sdf =new SimpleDateFormat("MM");
        return sdf.format(cal.getTime());
    }

    /**
     * 获取几天前日期
     * @param d
     * @param day
     * @return
     */
    public static String getDateBefore(Date d, int day){
        Calendar now = Calendar.getInstance();
        now.setTime(d);
        now.set(Calendar.DATE, now.get(Calendar.DATE) - day);
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(now.getTime());
    }

    //获取今天的开始时间
    public static Date getCurrentBeginDate(){
        String currentDate = getCurrentDate();
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = null;
        try {
            date = sdf.parse(currentDate+" 00:00:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    //时间字符串转Date()
    public static Date string2Date(String type,String dateStr){
        SimpleDateFormat sdf =new SimpleDateFormat(type);
        Date date = null;
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    //获取今天的结束时间
    public static Date getCurrentEndDate(){
        String currentDate = getCurrentDate();
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = null;
        try {
            date = sdf.parse(currentDate+" 23:59:59");
        }catch(ParseException e){
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 获取月份最后一天
     * @param year
     * @param month
     * @return
     */
    public static String getFinalDayOfMonth(int year,int month){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR,year);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.add(Calendar.DAY_OF_MONTH, -1);
        SimpleDateFormat sdf =new SimpleDateFormat("dd");
        return sdf.format(cal.getTime());
    }

    public static Date getDate4switch(int hour,int minute,int sec) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(calendar.SECOND, sec);
        return calendar.getTime();
    }

    public static String getYesterDay() {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(new Date());
        calendar.add(calendar.DATE,-1);//把日期往后增加一天.整数往后推,负数往前移动
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(calendar.getTime());
    }

    public static String getYesterDay(String type) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(new Date());
        calendar.add(calendar.DATE,-1);//把日期往后增加一天.整数往后推,负数往前移动
        SimpleDateFormat sdf =new SimpleDateFormat(type);
        return sdf.format(calendar.getTime());
    }

    public static String getYesterMonth(String type) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(new Date());
        calendar.add(calendar.MONTH,-1);//把月份往后增加一月.整数往后推,负数往前移动
        SimpleDateFormat sdf =new SimpleDateFormat(type);
        return sdf.format(calendar.getTime());
    }
    /**
     * 获取制定类型的当前日期
     * @param type
     * @return
     */
    public static String getCurrentDate(String type) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(new Date());
        SimpleDateFormat sdf =new SimpleDateFormat(type);
        return sdf.format(calendar.getTime());
    }

    //获取上个月的年月
    private static String lastMonthTest() {
        SimpleDateFormat sdf =new SimpleDateFormat("yyyyMM");
        Date date = null;
        try {
            date = sdf.parse("201701");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, -1);
        return sdf.format(cal.getTime());
    }

    /**
     * 获取某个时间的一年前的时间
     * @param dateStr
     * @param type
     * @return
     */
    public static String getLastYearDateOfStr(String dateStr,String type){
        SimpleDateFormat sdf =new SimpleDateFormat(type);
        Date date = null;
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.YEAR, -1);
        return sdf.format(cal.getTime());
    }


    /**
     * 获取某个时间的一月前的时间
     * @param dateStr
     * @param type
     * @return
     */
    public static String getLastMonthDateOfStr(String dateStr,String type){
        SimpleDateFormat sdf =new SimpleDateFormat(type);
        Date date = null;
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, -1);
        return sdf.format(cal.getTime());
    }

    //获取某个时间所在年份
    public static String getYearOfDateStr(String dateStr,String type){
        SimpleDateFormat sdf =new SimpleDateFormat(type);
        Date date = null;
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.YEAR)+"";
    }

    public static String getDate4SomeDay(String date,String dateType,int num,String resultDateType){
        SimpleDateFormat sdf1 =new SimpleDateFormat(dateType);
        Calendar calendar = new GregorianCalendar();
        try {
            calendar.setTime(sdf1.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        calendar.add(calendar.DATE,num);//把日期往后增加一天.整数往后推,负数往前移动
        SimpleDateFormat sdf =new SimpleDateFormat(resultDateType);
        return sdf.format(calendar.getTime());
    }

    /**
     * 获取月份最后一天
     * @param dateStr
     * @param type
     * @return
     */
    public static String getFinalDayOfDateStr(String dateStr,String type,String resultType){
        SimpleDateFormat sdf =new SimpleDateFormat(type);
        Date date = null;
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.add(Calendar.MONTH, 1);
        cal.add(Calendar.DAY_OF_MONTH, -1);
        SimpleDateFormat sdf2 =new SimpleDateFormat(resultType);
        return sdf2.format(cal.getTime());
    }

    public static String getOtherDateType(String dateStr,String type,String resultType){
        SimpleDateFormat sdf =new SimpleDateFormat(type);
        Date date = null;
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat sdf2 =new SimpleDateFormat(resultType);
        return sdf2.format(date);
    }

    //获取几个月的年月
    public static String getLastYearMonth(int num,String type) {
        SimpleDateFormat sdf =new SimpleDateFormat(type);
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, num);
        return sdf.format(cal.getTime());
    }

    public static String getLastDateOfStr(String dateStr, String type) {
        SimpleDateFormat sdf =new SimpleDateFormat(type);
        Date date = null;
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, -1);
        return sdf.format(cal.getTime());
    }
    //时间转换成字符串
    public static Object date2String(Date date, String type) {
        SimpleDateFormat sdf =new SimpleDateFormat(type);
        return sdf.format(date);
    }

    /**
     * 获取当前时间之前或之后几分钟
     * @param minute
     * @return
     */
    public static Date getDateByMinute(int minute) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, minute);
        return calendar.getTime();
    }

    public static void main(String[] args) {
        int year = 2016;
        int week = 27;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date today = new Date();
        Calendar c = new GregorianCalendar();
        c.setTime(today);
        System.out.println("当前时间:current date = " + sdf.format(today));
        System.out.println("当前第几周:getWeekOfYear = " + getWeekOfYear(today));
        System.out.println("年度总周数:getMaxWeekNumOfYear = " + getMaxWeekNumOfYear(year));
        System.out.println("本周第一天:getFirstDayOfWeek = " + sdf.format(getFirstDayOfWeek(year, week)));
        System.out.println("本周最后一天:getLastDayOfWeek = " + sdf.format(getLastDayOfWeek(year, week)));
        System.out.println("本周第一天:getFirstDayOfWeek = " + sdf.format(getFirstDayOfWeek(today)));
        System.out.println("本周最后一天:getLastDayOfWeek = " + sdf.format(getLastDayOfWeek(today)));
        System.out.println("今天是一周第几天:getDayNumofWeek = " + getDayNumofWeek(today));
        System.out.println("获取当前年:getCurrentYear = " + getCurrentYear());
        System.out.println(" 获取某年的某周第几天的日期:getDayDateOfWeek = " + getDayDateOfWeek(2016,16,3));
        System.out.println(" 获取当前日期:getCurrentDate = " + getCurrentDate());
        System.out.println(" 获取当前日期时间:getCurrentDateTime = " + getCurrentDateTime());
        System.out.println(" 获取当前开始日期:getCurrentBeginDate = " + getCurrentBeginDate());
        System.out.println(" 获取当前结束日期:getCurrentEndDate = " + getCurrentEndDate());
        System.out.println(" 之前日期:getDateBefore = " + getDateBefore(new Date(),2));
        System.out.println(" 当前年月:getCurrentYearMonth = " + getCurrentYearMonth());
        System.out.println(" 上个月年月:getLastYearMonth = " + getLastYearMonth());
        System.out.println(" 上个月月:getLastMonth = " + getLastMonth(-1));
        System.out.println(" 去年年份:getLastYear = " + getLastYear());
        System.out.println(" 昨天:getYesterDay = " + getYesterDay());
        System.out.println(" lastMonthTest = " + lastMonthTest());
        System.out.println(" getLastYearDateOfStr = " + getLastYearDateOfStr("201702","yyyyMM"));
        System.out.println(" getYearOfDateStr = " + getYearOfDateStr("201702","yyyyMM"));
        System.out.println(" getFinalDayOfDateStr = " + getFinalDayOfDateStr("201702","yyyyMM","yyyy-MM-dd"));
    }

}
