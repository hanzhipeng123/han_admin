package com.han.adminlogin.concurrent1.semaphore_un_inturrupt;

/**
 *@author sunq
 *@date2019/11/13 14:49
 *@Description
 */
public class ThreadA extends Thread {

	private SemaphoreUnInterrupt semaphoreInterrupt;

	public ThreadA(SemaphoreUnInterrupt semaphoreInterrupt){
		super();
		this.semaphoreInterrupt = semaphoreInterrupt;
	}

	@Override
	public void run() {
		semaphoreInterrupt.testMethod();
	}
}
