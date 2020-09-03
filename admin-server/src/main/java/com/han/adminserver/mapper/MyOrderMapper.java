package com.han.adminserver.mapper;

import com.han.adminserver.entity.MyOrder;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MyOrderMapper{

	int insert(MyOrder myOrder);

	int insertSelective(MyOrder myOrder);

	int updateByPK(MyOrder myOrder);

	int updateByPKSelective(MyOrder myOrder);

	int deleteByPK(Integer myOrder);

	MyOrder selectByPK(Integer myOrder);

}
