package com.han.adminserver.service.impl;

import com.han.adminserver.service.TimeOutService;
import com.han.adminserver.service.client.TimeOutTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *@author sunq
 *@date2020/11/20 10:49
 *@Description
 */
@Service
public class TimeOutServiceImpl implements TimeOutService {

	@Autowired
	private TimeOutTest timeOutTest;

	@Override
	public void testTimeOut() {
		System.out.println("---- 测试超时时间 start ---- ");

		timeOutTest.testFeignTimeOut();

		System.out.println("---- 测试超时时间 end ---- ");
	}
}
