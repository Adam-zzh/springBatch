package com.sfbest.optimize.batch.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class NumberUtils {
	
	public static final DecimalFormat LONG_MONEY_FORMAT=new DecimalFormat("#0.0000");

	public static Double add(Double d1, Double d2) {

		if (d1 == null) {
			return d2 == null ? 0d : d2;
		}

		return d1 + (d2 == null ? 0d : d2);

	}
	
	public static Double add(Double... ds) {

		Double v = 0d;
		for (Double d : ds) {
			v += nullToZero(d);
		}

		return v;

	}

	public static Double sub(Double d1, Double... d2s) {
		Double v = nullToZero(d1) - 0d;
		for (Double d : d2s) {
			v -= nullToZero(d);
		}

		return v;

	}

	public static Double nullToZero(Double d) {
		return d == null ? 0d : d;
	}
	
	public static Integer nullToZero(Integer i) {
		return i == null ? 0 : i;
	}

	public static Double negative(Double d) {
		return d == null ? 0d : -d;
	}
	
	public static Integer negative(Integer n) {
		return n == null || n ==0? 0 : -n;
	}
	
	
	public static Double multiply(Double... ds) {
		Double v = 1d;
		for (Double d : ds) {
			v *= nullToZero(d);
		}

		return v;

	}
	
	public static Double multiply(Double d,Integer i) {
		Double v = 1d;
		v = v*nullToZero(d)*nullToZero(i);
       
		return v;

	}
	
	public static Double multiplyDiv100(Double... ds) {
		Double v = 1d;
		for (Double d : ds) {
			v *= nullToZero(d);
		}
		v /= 100d;

		return v;

	}
	
	public static Double multiplyRound(Double... ds) {
		Double v = 1d;
		for (Double d : ds) {
			v *= nullToZero(d);
		}

		return rnd(v);

	}
	
	public static Double multiplyRound(Double d,Integer i) {
		Double v = 1d;
		v = v*nullToZero(d)*nullToZero(i);
       
		return rnd(v);

	}
	
	public static Double multiplyDiv100Round(Double... ds) {
		Double v = 1d;
		for (Double d : ds) {
			v *= nullToZero(d);
		}
		v /= 100d;

		return rnd(v);

	}
	
	public static Double rnd(Double d) {
		return rnd(d,0);
	}
	
	public static Double rnd(Double d,int scale) {
		BigDecimal b = new BigDecimal(d);
		return b.setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
	public static Double abs(Double d) {
		if(d == null){
			return d;
		}
		return Math.abs(d);

	}
	
	public static Integer abs(Integer n) {
		if(n == null){
			return n;
		}
		return Math.abs(n);

	}
	
	/**
	 * 精确到整数
	 */
	public static double round(double value) {
		// 四舍五入     经过确认,负数情况取绝对值再四舍五入,再转为负数. 2015.07.07
		return value < 0 ? -Math.round(Math.abs(value)) : Math.round(value); 
	}
	
	/**
	 * 精确到小数点后两位
	 */
	public static double roundDouble(double value) {
		return value < 0 ? Math.round(Math.abs(value) * 100 ) / 100.0 : Math.round(value* 100 ) / 100.0;
	}
	
	/**
	 * 
	 * double类型数据转数据,空值为0.0
	 *
	 * @author 603513
	 * @created 2016-1-26 上午8:58:14
	 *
	 * @param d Double类型值
	 * @return d为空返回0，
	 */
	public static double doubleValue(Double d){
		if(d==null)return 0.0;
		return d;
	}
	
	/**
	 * 
	 * TODO
	 *
	 * @author 603513
	 * @created 2016-1-26 上午8:59:04
	 *
	 * @param val
	 * @return val为空返回0
	 */
	public static double intValue(Integer val){
		if(val==null)return 0.0;
		return val;
	}
	
	
	public static double puraseDouble(String s){
		double d=0.0;
		try{
			d=Double.parseDouble(s);
		}catch(Exception e){
			//e.printStackTrace();
		}
		return d;
	}

	/**
	 * 提供精确的除法运算方法div
	 *
	 * @param value1
	 *            被除数
	 * @param value2
	 *            除数
	 * @return 两个参数的商
	 */
	public static BigDecimal div(BigDecimal value1, BigDecimal value2) {
		return value1.divide(value2, 2, BigDecimal.ROUND_HALF_UP);
	}

	/**
	 * 比较两个数值大小
	 * @param value1
	 * @param value2
	 * @return
	 */
	public static boolean compareMoney(BigDecimal value1,BigDecimal value2){
		boolean flag =false;
		value1 = value1.setScale(2, BigDecimal.ROUND_HALF_UP);
		value2 = value2.setScale(2, BigDecimal.ROUND_HALF_UP);
		if(value1.equals(value2)){
			flag = true;
		}
		return flag;
	}

	/**
	 * 提供精确的减法
	 *
	 * @param value1
	 *            被减数
	 * @param value2
	 *            减数
	 * @return 两个参数的查
	 */
	public static BigDecimal sub(BigDecimal value1, BigDecimal value2) {
		value1 = value1.setScale(2, BigDecimal.ROUND_HALF_UP);
		value2 = value2.setScale(2, BigDecimal.ROUND_HALF_UP);
		return value1.subtract(value2);
	}

	public static BigDecimal fenToYuan(Integer value){
		BigDecimal val1 = new BigDecimal(value);
		BigDecimal val2 = new BigDecimal(100);
		return val1.divide(val2, 2, BigDecimal.ROUND_HALF_UP);
	}

	public static void main(String[] args) {
		double d=round(-100.5232);
		System.out.println(d);
	}

	/**
	 * 精确到分位
	 * @param value
	 * @return
	 */
	public static BigDecimal bigdecimalFen(BigDecimal value) {
		return value.setScale(0, BigDecimal.ROUND_HALF_UP);
	}

	/**
	 * 精确到分位
	 * @param value1
	 * @param value2
	 * @return
	 */
	public static BigDecimal divFen(BigDecimal value1, BigDecimal value2) {
		return value1.divide(value2, 0, BigDecimal.ROUND_HALF_UP);
	}
	
	public static BigDecimal feeMoney(BigDecimal  totalSale, BigDecimal proportion) 
	{
		BigDecimal feeMoney = totalSale.multiply(proportion).divide(new BigDecimal("100"),0,BigDecimal.ROUND_HALF_UP);
		return feeMoney;
	}

	public static BigDecimal feeMoneyFormat(BigDecimal  number) {
		BigDecimal feeMoney = number.setScale(0, BigDecimal.ROUND_HALF_UP);
		return feeMoney;
	}

	/**
	 * 精确到分位后6位
	 * @param value
	 * @return
	 */
	public static BigDecimal bigdecimalFenAfterTwo(BigDecimal value) {
		return value.setScale(2, BigDecimal.ROUND_HALF_UP);
	}

}
