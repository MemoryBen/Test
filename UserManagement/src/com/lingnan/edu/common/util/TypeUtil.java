package com.lingnan.edu.common.util;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 日期类型工具类
 * @author 98242
 *
 */
public class TypeUtil {
	
	/**
	 * 字符转换日期
	 * @param str
	 * @return 返回符合格式日期
	 */
	public static Date strToDate(String str) {
		Date date = null;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			date = df.parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * 日期转换字符
	 * @param date
	 * @return 返回日期字符串
	 */
	public static String dateToStr(Date date) {
		String str = null;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		str = df.format(date);
		return str;
	}
}
