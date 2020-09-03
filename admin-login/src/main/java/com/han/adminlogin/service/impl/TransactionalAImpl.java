package com.han.adminlogin.service.impl;

import com.han.adminlogin.entity.UserInfo;
import com.han.adminlogin.service.TransactionalA;
import com.han.adminlogin.service.base.BaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *@author sunq
 *@date2020/6/6 14:30
 *@Description
 */

@Service
public class TransactionalAImpl extends BaseService implements TransactionalA {


	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.NESTED)
	public void testInsert1() {

		UserInfo userInfo = new UserInfo();
		userInfo.setUnionId("abc");
		userInfo.setNickname("张三");
		userInfo.setMobile("123");
		userInfoMapper.insert(userInfo);

	}
}
