package com.han.adminlogin.concurrent1.semaphore_queue_test;

/**
 *@author sunq
 *@date2019/11/13 16:58
 *@Description
 */
public class SemaphoreQueueRun {


	public static void main(String[] args) {

		SemaphoreQueueTest semaphoreQueueTest = new SemaphoreQueueTest();


		MyThread firstThread = new MyThread(semaphoreQueueTest);
		firstThread.start();

		MyThread[] threadArray = new MyThread[4];

		for (int i = 0; i < threadArray.length; i++) {
			threadArray[i] = new MyThread(semaphoreQueueTest);
			threadArray[i].start();
		}

		/**
		 * 执行结果：
		 *  还有大约 4个线程在等待
		 *  是否有线程正在等待信号量呢？true
		 *  还有大约 3个线程在等待
		 *  是否有线程正在等待信号量呢？true
		 *  还有大约 2个线程在等待
		 *  是否有线程正在等待信号量呢？true
		 *  还有大约 1个线程在等待
		 *  是否有线程正在等待信号量呢？true
		 *  还有大约 0个线程在等待
		 *  是否有线程正在等待信号量呢？false
		 *
		 *
		 *  getQueueLength() 表示还有多少个线程在等待 执行许可
		 * 	hasQueuedThreads() 表示还有没有线程 在等待许可
		 *
		 *
		 */


	}



}
