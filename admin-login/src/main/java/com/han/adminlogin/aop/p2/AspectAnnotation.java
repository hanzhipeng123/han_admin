package com.han.adminlogin.aop.p2;

import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.aop.interceptor.ExposeInvocationInterceptor;
import org.springframework.stereotype.Component;

/**
 *@author sunq
 *@date2021/1/21 18:01
 *@Description
 */
//@Component
//@Aspect
public class AspectAnnotation {

	@Pointcut(value = "execution(public * com.han.adminlogin.aop.*.*(..))")
	public void pc1(){}

	@Before("pc1()")
	public void before13() {
		MethodInvocation methodInvocation = ExposeInvocationInterceptor.currentInvocation();
		System.out.println("==============AspectAnnotation before13=========");

	}


	@Before(value = "pc1()",argNames = "joinPoint")
	public void before2(JoinPoint joinPoint) {
		System.out.println("==============AspectAnnotation before2=========");

	}

	@After(value = "pc1()")
	public void AAfter() {
		System.out.println("==============AspectAnnotation AAfter=========");

	}

	@Around(value = "pc1()")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("==============AspectAnnotation around前置通知=========");
		Object result = joinPoint.proceed();
		System.out.println("==============AspectAnnotation around后置通知=========");

		return result;
	}

}
