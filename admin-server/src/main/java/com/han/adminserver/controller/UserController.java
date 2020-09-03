package com.han.adminserver.controller;

import com.alibaba.fastjson.JSON;
import com.han.adminserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *@author sunq
 *@date2020/8/21 17:48
 *@Description
 */
@RequestMapping("/user")
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/multi/datasource")
	public String getUserFormTwoDataSource(Short source, Integer userId){
		return JSON.toJSONString(userService.getUserById(source, userId));
	}


}
