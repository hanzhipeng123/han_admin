package com.han.adminlogin.service.base;

import com.han.adminlogin.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseService {

    @Autowired
    protected UserInfoMapper userInfoMapper;

}
