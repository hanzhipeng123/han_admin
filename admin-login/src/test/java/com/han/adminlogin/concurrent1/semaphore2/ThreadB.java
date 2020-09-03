package com.han.adminlogin.concurrent1.semaphore2;

/**
 *@author sunq
 *@date2019/11/13 14:49
 *@Description
 */
public class ThreadB extends Thread {

	private SemaphoreServiceTest1 serviceTest1;

	public ThreadB(SemaphoreServiceTest1 semaphoreServiceTest1){
		super();
		this.serviceTest1 = semaphoreServiceTest1;
	}

	@Override
	public void run() {
		serviceTest1.testMethod();
	}
}
