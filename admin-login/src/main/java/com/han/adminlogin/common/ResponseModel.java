package com.han.adminlogin.common;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *@author sunq
 *@date2019/8/5 17:24
 *@Description
 */
public class ResponseModel implements Serializable {

	private String code;	// 状态码

	private String message;	// 提示

	private Object data;	// 数据

	private String fileDomain;		// 文件服务器前缀

	private Long requestTime;		// 调用时间戳


	public ResponseModel() {
		super();
		this.requestTime = new Date().getTime();
	}


	public ResponseModel(String key, Object value) {
		super();
		Map<String, Object> data = new HashMap<String, Object>();
		data.put(key, value);
		this.data = data;
		this.requestTime = new Date().getTime();
	}

	public ResponseModel(String code, String message, Integer level,Object data,Integer freeExpressAmount) {
		super();
		this.code = code;
		this.message = message;
		this.data = data;
		this.requestTime = new Date().getTime();
	}

	public ResponseModel(String code, String message, String fileDomain,Object data,Long requestTime) {
		super();
		this.code = code;
		this.message = message;
		this.fileDomain = fileDomain;
		this.data = data;
		this.requestTime = new Date().getTime();
	}

	public ResponseModel warpSuccess() {
		return this.setCode(ApiCallResult.SUCCESS.getCode()).setMessage(ApiCallResult.SUCCESS.getDesc());
	}

	public ResponseModel warpFailedMessage(String code,String errorMessage) {
		return this.setCode(code).setMessage(errorMessage);
	}





	public String getCode() {
		return code;
	}

	public ResponseModel setCode(String code) {
		this.code = code;
		return this;
	}

	public String getMessage() {
		return message;
	}

	public ResponseModel setMessage(String message) {
		this.message = message;
		return this;
	}

	public Object getData() {
		return data;
	}

	public ResponseModel setData(Object data) {
		this.data = data;
		return this;
	}

	public String getFileDomain() {
		return fileDomain;
	}

	public ResponseModel setFileDomain(String fileDomain) {
		this.fileDomain = fileDomain;
		return this;
	}



	public Long getRequestTime() {
		return requestTime;
	}

	public ResponseModel setRequestTime(Long requestTime) {
		this.requestTime = requestTime;
		return this;
	}
}
