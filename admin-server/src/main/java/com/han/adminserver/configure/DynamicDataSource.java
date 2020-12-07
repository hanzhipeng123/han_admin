/*
package com.han.adminserver.configure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.util.HashMap;
import java.util.Map;

*/
/**
 *@author sunq
 *@date2020/8/21 15:56
 *@Description 动态数据源路由实现
 *//*

public class DynamicDataSource extends AbstractRoutingDataSource {

	private static final Logger logger = LoggerFactory.getLogger(DynamicDataSource.class);

	// 单例句柄
	private static DynamicDataSource instance;
	private static byte[] lock = new byte[0];

	// 用于存储已实例的数据源map
	private static Map<Object, Object> dataSourceMap = new HashMap<>();


	private static final ThreadLocal<String> DATA_SOURCE_KEY = new ThreadLocal<>();

	static void changeDataSource(String dataSourceKey){
		DATA_SOURCE_KEY.set(dataSourceKey);
	}

	static void clearDataSource(){
		DATA_SOURCE_KEY.remove();
	}

	// 获取当前数据源
	@Override
	protected Object determineCurrentLookupKey() {
		logger.info("current data-source is {}", DynamicDataSourceContextHolder.getDataSourceKey());
		return DynamicDataSourceContextHolder.getDataSourceKey();
	}

	// 设置数据源
	@Override
	public void setTargetDataSources(Map<Object, Object> targetDataSources) {
		super.setTargetDataSources(targetDataSources);
		dataSourceMap.putAll(targetDataSources);
		super.afterPropertiesSet();
	}

	// 获取已实例的数据源
	public Map<Object, Object> getAllDatasource(){
		return dataSourceMap;
	}

	// 单例方法
	public static synchronized DynamicDataSource getInstance(){
		if (instance == null){
			synchronized (lock){
				if (instance == null){
					instance = new DynamicDataSource();
				}
			}
		}
		return instance;
	}


	// 是否存在当前 key 的 DataSource
	public static boolean isExistDataSource(String key){
		return dataSourceMap.containsKey(key);
	}


















}
*/
