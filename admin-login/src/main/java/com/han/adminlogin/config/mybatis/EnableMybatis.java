package com.han.adminlogin.config.mybatis;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.lang.annotation.*;

/**
 *@author sunq
 *@date2019/8/8 15:16
 *@Description
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@EnableTransactionManagement
@Import({DruidDataSourceAutoConfigure.class, DataSourceAutoConfiguration.class, MybatisAutoConfiguration.class})
public @interface EnableMybatis {
}
