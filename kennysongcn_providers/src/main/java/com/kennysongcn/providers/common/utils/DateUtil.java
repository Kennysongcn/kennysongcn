package com.kennysongcn.providers.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;



public class DateUtil {
	
	/**
	 * 获取当前时间
	 * @return
	 */
	public static String getCurrentMonth()
	{
		SimpleDateFormat myFmt=new SimpleDateFormat("yyyy-MM");
		
		return myFmt.format(new Date());
		
	}
	
	/**
	 * 获取当前时间
	 * @return
	 */
	public static String getCurrentDate()
	{
		SimpleDateFormat myFmt=new SimpleDateFormat("yyyyMMddHHmmss");
		
		return myFmt.format(new Date());
		
	}
	
	/**
	 * 将 YYYY-MM-DD格式数据转换成YYYY-MM
	 * @return
	 */
	public static String YYYYMMDDtoYYYYMM(String date)
	{
		String[] str = date.split("-");
		
		return str[0]+"-"+str[1];
		
	}
	
	/**
	 * 获取当前时间
	 * @return
	 */
	public static String getFormatCurrentDate(Date date)
	{
		SimpleDateFormat myFmt=new SimpleDateFormat("yyyy-MM-dd");
		
		return myFmt.format(date);
		
	}
	
	public static void main(String[] args) {
		System.out.println(DateUtil.getFormatCurrentDate(new Date()));
	//	System.out.println((int)(Math.random()*90)+10);
	}
	
}
