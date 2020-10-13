package com.pool;

/**
 *@author sunq
 *@date2020/9/24 16:16
 *@Description
 */
public class MyTask implements Runnable{


	String name;

	public MyTask(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public void run() {
		System.out.println("===================task==========" + name);
	}
}
