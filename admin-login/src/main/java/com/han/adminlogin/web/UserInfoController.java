package com.han.adminlogin.web;

import com.han.adminlogin.common.ResponseModel;
import com.han.adminlogin.config.redis.RedisUtils;
import com.han.adminlogin.entity.UserInfo;
import com.han.adminlogin.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 *@author sunq
 *@date2019/8/5 17:22
 *@Description
 */
@RestController
@RequestMapping("/user")
public class UserInfoController {


	@Autowired
	private UserInfoService userInfoService;
	@Autowired
	private RedisUtils redisUtils;


	@GetMapping("/info/{userId}")
	public ResponseModel getUserInfo(@PathVariable("userId") Integer userId){
		UserInfo userInfo  = userInfoService.getUserInfoByPK(userId);

		ResponseModel response = new ResponseModel();

		redisUtils.set("myRedis","firstRedisValue");

		if (userInfo != null){
			return response.warpSuccess().setData(userId);
		}else {
			return response.setCode("500").setMessage("未查询到用户！");
		}

	}

	@GetMapping("/test")
	public ResponseModel testTransaction(){
		try {
			userInfoService.testTransaction();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		ResponseModel res = new ResponseModel();
		res.setCode("998");
		res.setCode("测试成功");
		return res;
	}


	@GetMapping("/exception")
	public ResponseModel exception(){
		try {
			System.out.println("---------start");

			int a = 1/0;


			System.out.println("---------end");
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseModel res = new ResponseModel();
		res.setCode("200");
		res.setCode("测试成功");
		return res;
	}


	@GetMapping("/timeOut")
	public String testFeignTimeOut() throws InterruptedException {
		TimeUnit.SECONDS.sleep(50);
		return "返回数据成功！";
	}



}
