package com.han.adminlogin.concurrent1.semaphore_queue_test;

/**
 *@author sunq
 *@date2019/11/13 16:56
 *@Description
 */
public class MyThread extends Thread {

	private SemaphoreQueueTest semaphoreQueueTest = new SemaphoreQueueTest();

	public MyThread(SemaphoreQueueTest semaphoreQueueTest) {
		super();
		this.semaphoreQueueTest = semaphoreQueueTest;
	}

	@Override
	public void run() {
		semaphoreQueueTest.testMethod();
	}
}
