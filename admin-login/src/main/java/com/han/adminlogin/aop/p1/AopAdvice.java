package com.han.adminlogin.aop.p1;

import com.han.adminlogin.aop.EasyAop;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

/**
 *@author sunq
 *@date2021/1/21 17:43
 *@Description
 */
@Component
public class AopAdvice implements MethodInterceptor {
	@Override
	public Object invoke(MethodInvocation methodInvocation) throws Throwable {

		System.out.println();
		System.out.println();
		System.out.println("--代理方法被切到了---");
		System.out.println();
		System.out.println();

		return methodInvocation.proceed();
	}
}
