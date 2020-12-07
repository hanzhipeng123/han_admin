package com.han.adminlogin.handler;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *@author sunq
 *@date2020/11/10 10:29
 *@Description
 */

@Service("iconModuleHandler")
public class IconModuleHandler implements ModuleType<ModuleSaveReq>{

	@Override
	public ModuleQueryResult handleModuleQuery(Integer moduleId) {
		System.out.println("handle icon query service!");
		return null;
	}

	@Override
	public void handleModuleSave(ModuleSaveReq req) {
		System.out.println("handle icon save service!");
	}





}
