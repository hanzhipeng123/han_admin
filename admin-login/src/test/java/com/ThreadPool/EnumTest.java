package com.ThreadPool;

/**
 *@author sunq
 *@date2020/9/27 14:04
 *@Description
 */
public enum EnumTest {
	A(1,"a"),B(2,"b");


	EnumTest(Integer id, String name) {
		this.id = id;
		Name = name;
	}

	private Integer id;

	private String Name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}
}
