package com.han.adminlogin.concurrent1.semaphore_many_permits;

import com.han.adminlogin.utils.DateUtil;

import java.util.Date;
import java.util.concurrent.Semaphore;

/**
 *@author sunq
 *@date2019/11/13 14:35
 *@Description
 */
public class SemaphoreServiceTest1 {

	/**
	 * 类 Semaphore 的构造函数的参数 permits 是许可的意思，代表同一时间，最多允许多少个线程同时执行 acquire() 和 release() 之间的代码
	 * 也可以传入 >1 的许可，表示同一时间，最多允许有x个线程可以执行 acquire() 和 release() 之间的代码
	 *
	 * 3.0版本，每次调用多个 需要消耗多个permits
	 *
	 */
	private Semaphore semaphore = new Semaphore(10);



	public void testMethod() {



		try {
			// 类似于加锁，无参的 acquire() 方法作用是 使用一个许可，是减法操作
			semaphore.acquire(2);
			System.out.println(Thread.currentThread().getName() + " 开始时间："+ DateUtil.timeFormat(System.currentTimeMillis()));
			// 随机休眠时间
			int sleepValue = ((int)(Math.random() * 10000));

			System.out.println(Thread.currentThread().getName() + " 停止了："+ (sleepValue / 1000) + " 秒 ");
			Thread.sleep(sleepValue);

			System.out.println(Thread.currentThread().getName() + " 结束时间："+ DateUtil.timeFormat(System.currentTimeMillis()));
			// 类似于解锁
			semaphore.release(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


}
