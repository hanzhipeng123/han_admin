package com.han.adminlogin.common;

/**
 *@author sunq
 *@date2019/8/5 17:36
 *@Description
 */
public enum ApiCallResult {

	SUCCESS("200", "操作成功"),
	EMPTY("001", "参数缺失"),
	EXCEPTION("1001","系统异常"),
	FAILURE("999", "操作失败");

	private String code;
	private String desc;

	private ApiCallResult(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}
