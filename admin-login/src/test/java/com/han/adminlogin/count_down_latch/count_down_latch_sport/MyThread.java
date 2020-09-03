package com.han.adminlogin.count_down_latch.count_down_latch_sport;

import java.util.concurrent.CountDownLatch;

/**
 *@author sunq
 *@date2019/11/22 16:37
 *@Description
 */
public class MyThread extends Thread {


	private CountDownLatch maxRunner;

	public MyThread(CountDownLatch maxRunner){
		super();
		this.maxRunner = maxRunner;
	}

	@Override
	public void run() {

		try {
			Thread.sleep(2000);

			maxRunner.countDown();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
