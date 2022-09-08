/**
 * @FileName: DateTimeUtils.java
 * @Package com.sfbest.fss.common.utils
 * 
 * @author Administrator
 * @created 2015年6月16日 下午4:24:12
 * 
 * Copyright 2011-2015 顺丰优选 版权所有
 */
package com.sfbest.optimize.batch.utils;


import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>日期时间工具类</p>
 * 
 * <PRE>
 * <BR>	修改记录
 * <BR>-----------------------------------------------
 * <BR>	修改日期			修改人			修改内容
 * </PRE>
 * 
 * @author 738803 董玉帅
 * @since 1.0
 * @version 1.0
 */
public class DateTimeUtils {
	private static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private static final SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
	/**
	 * 上月第一天
	 *
	 * @author 738803 董玉帅
	 * @created 2015年5月1日 上午11:51:35
	 *
	 * @return
	 */
	public static Date getFirstDayOfPreviousMonth() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, - 1);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND,0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	/**
	 * 上月最后一天
	 *
	 * @author 738803 董玉帅
	 * @created 2015年5月1日 上午11:51:14
	 *
	 * @return
	 */
	public static Date getLastDayOfPreviousMonth() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, - 1);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND,59);
		calendar.set(Calendar.MILLISECOND, 999);

		return calendar.getTime();
	}

	public static Date getVoucherDate(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND,59);
        if(calendar.get(Calendar.DAY_OF_MONTH)>4){
            calendar.add(Calendar.DAY_OF_MONTH,-1);
            return calendar.getTime();
        }else{
            calendar.add(Calendar.MONTH,-1);
            calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
            calendar.set(Calendar.HOUR_OF_DAY, 23);
            calendar.set(Calendar.MINUTE, 59);
            calendar.set(Calendar.SECOND,59);
        }
        return calendar.getTime();
    }

    /**
     * 本月第一天
     * @return
     */
    public static Date getFirstDayOfNowMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND,0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 本月最后一天
     * @return
     */
    public static Date getLastDayOfNowMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND,59);
        calendar.set(Calendar.MILLISECOND, 999);

        return calendar.getTime();
    }

    /**
     * 本月15号 23:59:59
     * @return
     */
    public static Date get15DayOfNowMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 15);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND,59);
        calendar.set(Calendar.MILLISECOND, 999);

        return calendar.getTime();
    }
    /**
     * 上月16号 00:00:00
     * @return
     */
    public static Date get16DayOfPreviousMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, - 1);
        calendar.set(Calendar.DAY_OF_MONTH, 16);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND,0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

	/**
	 * 本年的第一天
	 */
	public static Date getFirstDayOfNowYear() {
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		calendar.clear();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND,0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	/**
	 * 本年的最后一天
	 */
	public static Date getLastDayOfNowYear() {
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		calendar.clear();
		calendar.set(Calendar.YEAR, year);
		calendar.roll(Calendar.DAY_OF_YEAR, -1);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND,59);
		calendar.set(Calendar.MILLISECOND, 999);
		return calendar.getTime();
	}

	/**
	 * 昨天的23点59分59秒
	 *
	 * @author 738803 董玉帅
	 * @created 2015年5月1日 上午11:51:14
	 *
	 * @return
	 */
	public static Date getLastTimeOfYesterday() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, - 1);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND,59);
		calendar.set(Calendar.MILLISECOND, 999);

		return calendar.getTime();
	}
	
	/**
	 * 昨天的23点59分59秒
	 *
	 * @author 738803 董玉帅
	 * @created 2015年5月1日 上午11:51:14
	 *
	 * @return
	 */
	public static Integer getLastTimeOfYesterday(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, - 1);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND,59);
		calendar.set(Calendar.MILLISECOND, 999);
		return (int) (calendar.getTime().getTime()/1000);
	}

    /**
     * 昨天的23点59分59秒
     * @return
     */
    public static String getLastTimeOfYesterday2Str() {
        return formatDate2Str(getLastTimeOfYesterday(), DATEPATTERN.YYYY_MM_DD_HH_mm_ss);
    }

	/**
	 * 昨天的0点0分0秒
	 *
	 * @author 738803 董玉帅
	 * @created 2015年5月1日 上午11:51:35
	 *
	 * @return
	 */
	public static Date getBeginTimeOfYesterday() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND,0);
		calendar.set(Calendar.MILLISECOND, 0);

		return calendar.getTime();
	}

    /**
     * 昨天的0点0分0秒
     * @return
     */
    public static String getBeginTimeOfYesterday2Str() {
        return formatDate2Str(getBeginTimeOfYesterday(), DATEPATTERN.YYYY_MM_DD_HH_mm_ss);
    }

    /**
	 * 获得当前日期秒数，精确到小时
	 *
	 * @author 855462
	 * @created 2015年8月18日 下午3:28:41
	 *
	 * @return
	 */
	public static Integer getSecondOfCurrentHour(){
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND,0);
		calendar.set(Calendar.MILLISECOND, 0);
		return new Long(calendar.getTimeInMillis()/1000L).intValue();
	}
	
	public  static Calendar getCalendarFromSecond(long second){
		Calendar startCalendar=Calendar.getInstance();
		startCalendar.setTimeInMillis(second*1000);
		return startCalendar;
	}

    public static int getSameSecondsOfNextMonth(int sec) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(sec * 1000L);
        c.add(Calendar.MONTH, 1);
        return (int) (c.getTimeInMillis() / 1000L);
    }

    public static int getLastSecondsOfMonth(int sec) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(sec * 1000L);
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND,59);
        return (int) (c.getTimeInMillis() / 1000L);
    }

    /**
     * 获得商家业务初始日期,2015-05-01
     * @return
     */
    public static int getInitialPlatformBusinessTime(){
        Calendar c = Calendar.getInstance();
        c.set(2015,4,1);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND,0);
        c.set(Calendar.MILLISECOND, 0);
        return (int) (c.getTimeInMillis() / 1000L);
    }

    /**
     * Description:	获取指定日期的最早时间<br>
     * @param date 指定的日期
     * @return int类型时间
     */
    public static Integer getDayLatestTime(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return new Long(calendar.getTime().getTime()/ 1000L).intValue();
    }

    /**
     *
     * @param sec
     * @return 半夜 00:00:00
     */
    public static Integer getDayBeginTime(Integer sec){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(sec*1000L);
        setMinHms(calendar);
        return new Long(calendar.getTime().getTime()/ 1000L).intValue();
    }

    /**
     *
     * @param sec
     * @return 半夜 23:59:59
     */
    public static Integer getDayEndTime(Integer sec) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(sec * 1000L);
        setMaxHms(calendar);
        return new Long(calendar.getTime().getTime() / 1000L).intValue();
    }

    public static Integer getHalfMonthBeginTime(Integer sec){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(sec*1000L);
        setMinHms(calendar);
        if(calendar.get(Calendar.DAY_OF_MONTH) <=15){
            calendar.set(Calendar.DATE,1);
        }else{
            calendar.set(Calendar.DATE,16);
        }
        return new Long(calendar.getTime().getTime() / 1000L).intValue();
    }

    public static Integer getHalfMonthEndTime(Integer sec) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(sec * 1000L);
        setMaxHms(calendar);
        if(calendar.get(Calendar.DAY_OF_MONTH) <=15){
            calendar.set(Calendar.DATE,15);
        }else{
            calendar.set(Calendar.DATE,calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        }
        return new Long(calendar.getTime().getTime() / 1000L).intValue();
    }

    public static Integer getMonthBeginTime(Integer sec){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(sec*1000L);
        setMinHms(calendar);
        calendar.set(Calendar.DATE,1);
        return new Long(calendar.getTime().getTime() / 1000L).intValue();
    }

	public static Integer getMonthEndTime(Integer sec) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(sec * 1000L);
		calendar.add(Calendar.MONTH, 1);
		calendar.set(Calendar.DATE, 1);
		calendar.add(Calendar.DATE, -1);
		setMaxHms(calendar);
		return new Long(calendar.getTime().getTime() / 1000L).intValue();
	}

    public static Integer getWeekBeginTime(Integer sec){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(sec*1000L);
        setMinHms(calendar);
        if(calendar.get(Calendar.DAY_OF_MONTH) <=7){
            calendar.set(Calendar.DATE,1);
        }else if(calendar.get(Calendar.DAY_OF_MONTH) <=14){
            calendar.set(Calendar.DATE,8);
        }
        else if(calendar.get(Calendar.DAY_OF_MONTH) <=21){
            calendar.set(Calendar.DATE,15);
        }
        else {
            calendar.set(Calendar.DATE,22);
        }
        return new Long(calendar.getTime().getTime() / 1000L).intValue();
    }

    public static Integer getWeekEndTime(Integer sec) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(sec * 1000L);
        setMaxHms(calendar);
        if(calendar.get(Calendar.DAY_OF_MONTH) <=7){
            calendar.set(Calendar.DATE,7);
        }else if(calendar.get(Calendar.DAY_OF_MONTH) <=14){
            calendar.set(Calendar.DATE,14);
        }
        else if(calendar.get(Calendar.DAY_OF_MONTH) <=21){
            calendar.set(Calendar.DATE,21);
        }
        else {
            calendar.set(Calendar.DATE,calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        }
        return new Long(calendar.getTime().getTime() / 1000L).intValue();
    }

    public static void setMaxHms(Calendar calendar){
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
    }
    private static void setMinHms(Calendar calendar){
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND,0);
        calendar.set(Calendar.MILLISECOND, 0);
    }

    /**
     * 获取传入日期 秒数
     *
     * @param date
     * @return
     */
    public static long getTimeSeconds(Date date) {
        GregorianCalendar cal1 = new GregorianCalendar();
        cal1.setTime(date);
        int year = cal1.get(Calendar.YEAR);
        int month = cal1.get(Calendar.MONTH) + 1;
        int day = cal1.get(Calendar.DATE);
        long l = 0l;
        GregorianCalendar cal = new GregorianCalendar();
        try {
            cal.setTime(dateFormat.parse(year + "-" + month + "-" + day + " 00:00:00"));
            l = cal.getTimeInMillis() / 1000;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return l;
    }

    /**
     * 根据输入的日期字符串 和 提前天数 ， 获得 指定日期提前几天的日期对象
     *
     * @param
     *             ，格式如 1-31-1900
     * @param
     *
     * @return 指定日期倒推指定天数后的日期对象
     * @throws ParseException
     */
    public static Date getAddOrReduceDate(Date inputDate, int beforeDays, String addOrReduce) {
        Calendar cal = null;
        try {
            cal = Calendar.getInstance();
            cal.setTime(inputDate);
            int inputDayOfYear = cal.get(Calendar.DAY_OF_YEAR);
            if ("-".equals(addOrReduce)) {
                cal.set(Calendar.DAY_OF_YEAR, inputDayOfYear - beforeDays);
            } else if ("+".equals(addOrReduce)) {
                cal.set(Calendar.DAY_OF_YEAR, inputDayOfYear + beforeDays);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cal.getTime();
    }
    /**
     * 判断某个时间点是否在一段时间内
     * @param startTime
     * @param day
     * @return
     */
    public static boolean isBetweenTheTime(Integer startTime,int day){
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(startTime * 1000L);
        c.add(Calendar.DAY_OF_MONTH, day);
        Integer afterTime = new Long(c.getTime().getTime()/ 1000L).intValue();
        return  afterTime >= getCurrentSecond() ? true:false;
    }
    /**
     * 获取指定时间的距离时间
     * @param time
     * @param day
     * @return
     */
    public static Integer getTheDayOfTime(Integer time,int day){
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(time * 1000L);
        c.add(Calendar.DAY_OF_MONTH, day);
        return  new Long(c.getTime().getTime()/ 1000L).intValue();
    }

    /**
     * 根据今天时间秒数获得明天日期
     * @param second
     * @return
     */
    public static Calendar getNextDate(long second) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(second*1000);
        calendar.set(Calendar.HOUR_OF_DAY, 24);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar;
    }

    /**
     * 根据传入的时间秒数和间隔分钟数,向后获取隔时间结束点
     * @param time 当前时间
     * @param minute 间隔分钟
     * @return
     */
    public static Calendar getNextInterval(long time, int minute) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time * 1000L);
        calendar.add(Calendar.MINUTE, minute);
        return calendar;
    }

    /**
     * 根据传入的时间秒数和间隔分钟数,向前获取隔时间开始点
     * @param time
     * @param minute
     * @return
     */
    public static Calendar getPreviousInterval(long time, int minute) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time * 1000L);
        calendar.add(Calendar.MINUTE, -minute);
        return calendar;
    }

    /**
     * 获得日期的秒数
     *
     * @author 738803 董玉帅
     * @created 2015年6月16日 下午4:27:29
     *
     * @param date
     * @return
     */
    @Deprecated
    public static Integer convertDate2Second(Date date){
        if(date == null){
            return 0;
        }
        return new Long(date.getTime() / 1000L).intValue();
    }

    /**
     * 获得当前日期秒数
     *
     * @author 738803 董玉帅
     * @created 2015年6月16日 下午4:28:41
     *
     * @return
     */
    public static Integer getCurrentSecond(){
        return new Long(System.currentTimeMillis() / 1000L).intValue();
    }

    /**
	 * 今天
	 *
	 * @author 738803 董玉帅
	 * @created 2015年6月30日 下午5:39:45
	 *
	 * @return
	 */
	public static Date today() {
		return new Date();
	}

	/**
	 * 将秒转为时间字符串
	 *
	 * @author 738803 董玉帅
	 * @created 2015年7月16日 上午9:51:53
	 *
	 * @param second
	 * @return
	 */
	public static String getDateStr(int second){
		return dateFormat.format(new Date(second * 1000l));
	}
	
	public static Long fromStr2Second(String dateStr) {
		try {
			Date date = dateFormat.parse(dateStr);
			return new Long(date.getTime()/1000);
		} catch (ParseException e) {
			return 0L;
		}
	}

	public static Date getTime(String yyyyMMdd) {
		Date date = null;
		try {
			date = sdf.parse(yyyyMMdd);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public static Date convertStr2Date(String dateStr) {
		Date date = null;
		try {
			date = yyyyMMdd.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public static Integer getTimeSeconds(String dateStr , String pattern) {
		DateFormat df = new SimpleDateFormat(pattern);
		try {
			Date date = df.parse(dateStr);
			long dateLong = getTimeSeconds(date);
			return new Long(dateLong).intValue();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Integer getFirstSecondOfDate(String date){
		return (int)getTimeSeconds(getTime(date));
	}
	public static Integer getLastSecondOfDate(String date){
		return getDayLatestTime(getTime(date));
	}

    /**
     * String类型时间转为Integer
     * @param dateStr
     * @return
     */
    public static Integer fromStr2Integer1(String dateStr){
        try {
            Date date = dateFormat.parse(dateStr);
            return new Long(date.getTime()/1000L).intValue();
        } catch (ParseException e) {
            return 0;
        }
    }

    public static String formatDate(Date date, String pattern) {
        if(date==null) {
            return null;
        }
        if(StringUtils.isEmpty(pattern)) {
            pattern="yyyyMMdd";
        }
        DateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
    }

    /**
     * 根据传入的日期秒数转换为字符串类型的日期: 年-月-日
     * @param time 秒数
     * @return
     */
    public static String getNowDays(long time) {
        return sdf.format(new Date(time * 1000l));
    }

    /**
     * 根据传入的日期秒数转换为字符串类型的日期
     * @param time 秒数
     * @param pattern 转换日期格式
     * @return
     */
    public static String getNowDays(long time, String pattern) {
        return formatDate(new Date(time * 1000l), pattern);
    }
    /**
     * 获得当天日期: 年-月-日
     * @return
     */
    public static String getNowDays() {
        return sdf.format(new Date());
    }

    /**
     * 获得当天日期: 年-月-日 时:分:秒
     * @return
     */
    public static Integer fromStr2Integer(String dateStr){
        DateFormat df=null;
        if(dateStr.trim().length()<12) df = new SimpleDateFormat("yyyy-MM-dd");
        else df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = df.parse(dateStr);
            return new Long(date.getTime()/1000L).intValue();
        } catch (ParseException e) {
            return 0;
        }
    }
    public static String getNowDays1() {
        return dateFormat.format(new Date());
    }
    /**
     * 根据传入时间秒数和间隔分钟获取下间隔时间
     * @param time 当前时间
     * @param minute 间隔分钟
     * @return 下个时间 秒数
     */
    public static long getNextIntervalTime(long time, int minute) {
        return getNextInterval(time, minute).getTime().getTime()/ 1000L;
    }

    /**
     * 根据传入日期获得昨天日期如: 2016-09-30
     * @param time 日期
     * @return
     */
    public static String getYesterday(int time) {
        return getNowDays(getLastTimeOfYesterday(getNextInterval(time, 0).getTime()));
    }

    /**
     * 获得昨天日期如: 2016-09-30
     * @return
     */
    public static String getYesterday() {
        return getYesterday(getCurrentSecond());
    }
    
    /**
	 * 在指定日期增加n天后，获取当天开始时间和结束时间
	 * @param
	 * @param days n天
	 * @return Integer时间
	 */
	public static Integer[] AddDays(Integer intDate,int days)
	{
		Integer[] result=new Integer[2];
		Date d=new Date(intDate.longValue()*1000);
		Date startDate=new Date(d.getTime());
		Date endDate=new Date(d.getTime());
		startDate.setHours(0);
		startDate.setMinutes(0);
		startDate.setSeconds(0);
		endDate.setHours(23);
		endDate.setMinutes(59);
		endDate.setSeconds(59);
		Calendar startC = Calendar.getInstance();
		startC.setTime(startDate);
		startC.add(Calendar.DATE, days); //日期加1天  
		Calendar endC = Calendar.getInstance();
		endC.setTime(endDate);
		endC.add(Calendar.DATE, days); //日期加1天  
	    result[0]=new Long(startC.getTime().getTime()/ 1000L).intValue();
	    result[1]=new Long(endC.getTime().getTime()/ 1000L).intValue();
	    return result;
	}
	
	/**
	 * 时间格式
	 */
	private static final String TIME_FORMAT = "yyyy-MM-dd";



    /**Integer转String时间（yyyy-MM-dd）
     * @param time
     * @return
     */
	public static String intToStrDate(Integer time){
		if(time!=null && time!=0){
			Date d=new Date(time.longValue()*1000);
			SimpleDateFormat sfd=new SimpleDateFormat(TIME_FORMAT);
			return sfd.format(d);
		}
		return "";
	}
    /**
     * 根据时间格式获取昨天日期如: 2016-09-30 或20160930
     * @param time 日期
     * @param pattern yyyy-MM-dd 或 yyyyMMdd
     * @return
     */
    public static String getYesterday(int time, String pattern) {
        return getNowDays(getLastTimeOfYesterday(getNextInterval(time, 0).getTime()), pattern);
    }
    /**
     * 将日期转换成秒
     * @param date
     * @return
     */
    public static long fromDate2Second(Date date){
        if(date == null){
            return 0;
        }
        return date.getTime() / 1000L;
    }
    public static String formatStringFromDate(Date date) {
        return dateFormat.format(date);
    }

    /**
     * 判断是否是yyyyMMdd的日期格式
     * @param date
     * @return
     */
    public static boolean isDate(String date) {
        String eL = "[0-9]{4}[0-9]{2}[0-9]{2}";
        Pattern p = Pattern.compile(eL);
        Matcher m = p.matcher(date);
        return m.matches();
    }

    /**
     * 获得当天开始时间
     * @return
     */
    public static Date getStartTime(Date date) {
        Calendar todayStart = Calendar.getInstance();
        todayStart.setTime(date==null?new Date():date);
        todayStart.set(Calendar.HOUR, 0);
        todayStart.set(Calendar.MINUTE, 0);
        todayStart.set(Calendar.SECOND, 0);
        todayStart.set(Calendar.MILLISECOND, 0);
        return todayStart.getTime();
    }

    /**
     * 获得当天结束时间
     * @return
     */
    public static Date getEndTime(Date date) {
        Calendar todayEnd = Calendar.getInstance();
        todayEnd.setTime(date==null?new Date():date);
        todayEnd.set(Calendar.HOUR, 23);
        todayEnd.set(Calendar.MINUTE, 59);
        todayEnd.set(Calendar.SECOND, 59);
        todayEnd.set(Calendar.MILLISECOND, 999);
        return todayEnd.getTime();
    }

    public static String formatDate2Str(Date date,DATEPATTERN pattern){
        SimpleDateFormat sdf = new SimpleDateFormat(pattern.pattern);
        return sdf.format(date);
    }

    public static String formatTimeSecond(Long second,DATEPATTERN pattern){
        Date d=new Date(second*1000L);
        return formatDate2Str(d,pattern);
    }

    public  enum  DATEPATTERN{
        YYYY_MM_DD("yyyy-MM-dd"),
        YYYY_MM_DD_HH_mm_ss("yyyy-MM-dd HH:mm:ss"),
        YYYYMM("yyyyMM"),
        YYYY_MM("yyyy-MM");
        String pattern;

        private DATEPATTERN(String pattern){
            this.pattern=pattern;
        }
    }

    /**
     * 转换为当天早上 yyyy-MM-dd 00:00:00
     * @param second
     * @return yyyy-MM-dd 00:00:00
     */
    public static String fromInteger2StrOfBeginTime(Integer second) {
        return getDateStr(getDayBeginTime(second));
    }

    /**
     * 转换为当天早上 yyyy-MM-dd 23:59:59
     * @param second
     * @return yyyy-MM-dd 23:59:59
     */
    public static String fromInteger2StrOfEndTime(Integer second) {
        return getDateStr(getDayEndTime(second));
    }

    public static String convertSecondToStr(long time){
    	return yyyyMMdd.format(new Date(time * 1000l));
	}


	public static  Date fromStr2Date(String str,DATEPATTERN datepattern){
        DateFormat dateFormat = new SimpleDateFormat(datepattern.pattern);
        try {
            return dateFormat.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *
     * @param day
     * @param hour
     * @param minute
     * @param second
     * @return
     */
    public static int getDayOfPreviousMonth(int day, int hour, int minute, int second) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, - 1);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, second);
        calendar.set(Calendar.MILLISECOND, 0);
        return new Long(calendar.getTime().getTime() / 1000).intValue();
    }

    /**
     *
     * @param day
     * @param hour
     * @param minute
     * @param second
     * @return
     */
    public static int getDayOfThisMonth(int day, int hour, int minute, int second) {
        Calendar calendar = Calendar.getInstance();
//        calendar.add(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, second);
        calendar.set(Calendar.MILLISECOND, 0);
        return new Long(calendar.getTime().getTime() / 1000).intValue();
    }
    
    /**
     * 获取某个月的第一天
     * @param date
     * @return
     */
    public static String getFirstDayOfMonth(String date){
    	try {
			Date dateTime = sdf.parse(date);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(dateTime);
			calendar.set(Calendar.DAY_OF_MONTH, 1);
			return sdf.format(calendar.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	return null;
    }
    
    /**
     * 获取某个月的最后一天
     * @param date
     * @return
     */
    public static String getLastDayOfMonth(String date){
    	try {
			Date dateTime = sdf.parse(date);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(dateTime);
			calendar.add(Calendar.MONTH, 1);
			calendar.set(Calendar.DATE, 1);
			calendar.add(Calendar.DATE, -1);
			return sdf.format(calendar.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	return null;
    }
    
    /**
     * 获取所传日期是的当月第几天
     * @param date
     * @return
     */
    public static Integer getDayOfMonth(Date date){
    	try {
    		Calendar calendar = Calendar.getInstance();
    		calendar.setTime(date);
    		return calendar.get(Calendar.DAY_OF_MONTH);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return null;
    }
}
