package com.han.adminlogin.concurrent1.semaphore_try_acquire;

/**
 *@author sunq
 *@date2019/11/20 15:14
 *@Description
 */
public class ThreadB extends Thread {


	private TryAcquireService tryAcquireService;

	public ThreadB(TryAcquireService tryAcquireService){
		super();
		this.tryAcquireService = tryAcquireService;
	}

	@Override
	public void run() {
		tryAcquireService.testMethod();
	}
}
