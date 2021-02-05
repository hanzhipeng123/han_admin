package com.han.adminlogin.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *@author sunq
 *@date2021/1/27 18:30
 *@Description
 */
@Component
public class Student {


	private String name;

	public Student() {
		System.out.println(1111);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
