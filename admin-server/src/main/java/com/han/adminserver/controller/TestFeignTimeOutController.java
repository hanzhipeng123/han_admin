package com.han.adminserver.controller;

import com.han.adminserver.service.TimeOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *@author sunq
 *@date2020/11/20 11:22
 *@Description
 */
@RestController
@RequestMapping("/test")
public class TestFeignTimeOutController {

	@Autowired
	private TimeOutService timeOutService;



	@GetMapping("/timeOut")
	public String testTimeOut(){
		try {
			timeOutService.testTimeOut();
			return "正常访问";
		}catch (Exception e){
			return "超时了";
		}
	}

}
