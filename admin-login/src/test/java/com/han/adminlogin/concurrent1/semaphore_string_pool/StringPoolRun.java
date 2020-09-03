package com.han.adminlogin.concurrent1.semaphore_string_pool;

/**
 *@author sunq
 *@date2019/11/20 17:02
 *@Description
 */
public class StringPoolRun {

	public static void main(String[] args) {

		StringPool stringPool = new StringPool();

		MyThread[] threadArray = new MyThread[5];

		for (int i = 0; i < threadArray.length; i++) {
			threadArray[i] = new MyThread(stringPool);
		}
		for (int i = 0; i < threadArray.length; i++) {
			threadArray[i].start();
		}




	}
}
