package com.han.adminlogin.concurrent1.semaphore_un_inturrupt;

/**
 *@author sunq
 *@date2019/11/13 15:54
 *@Description
 */
public class InterruptRun {

	public static void main(String[] args) throws InterruptedException {

		SemaphoreUnInterrupt semaphoreInterrupt = new SemaphoreUnInterrupt();

		ThreadA a = new ThreadA(semaphoreInterrupt);
		a.setName("AA");
		a.start();

		ThreadB b = new ThreadB(semaphoreInterrupt);
		b.setName("BB");
		b.start();

		Thread.sleep(1000);

		b.interrupt();
		System.out.println("main 中断了 b");


	}


	/**
	 *  执行结果：
	 * AA start：2019-11-13 16:11:20
	 * AA end：2019-11-13 16:11:24
	 * main 中断了 b
	 * BB start：2019-11-13 16:11:24
	 * BB end：2019-11-13 16:11:27
	 *
	 * 	 线程B被成功中断,d但是没有抛出异常
	 *
	 * 	 acquireUninterruptibly() 方法还有重载的方法 acquireUninterruptibly(int permits) ,
	 * 	 此方法的作用是在等待许可的情况下，不允许中断，如果成功获得锁，则取得指定的 permits 个数
	 *
	 *
	 */
}
