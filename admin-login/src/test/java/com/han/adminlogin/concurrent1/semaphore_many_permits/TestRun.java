package com.han.adminlogin.concurrent1.semaphore_many_permits;

import com.han.adminlogin.concurrent1.semaphore2.ThreadB;
import com.han.adminlogin.concurrent1.semaphore2.ThreadC;

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
		ThreadA[] a = new ThreadA[10];
		for (int i = 0; i < a.length; i++) {
			a[i] = new ThreadA(serviceTest1);
			a[i].start();
		}





	}

	/**
	 *  输出结果：
	 * Thread-2 开始时间：2019-11-13 15:38:55
	 * Thread-0 开始时间：2019-11-13 15:38:55
	 * Thread-3 开始时间：2019-11-13 15:38:55
	 * Thread-4 开始时间：2019-11-13 15:38:55
	 * Thread-2 停止了：0 秒
	 * Thread-4 停止了：5 秒
	 * Thread-3 停止了：2 秒
	 * Thread-0 停止了：0 秒
	 * Thread-1 开始时间：2019-11-13 15:38:55
	 * Thread-1 停止了：1 秒
	 * Thread-2 结束时间：2019-11-13 15:38:55
	 * Thread-5 开始时间：2019-11-13 15:38:55
	 * Thread-5 停止了：0 秒
	 * Thread-0 结束时间：2019-11-13 15:38:56
	 * Thread-6 开始时间：2019-11-13 15:38:56
	 * Thread-6 停止了：5 秒
	 * Thread-5 结束时间：2019-11-13 15:38:56
	 * Thread-7 开始时间：2019-11-13 15:38:56
	 * Thread-7 停止了：0 秒
	 * Thread-1 结束时间：2019-11-13 15:38:56
	 * Thread-8 开始时间：2019-11-13 15:38:56
	 * Thread-8 停止了：3 秒
	 * Thread-7 结束时间：2019-11-13 15:38:57
	 * Thread-9 开始时间：2019-11-13 15:38:57
	 * Thread-9 停止了：4 秒
	 * Thread-3 结束时间：2019-11-13 15:38:58
	 * Thread-8 结束时间：2019-11-13 15:39:00
	 * Thread-4 结束时间：2019-11-13 15:39:00
	 * Thread-6 结束时间：2019-11-13 15:39:01
	 * Thread-9 结束时间：2019-11-13 15:39:02
	 */


}
