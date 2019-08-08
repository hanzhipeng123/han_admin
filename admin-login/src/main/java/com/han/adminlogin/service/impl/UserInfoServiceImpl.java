package com.han.adminlogin.service.impl;

import com.han.adminlogin.entity.UserInfo;
import com.han.adminlogin.mapper.UserInfoMapper;
import com.han.adminlogin.service.UserInfoService;
import com.han.adminlogin.service.base.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl extends BaseService implements UserInfoService {
    protected static Logger logger = LoggerFactory.getLogger(UserInfoServiceImpl.class);


	@Override
	public UserInfo getUserInfoByPK(Integer userId) {
		return userInfoMapper.selectByPK(userId);
	}
}
