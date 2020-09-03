package com.han.adminserver.mapper;

import com.han.adminserver.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper{

	int insert(User user);

	int insertSelective(User user);

	int updateByPK(User user);

	int updateByPKSelective(User user);

	int deleteByPK(Integer user);

	User selectByPK(Integer user);

}
