package com.han.adminlogin.concurrent1.semaphore_queue_test;

import java.util.concurrent.Semaphore;

/**
 *@author sunq
 *@date2019/11/13 16:53
 *@Description
 */
public class SemaphoreQueueTest {


	private Semaphore semaphore = new Semaphore(1);



	public void testMethod(){


		try {
			semaphore.acquire();
			Thread.sleep(1000);

			System.out.println(" 还有大约 " + semaphore.getQueueLength() + "个线程在等待");
			System.out.println(" 是否有线程正在等待信号量呢？" + semaphore.hasQueuedThreads());

		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			semaphore.release();
		}


	}




}
