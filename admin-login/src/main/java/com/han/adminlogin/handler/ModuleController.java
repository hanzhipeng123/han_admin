package com.han.adminlogin.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *@author sunq
 *@date2020/11/10 11:09
 *@Description
 */
@RestController
@RequestMapping("/test")
public class ModuleController {


	@Autowired
	private ModuleRegister moduleRegister;



	@GetMapping("/query/{moduleId}/{type}")
	public void testQuery(@PathVariable("moduleId") Integer moduleId, @PathVariable("type") Integer type){

		try {
			ModuleType moduleHandler = moduleRegister.getModuleHandlerByType(type);
			System.out.println(moduleHandler);
			moduleHandler.handleModuleQuery(moduleId);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@PostMapping("/save")
	public void testSave(@RequestBody ModuleSaveReq saveReq) throws Exception {

		moduleRegister.getModuleHandlerByType(saveReq.getType()).handleModuleSave(saveReq);

	}



}
