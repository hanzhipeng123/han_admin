package com.han.adminlogin.count_down_latch.count_down_latch_1;

import java.util.concurrent.CountDownLatch;

/**
 *@author sunq
 *@date2019/11/22 16:02
 *@Description
 */
public class MyService {

	private CountDownLatch down = new CountDownLatch(1);

	public void testMethod(){

		try {
			System.out.println(" A ");

			down.await();

			System.out.println(" B ");

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


	public void downMethod(){

		System.out.println(" X ");

		down.countDown();

	}



}
