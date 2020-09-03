package com.han.adminserver;

import org.springframework.beans.factory.annotation.Autowired;

public class BaseService {

    @Autowired
    protected com.han.adminserver.mapper.InvMapper invMapper;
    @Autowired
    protected com.han.adminserver.mapper.UserMapper userMapper;
    @Autowired
	protected com.han.adminserver.mapper.MyOrderMapper myOrderMapper;


}
