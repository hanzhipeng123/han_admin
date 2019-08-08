CREATE TABLE `user_info` (
  `userId` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `unionId` varchar(255) NOT NULL DEFAULT '' COMMENT '用户唯一标识',
  `nickname` varchar(255) NOT NULL COMMENT '用户昵称',
  `mobile` varchar(64) NOT NULL COMMENT '用户手机号',
  `registryPlatform` tinyint(4) DEFAULT NULL COMMENT '用户平台：1-applet 2-ios 3-android',
  `deviceToken` varchar(255) DEFAULT NULL COMMENT '用户设备令牌',
  `brthday` varchar(11) DEFAULT NULL COMMENT '生日',
  `userPic` varchar(255) DEFAULT NULL COMMENT '用户头像',
  `recProvinceId` int(11) DEFAULT NULL COMMENT '省',
  `recCityId` int(11) DEFAULT NULL COMMENT '市',
  `recDistrictId` int(11) DEFAULT NULL COMMENT '区',
  `createTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `bindingMobileTime` timestamp NULL DEFAULT NULL COMMENT '首次绑定手机号时间',
  `updateTime` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  `version` int(11) DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
