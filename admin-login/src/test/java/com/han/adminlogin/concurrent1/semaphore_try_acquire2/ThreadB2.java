package com.han.adminlogin.concurrent1.semaphore_try_acquire2;

/**
 *@author sunq
 *@date2019/11/20 15:14
 *@Description
 */
public class ThreadB2 extends Thread {


	private TryAcquireTime tryAcquireTime;

	public ThreadB2(TryAcquireTime tryAcquireTime){
		super();
		this.tryAcquireTime = tryAcquireTime;
	}

	@Override
	public void run() {
		tryAcquireTime.testMethod2();
	}
}
