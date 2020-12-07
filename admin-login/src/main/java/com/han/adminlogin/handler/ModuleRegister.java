package com.han.adminlogin.handler;

import org.apache.commons.lang.StringUtils;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.ResolvableType;
import org.springframework.stereotype.Service;
import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 *@author sunq
 *@date2020/11/10 10:32
 *@Description 将多个子类，注册到一个容器中
 */

@Service("moduleRegister")
public class ModuleRegister implements InitializingBean,ApplicationContextAware {

	// 子类handler容器
	private Map<String, ModuleType> handlerContainer = new HashMap<>();
	// spring 上下文
	private ApplicationContext applicationcontext;

	// 模块type 和 模块handler映射
	private static Map<Integer, String> moduleMapping = new HashMap<>();
	// 子类 class 对象
	private static Map<String, Class<?>> handlerClazzContainer = new HashMap<>();
	static {
		moduleMapping.put(1, "Banner");
		moduleMapping.put(2, "Icon");
	}


	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationcontext = applicationContext;
	}


	@Override
	public void afterPropertiesSet() throws Exception {
		// 获取 ModuleType 接口的所有实现类，按照规则放入容器中
		Map<String, ModuleType> moduleTypeBeanMap = applicationcontext.getBeansOfType(ModuleType.class);
		String handlerName = null;

		for (ModuleType moduleType : moduleTypeBeanMap.values()) {
			handlerName = AopUtils.getTargetClass(moduleType).getSimpleName();
			handlerContainer.put(handlerName, moduleType);

			for (Type type : AopUtils.getTargetClass(moduleType).getGenericInterfaces()) {
				if (type instanceof ParameterizedTypeImpl && ((ParameterizedTypeImpl) type).getRawType().getSimpleName().equalsIgnoreCase("ModuleType")){
					handlerClazzContainer.put(handlerName, (Class)(((ParameterizedTypeImpl) type).getActualTypeArguments()[0]));
					System.out.println("aaa");
				}
			}

		}
		System.out.println("aaa");
	}

	public ModuleType getModuleHandlerByType(Integer type) throws Exception {
		String moduleHandlerName = moduleMapping.get(type);
		if (StringUtils.isEmpty(moduleHandlerName)){
			throw new Exception("handler not found!");
		}
		return handlerContainer.get(moduleHandlerName + "ModuleHandler");
	}


}
