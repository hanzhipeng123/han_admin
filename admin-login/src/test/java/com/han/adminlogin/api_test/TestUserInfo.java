package com.han.adminlogin.api_test;

import com.han.adminlogin.AdminLoginApplication;
import com.han.adminlogin.service.UserInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *@author sunq
 *@date2020/8/11 15:18
 *@Description
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AdminLoginApplication.class)
public class TestUserInfo {

	@Autowired
	private UserInfoService userInfoService;

	@Test
	public void batchUpdate(){

		userInfoService.batchUpdate();

	}



}
