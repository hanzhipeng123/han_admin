package com.han.adminlogin.concurrent1.semaphore2;

/**
 *@author sunq
 *@date2019/11/13 14:52
 *@Description
 */
public class TestRun {


	public static void main(String[] args) {

		SemaphoreServiceTest1 serviceTest1 = new SemaphoreServiceTest1();

		// 分别创建 ABC三个线程，使用 SemaphoreServiceTest1中的方法，此时有两个信号
		// 通过结果过可以看出，此时可以有两个线程同时执行 acquire() 和 release() 之间的代码，
		// 另外需要说明的是，对于Semaphore类的构造方法传递的参数 permits 如果大于 1，该类并不能保证线程安全性，
			// 因为还是有可能会出现多个线程共同访问实例变量，导致出现脏数据的情况
		ThreadA a = new ThreadA(serviceTest1);
		a.setName("Thread-AAAA");

		ThreadB b = new ThreadB(serviceTest1);
		b.setName("Thread-BBBB");

		ThreadC c = new ThreadC(serviceTest1);
		c.setName("Thread-CCCC");

		a.start();
		b.start();
		c.start();


	}

	/**
	 *  输出结果：
	 * Thread-AAAA 开始时间：1573628463351
	 * Thread-BBBB 开始时间：1573628463353
	 * Thread-AAAA 结束时间：1573628468351
	 * Thread-CCCC 开始时间：1573628468351
	 * Thread-BBBB 结束时间：1573628468353
	 * Thread-CCCC 结束时间：1573628473352
	 */


}
