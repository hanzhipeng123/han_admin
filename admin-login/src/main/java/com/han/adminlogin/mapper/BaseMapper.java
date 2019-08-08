package com.han.adminlogin.mapper;

/**
 *@author sunq
 *@date2019/8/5 17:06
 *@Description
 */
public interface BaseMapper<T> {
	int insert(T var1);

	int insertSelective(T var1);

	int updateByPK(T var1);

	int updateByPKSelective(T var1);

	int deleteByPK(Integer var1);

	T selectByPK(Integer var1);
}
