package com.han.adminlogin.aop;

import org.springframework.stereotype.Service;

/**
 *@author sunq
 *@date2021/1/21 17:15
 *@Description
 */
@Service
public class AopTest {


	@EasyAop
	public void test(String a){
		System.out.println("===测试 aop===");
	}


}
