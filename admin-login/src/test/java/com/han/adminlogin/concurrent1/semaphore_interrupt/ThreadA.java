package com.han.adminlogin.concurrent1.semaphore_interrupt;

import com.han.adminlogin.concurrent1.semaphore1.SemaphoreServiceTest1;

/**
 *@author sunq
 *@date2019/11/13 14:49
 *@Description
 */
public class ThreadA extends Thread {

	private SemaphoreInterrupt semaphoreInterrupt;

	public ThreadA(SemaphoreInterrupt semaphoreInterrupt){
		super();
		this.semaphoreInterrupt = semaphoreInterrupt;
	}

	@Override
	public void run() {
		semaphoreInterrupt.testMethod();
	}
}
