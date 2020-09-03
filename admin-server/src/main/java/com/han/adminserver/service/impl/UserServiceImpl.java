package com.han.adminserver.service.impl;

import com.han.adminserver.configure.DataSource;
import com.han.adminserver.configure.MultiDataSource;
import com.han.adminserver.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.han.adminserver.BaseService;
import com.han.adminserver.service.UserService;

@Service
public class UserServiceImpl extends BaseService implements UserService {
    protected static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);


	@Override
	public User getUserById(Short source, Integer id) {

		if (source == 1){
			return getUserFromSource1(id);
		}else {
			return getUserFromSource1(id);
		}

	}


	@DataSource(value = MultiDataSource.MULTI_DB1)
	private User getUserFromSource1(Integer id){
		return userMapper.selectByPK(id);
	}

	@DataSource(value = MultiDataSource.MULTI_DB2)
	private User getUserFromSource2(Integer id){
		return userMapper.selectByPK(id);
	}




}
