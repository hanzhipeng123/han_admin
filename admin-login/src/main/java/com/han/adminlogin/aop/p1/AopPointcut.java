package com.han.adminlogin.aop.p1;

import com.han.adminlogin.aop.EasyAop;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.AopUtils;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/**
 *@author sunq
 *@date2021/1/21 17:35
 *@Description
 */
@Component
public class AopPointcut implements Pointcut,MethodMatcher {



	@Override
	public boolean matches(Method method, Class<?> aClass) {

		Method mostSpecificMethod = AopUtils.getMostSpecificMethod(method, aClass);
		if (AnnotatedElementUtils.hasAnnotation(mostSpecificMethod, EasyAop.class)){

			return true;
		}

		return false;
	}

	@Override
	public boolean isRuntime() {
		return true;
	}

	@Override
	public boolean matches(Method method, Class<?> aClass, Object... objects) {
		if(method.getName().equalsIgnoreCase("test")) {
			List<Object> params = Arrays.asList(objects);
			String param = (String)params.get(0);
			if("Hello".equalsIgnoreCase(param)) {
				return true;
			}
		}

		return false;
	}

	@Override
	public ClassFilter getClassFilter() {
		return ClassFilter.TRUE;
	}

	@Override
	public MethodMatcher getMethodMatcher() {
		return this;
	}
}
