package com.han.adminlogin.service;

import com.han.adminlogin.entity.UserInfo;

public interface UserInfoService {

	UserInfo getUserInfoByPK(Integer userId);

	void testTransaction() throws InterruptedException;

	void batchUpdate();



}
