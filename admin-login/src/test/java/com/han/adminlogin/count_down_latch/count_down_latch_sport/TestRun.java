package com.han.adminlogin.count_down_latch.count_down_latch_sport;

import java.util.concurrent.CountDownLatch;

/**
 *@author sunq
 *@date2019/11/22 16:40
 *@Description
 */
public class TestRun {


	public static void main(String[] args) {

		CountDownLatch maxRunner = new CountDownLatch(10);

		MyThread[] threadArray = new MyThread[Integer.valueOf(maxRunner.getCount() + "")];

		for (int i = 0; i < threadArray.length; i++) {

			threadArray[i] = new MyThread(maxRunner);
			threadArray[i].setName(" sportsman " + (i + 1));
			threadArray[i].start();
		}
		System.out.println("回来吧！");

	}

	/**
	 *
	 *  运行结果：
	 *
	 *
	 *
	 */

}
