package com.sunq.starter.mystarter.starter;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *@author sunq
 *@date2019/9/18 17:20
 *@Description
 */

@Configuration
@ConditionalOnProperty(prefix = "sunq.starter",name = "enabled",havingValue = "true")
public class MyStartConfiguration {

	@Bean
	public MyStartService getService(){
		return new MyStartService();
	}


}
