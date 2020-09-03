package com.han.adminlogin.concurrent1.semaphore_more_to_one_2;

/**
 *@author sunq
 *@date2019/11/20 16:27
 *@Description
 */
public class MyThread extends Thread {

	private MoreToOneService service;

	public MyThread(MoreToOneService service){
		super();
		this.service = service;
	}

	@Override
	public void run() {
		service.testMethod2();
	}
}
