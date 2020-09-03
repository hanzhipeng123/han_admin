package com.han.adminlogin.concurrent1.semaphore_fair_test;

import java.util.concurrent.Semaphore;

/**
 *@author sunq
 *@date2019/11/13 17:04
 *@Description
 */
public class SemaphoreFairService {

	private Boolean isFair = true;
	private Semaphore semaphore = new Semaphore(1, isFair);

	public void testMethod(){

		try {
			semaphore.acquire();

			System.out.println("ThreadName = " + Thread.currentThread().getName());

		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			semaphore.release();
		}

	}


}
