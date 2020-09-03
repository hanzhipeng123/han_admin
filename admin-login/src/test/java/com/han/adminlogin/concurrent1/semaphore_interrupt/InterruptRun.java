package com.han.adminlogin.concurrent1.semaphore_interrupt;

/**
 *@author sunq
 *@date2019/11/13 15:54
 *@Description
 */
public class InterruptRun {

	public static void main(String[] args) throws InterruptedException {

		SemaphoreInterrupt semaphoreInterrupt = new SemaphoreInterrupt();

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
	 * AA start：2019-11-13 16:00:53
	 * AA end：2019-11-13 16:00:59
	 * main 中断了 a
	 * 线程 BB 进入了catch：2019-11-13 16:00:59
	 * java.lang.InterruptedException
	 * 	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:998)
	 * 	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	 * 	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	 * 	at com.han.adminlogin.concurrent1.semaphore_interrupt.SemaphoreInterrupt.testMethod(SemaphoreInterrupt.java:21)
	 * 	at com.han.adminlogin.concurrent1.semaphore_interrupt.ThreadB.run(ThreadB.java:21)
	 *
	 * 	 线程B被成功中断
	 *
	 *
	 */
}
