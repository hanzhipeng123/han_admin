package com.han.adminserver.service.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *@author sunq
 *@date2020/11/20 10:50
 *@Description
 */
@FeignClient(url = "localhost:8081")
public interface TimeOutTest {

	@GetMapping("/timeOut")
	String testFeignTimeOut();

}
