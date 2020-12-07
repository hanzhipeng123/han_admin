package com.han.adminlogin.handler;

/**
 *@author sunq
 *@date2020/11/10 10:23
 *@Description
 */
public interface ModuleType<T> {

	ModuleQueryResult handleModuleQuery(Integer moduleId);

	void  handleModuleSave(T t);


}
