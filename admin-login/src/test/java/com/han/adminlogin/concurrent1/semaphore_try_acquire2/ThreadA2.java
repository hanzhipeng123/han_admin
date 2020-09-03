package com.han.adminlogin.concurrent1.semaphore_try_acquire2;

/**
 *@author sunq
 *@date2019/11/20 15:14
 *@Description
 */
public class ThreadA2 extends Thread {


	private TryAcquireTime tryAcquireTime;

	public ThreadA2(TryAcquireTime tryAcquireTime){
		super();
		this.tryAcquireTime = tryAcquireTime;
	}

	@Override
	public void run() {
		tryAcquireTime.testMethod2();
	}
}
