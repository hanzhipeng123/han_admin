package com.han.adminlogin.concurrent1.semaphore_interrupt;

import com.han.adminlogin.utils.DateUtil;

import java.util.concurrent.Semaphore;

/**
 *@author sunq
 *@date2019/11/13 15:50
 *@Description
 */
public class SemaphoreInterrupt {


	private Semaphore semaphore = new Semaphore(1);


	public void testMethod() {
		// 许可使用过程中被中断
		try {
			semaphore.acquire();

			System.out.println(Thread.currentThread().getName() + " start：" + DateUtil.timeFormat(System.currentTimeMillis()));

			for (int i = 0; i < Integer.MAX_VALUE / 50; i++) {
				String s = new String();
				Math.random();
			}

			System.out.println(Thread.currentThread().getName() + " end：" + DateUtil.timeFormat(System.currentTimeMillis()));

			semaphore.release();

		} catch (InterruptedException e) {

			System.out.println("剩余可用许可数：" + semaphore.availablePermits());
			System.out.println("线程 " + Thread.currentThread().getName() + " 进入了catch：" + DateUtil.timeFormat(System.currentTimeMillis()));

			e.printStackTrace();
		}


	}
}
