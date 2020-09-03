package com.han.adminserver.configure;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 *@author sunq
 *@date2020/8/21 16:13
 *@Description
 */

@Component
@Aspect
public class DynamicDataSourceAspect {


	private static final Logger logger = LoggerFactory.getLogger(DynamicDataSourceAspect.class);

	private final String[] QUERY_PREFIX = {"select"};

	@Pointcut("execution( * com.han.adminserver.mapper.*(..))")
	public void mapperAspect(){}


	@Before("mapperAspect()")
	public void beforeSwitchDataSource(JoinPoint point){

		Object[] params = point.getArgs();
		logger.info("params：{}", JSON.toJSONString(params));

		String param = (String) params[0];
		for (Object str : params) {
			logger.info("str：{}", JSON.toJSONString(str));
		}
		logger.info("###################################");
		logger.info("point signature name：{}", point.getSignature().getName());

		if (isQueryMethod(point.getSignature().getName())){

		}


	}

	@After("@annotation(DataSource)")
	public void afterSwitchDataSource(){
		DynamicDataSource.clearDataSource();
	}


	private Boolean isQueryMethod(String methodName){
		for (String prefix : QUERY_PREFIX) {
			if (methodName.startsWith(prefix)){
				return true;
			}
		}
		return false;
	}


}
