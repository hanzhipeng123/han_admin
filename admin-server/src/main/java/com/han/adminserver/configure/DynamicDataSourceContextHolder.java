/*
package com.han.adminserver.configure;

*/
/**
 *@author sunq
 *@date2020/8/24 14:31
 *@Description 通过 ThreadLocal 获取和设置线程安全的数据源 key
 *//*

public class DynamicDataSourceContextHolder {

	private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

	// 切换数据源
	public static synchronized void setDataSourceKey(String key){
		contextHolder.set(key);
	}

	// 获取当前数据源
	public static synchronized String getDataSourceKey(){
		return contextHolder.get();
	}

	// 设置为默认数据源
	public static synchronized void clearDataSourceKey(){
		contextHolder.remove();
	}


}
*/
