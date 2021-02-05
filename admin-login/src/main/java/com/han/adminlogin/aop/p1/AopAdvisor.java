package com.han.adminlogin.aop.p1;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.PointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *@author sunq
 *@date2021/1/21 17:21
 *@Description
 */
@Component
public class AopAdvisor implements PointcutAdvisor {

	@Autowired
	private AopPointcut aopPointcut;

	@Autowired
	private AopAdvice aopAdvice;

	@Override
	public Pointcut getPointcut() {

		return aopPointcut;
	}

	@Override
	public Advice getAdvice() {


		return aopAdvice;
	}

	@Override
	public boolean isPerInstance() {
		return false;
	}
}
