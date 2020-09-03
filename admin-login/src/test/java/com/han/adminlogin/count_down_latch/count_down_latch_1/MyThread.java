package com.han.adminlogin.count_down_latch.count_down_latch_1;

/**
 *@author sunq
 *@date2019/11/22 16:14
 *@Description
 */
public class MyThread extends Thread {

	private MyService service;

	public MyThread(MyService service){
		super();
		this.service = service;
	}

	@Override
	public void run() {

		service.testMethod();
	}
}
