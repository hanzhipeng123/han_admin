package com.han.adminlogin.aop;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
/**
 *@author sunq
 *@date2021/1/21 17:44
 *@Description
 */
@Component
@EnableAspectJAutoProxy(proxyTargetClass = false,exposeProxy = true)
public class AopConfig {
}
