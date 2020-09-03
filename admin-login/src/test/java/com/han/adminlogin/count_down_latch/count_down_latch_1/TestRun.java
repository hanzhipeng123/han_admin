package com.han.adminlogin.count_down_latch.count_down_latch_1;

/**
 *@author sunq
 *@date2019/11/22 16:16
 *@Description
 */
public class TestRun {


	public static void main(String[] args) throws InterruptedException {

		MyService service = new MyService();

		MyThread t = new MyThread(service);

		t.start();

		Thread.sleep(2000);
		System.out.println(" 线程要继续向下 执行了");

		service.downMethod();
	}


	/**
	 *  运行结果：
	 *
	 *  A
	 *  线程要继续向下 执行了
	 *  X
	 *  B
	 *
	 *
	 *  代码 new CountDownLatch(1) 的作用 是创建 1个计数的 CountDownLatch类的对象，当线程执行到 down.await() 代码时呈 等待状态，程序不继续向下运行
	 *  	，程序执行 down.countDown() 代码时，计数由 1 变成 0，以前呈等待状态的线程 继续向下运行
	 *
	 */


}
