package com.han.adminlogin;

import com.han.adminlogin.config.mybatis.EnableMybatis;
//import com.sunq.starter.mystarter.starter.MyStartService;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.han.adminlogin.mapper")
@EnableMybatis
public class AdminLoginApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(AdminLoginApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(AdminLoginApplication.class, args);
        LOGGER.info("AdminLogin服务加载完成");
    }

    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p
                        .path("/get")
                        .filters(f -> f.addRequestHeader("Hello", "World"))
                        .uri("http://www.qq.com"))
                .build();
    }

//    @Bean
//    public CommandLineRunner commandLineRunner(MyStartService myStartService){
//    	return (args) -> {
//			System.out.println(myStartService.getServiceName());
//		};
//	}


}
