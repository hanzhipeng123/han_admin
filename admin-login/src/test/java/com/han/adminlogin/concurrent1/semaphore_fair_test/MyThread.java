package com.han.adminlogin.concurrent1.semaphore_fair_test;

/**
 *@author sunq
 *@date2019/11/13 17:06
 *@Description
 */
public class MyThread extends Thread {

	private SemaphoreFairService semaphoreFairService = new SemaphoreFairService();

	public MyThread(SemaphoreFairService semaphoreFairService) {
		this.semaphoreFairService = semaphoreFairService;
	}

	@Override
	public void run() {
		System.out.println("ThreadName = " + this.getName() + " 启动了！");
		semaphoreFairService.testMethod();
	}
}
