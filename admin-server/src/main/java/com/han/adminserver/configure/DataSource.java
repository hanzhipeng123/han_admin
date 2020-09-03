package com.han.adminserver.configure;

import java.lang.annotation.*;

/**
 *@author sunq
 *@date2020/8/21 16:10
 *@Description 使用AOP方式实现数据源切换
 */

@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface DataSource {

	String value();

}


