package com.han.adminlogin.concurrent1.semaphore_try_acquire;

/**
 *@author sunq
 *@date2019/11/20 15:14
 *@Description
 */
public class ThreadA extends Thread {


	private TryAcquireService tryAcquireService;

	public ThreadA(TryAcquireService tryAcquireService){
		super();
		this.tryAcquireService = tryAcquireService;
	}

	@Override
	public void run() {
		tryAcquireService.testMethod();
	}
}
