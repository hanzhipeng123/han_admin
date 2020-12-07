/*
package com.han.adminserver.configure;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

*/
/**
 *@author sunq
 *@date2020/8/24 14:41
 *@Description 数据源配置类
 *//*


@Configuration
@EnableConfigurationProperties(MybatisProperties.class)
public class DataSourceConfigurer {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	public static final String MULTI_DB1 = "dataSource_multiDB1";
	public static final String MULTI_DB2 = "dataSource_multiDB2";

	@Autowired
	private Environment env;

	private MybatisProperties mybatisProperties;
	public DataSourceConfigurer(MybatisProperties mybatisProperties){
		this.mybatisProperties = mybatisProperties;
	}

	// 创建数据源对象
	private DruidDataSource createDataSource(String dbType){

		String dbName = dbType.trim().isEmpty() ? "default" : dbType.trim();
		DruidDataSource dataSource = new DruidDataSource();
		String prefix = "datasource." + dbName + ".";
		dataSource.setUrl(env.getProperty(prefix + "jdbc-url"));
		dataSource.setUsername(env.getProperty(prefix + "username"));
		dataSource.setPassword(env.getProperty(prefix + "password"));
		dataSource.setDriverClassName(env.getProperty(prefix + "driver-class-name"));

		return dataSource;
	}

	// 动态数据源
	@Bean
	public DynamicDataSource dynamicDataSource(){
		// 获取动态数据库实例
		DynamicDataSource dynamicDataSource = DynamicDataSource.getInstance();
		// 默认数据库连接对象
		DruidDataSource defaultDataSource = createDataSource("multi-db1");
		// 其他数据库
		DruidDataSource db2 = createDataSource("multi-db2");

		Map<Object, Object> dataSourceMap = new HashMap<>();
		dataSourceMap.put(MULTI_DB1, defaultDataSource);
		dataSourceMap.put(MULTI_DB2, db2);
		dynamicDataSource.setTargetDataSources(dataSourceMap);

		// 设置默认数据源
		dynamicDataSource.setDefaultTargetDataSource(defaultDataSource);

		return dynamicDataSource;

	}

	// 配置 mybatis 的 sqlSession 连接动态数据库
	@Bean
	public SqlSessionFactory sqlSessionFactory(@Qualifier("dynamicDataSource") DataSource dynamicDataSource) throws Exception{

		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dynamicDataSource);
		bean.setMapperLocations(mybatisProperties.resolveMapperLocations());
		bean.setTypeAliasesPackage(mybatisProperties.getTypeAliasesPackage());
		bean.setConfiguration(mybatisProperties.getConfiguration());

		return bean.getObject();
	}

	@Bean(name = "sqlSessionTemplate")
	public SqlSessionTemplate sqlSessionTemplate(@Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception{
		return new SqlSessionTemplate(sqlSessionFactory);

	}

	// 加入到事务管理器中
	public PlatformTransactionManager transactionManager(){
		return new DataSourceTransactionManager(dynamicDataSource());
	}




}
*/
