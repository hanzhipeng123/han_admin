package com.han.adminserver.mapper;

import com.han.adminserver.entity.Inv;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface InvMapper{

	int insert(Inv inv);

	int insertSelective(Inv inv);

	int updateByPK(Inv inv);

	int updateByPKSelective(Inv inv);

	int deleteByPK(Integer inv);

	Inv selectByPK(Integer inv);

}
