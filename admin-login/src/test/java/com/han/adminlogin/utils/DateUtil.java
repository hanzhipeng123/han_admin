package com.han.adminlogin.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *@author sunq
 *@date2019/11/13 15:25
 *@Description
 */
public class DateUtil {


	/**
	 * 如果 pattern 有值，转换成指定格式
	 * 没有的话，默认将日期转换成yyyy-MM-dd hh:mm:ss格式的字符串
	 *
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String dateFormat(Date date, String pattern) {
		SimpleDateFormat format;
		if (pattern != null){
			format = new SimpleDateFormat(pattern);
		}else {
			format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		}
		return format.format(date);

	}



	/**
	 * 如果 pattern 有值，转换成指定格式
	 * 没有的话，默认将时间戳转换成yyyy-MM-dd hh:mm:ss格式的字符串
	 *
	 * @param time
	 * @return
	 */
	public static String timeFormat(Long time) {
		return dateFormat(new Date(time), null);
	}
}
