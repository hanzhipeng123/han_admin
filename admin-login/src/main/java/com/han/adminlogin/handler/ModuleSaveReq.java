package com.han.adminlogin.handler;

/**
 *@author sunq
 *@date2020/11/10 10:26
 *@Description
 */
public class ModuleSaveReq {

	private Integer moduleId;

	private Integer type;

	private String name;

	private String content;

	public Integer getModuleId() {
		return moduleId;
	}

	public void setModuleId(Integer moduleId) {
		this.moduleId = moduleId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
