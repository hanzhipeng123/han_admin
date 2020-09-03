package com.han.adminlogin.web;

import com.han.adminlogin.config.redis.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *@author sunq
 *@date2019/8/5 17:22
 *@Description
 */
@RestController
@RequestMapping("/test")
public class RedisTestController {


	@Autowired
	private RedisUtils redisUtils;


	@GetMapping("/redis")
	public void getUserInfo(){

		System.out.println("redis 测试------start----------");

		try {
			for (int i = 0; i < 1000000; i++) {
				redisUtils.set("myRedis" + i,"redisValue" + i);
				System.out.println("myRedis ---> " + i + "添加成功");
				Thread.sleep(100);
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		System.out.println("redis 测试------end----------");

	}





}
