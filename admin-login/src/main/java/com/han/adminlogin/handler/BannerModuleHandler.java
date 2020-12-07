package com.han.adminlogin.handler;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *@author sunq
 *@date2020/11/10 10:29
 *@Description
 */

@Service("bannerModuleHandler")
public class BannerModuleHandler implements ModuleType<ModuleSaveReq>,BannerService{

	@Override
	public ModuleQueryResult handleModuleQuery(Integer moduleId) {
		System.out.println("handle banner query service!");
		return null;
	}

	@Override
	public void handleModuleSave(ModuleSaveReq req) {
		System.out.println("handle banner save service!");
	}

	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public void handleModuleSave2(ModuleSaveReq req) {
		System.out.println("handle icon save service2!");
	}


}
