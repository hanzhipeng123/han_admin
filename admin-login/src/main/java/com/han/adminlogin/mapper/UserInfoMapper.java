package com.han.adminlogin.mapper;

import com.han.adminlogin.entity.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserInfoMapper extends BaseMapper<UserInfo> {

	void batchUpdate(@Param("userList") List<UserInfo> userList);

}
