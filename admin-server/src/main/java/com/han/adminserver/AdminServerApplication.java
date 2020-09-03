package com.han.adminserver;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
@MapperScan("com.han.adminserver.mapper")
public class AdminServerApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(AdminServerApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(AdminServerApplication.class, args);
        LOGGER.info("AdminServer服务加载完成");
    }

}
