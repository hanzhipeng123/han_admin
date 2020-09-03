package com.han.adminlogin.service.impl;

import com.han.adminlogin.entity.UserInfo;
import com.han.adminlogin.mapper.UserInfoMapper;
import com.han.adminlogin.service.TransactionalA;
import com.han.adminlogin.service.UserInfoService;
import com.han.adminlogin.service.base.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

@Service
public class UserInfoServiceImpl extends BaseService implements UserInfoService {
    protected static Logger logger = LoggerFactory.getLogger(UserInfoServiceImpl.class);

    @Autowired
	private TransactionalA transactionalA;


	@Override
	public UserInfo getUserInfoByPK(Integer userId) {
		return userInfoMapper.selectByPK(userId);
	}

	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public void testTransaction() throws InterruptedException {


		transactionalA.testInsert1();
		Thread.sleep(3000);

		UserInfo userInfo = new UserInfo();
		userInfo.setUnionId("def");
		userInfo.setNickname("李四");
		userInfo.setMobile("456");
		userInfoMapper.insert(userInfo);



	}

	@Override
	public void batchUpdate() {

		List<UserInfo> userList = new LinkedList<>();

		UserInfo info1 = new UserInfo();
		info1.setUserId(1);
		info1.setMobile("111111");
		info1.setNickname("111111");
		userList.add(info1);

		UserInfo info2 = new UserInfo();
		info2.setUserId(2);
		info2.setMobile("222222");
		info2.setNickname("222222");
		userList.add(info1);

		UserInfo info3 = new UserInfo();
		info3.setUserId(3);
		info3.setMobile("333333");
		info3.setNickname("333333");
		userList.add(info3);

		userInfoMapper.batchUpdate(userList);




	}
}
