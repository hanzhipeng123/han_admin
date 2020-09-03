package com.han.adminlogin.concurrent1.semaphore_fair_test;

/**
 *@author sunq
 *@date2019/11/13 17:08
 *@Description
 */
public class SemaphoreFairRun {

	public static void main(String[] args) {

		SemaphoreFairService semaphoreFairService = new SemaphoreFairService();

		MyThread thread = new MyThread(semaphoreFairService);
		thread.start();



		MyThread[] threadArray = new MyThread[4];

		for (int i = 0; i < threadArray.length ; i++) {

			threadArray[i] = new MyThread(semaphoreFairService);
			threadArray[i].start();

		}



	}


	/**
	 *
	 *  private Boolean isFair = false;
	 * 	private Semaphore semaphore = new Semaphore(1, isFair);
	 * 执行结果：
	 * ThreadName = Thread-4 启动了！
	 * ThreadName = Thread-3 启动了！
	 * ThreadName = Thread-3
	 * ThreadName = Thread-4
	 * ThreadName = Thread-2 启动了！
	 * ThreadName = Thread-2
	 * ThreadName = Thread-1 启动了！
	 * ThreadName = Thread-1
	 * ThreadName = Thread-0 启动了！
	 * ThreadName = Thread-0
	 *
	 *
	 *  private Boolean isFair = true;
	 * 	private Semaphore semaphore = new Semaphore(1, isFair);
	 * 执行结果：
	 * ThreadName = Thread-0 启动了！
	 * ThreadName = Thread-0
	 * ThreadName = Thread-1 启动了！
	 * ThreadName = Thread-1
	 * ThreadName = Thread-2 启动了！
	 * ThreadName = Thread-2
	 * ThreadName = Thread-3 启动了！
	 * ThreadName = Thread-3
	 * ThreadName = Thread-4 启动了！
	 * ThreadName = Thread-4
	 *
	 *
	 * 总结：如果是公平信号量，谁先启动谁就先 执行 acquire() 方法，先获取到许可然后执行，
	 * 		 如果是非公平信号量，不一定是谁先 启动就 能执行 acquire() 方法 也就是获取许可
	 *
	 *
	 *
	 *
	 */



}
