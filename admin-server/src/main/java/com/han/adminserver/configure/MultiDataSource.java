package com.han.adminserver.configure;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.inject.Qualifier;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 *@author sunq
 *@date2020/8/21 15:42
 *@Description 设置配置
 */
@Configuration
public class MultiDataSource {

	public static final String MULTI_DB1 = "dataSource_multiDB1";
	public static final String MULTI_DB2 = "dataSource_multiDB2";

	@Bean(name = MultiDataSource.MULTI_DB1)
	@ConfigurationProperties(prefix = "datasource.multi-db1")
	public DataSource multiDB1(){
		return DataSourceBuilder.create().build();
	}

	@Bean(name = MultiDataSource.MULTI_DB2)
	@ConfigurationProperties(prefix = "datasource.multi-db2")
	public DataSource multiDB2(){
		return DataSourceBuilder.create().build();
	}


	public DynamicDataSource dataSource(){
		DynamicDataSource dynamicDataSource = new DynamicDataSource();
		dynamicDataSource.setDefaultTargetDataSource(multiDB1());

		Map<Object, Object> dataSourceMap = new HashMap<>();
		dataSourceMap.put(MULTI_DB1, multiDB1());
		dataSourceMap.put(MULTI_DB2, multiDB2());
		dynamicDataSource.setTargetDataSources(dataSourceMap);

		return dynamicDataSource;

	}















}
