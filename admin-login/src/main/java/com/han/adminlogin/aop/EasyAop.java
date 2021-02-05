package com.han.adminlogin.aop;
import java.lang.annotation.*;
/**
 *@author sunq
 *@date2021/1/21 17:41
 *@Description
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface EasyAop {
}
