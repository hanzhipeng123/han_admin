package com.han.adminlogin.concurrent1.semaphore_un_inturrupt;

import com.han.adminlogin.utils.DateUtil;

import java.util.concurrent.Semaphore;

/**
 *@author sunq
 *@date2019/11/13 15:50
 *@Description
 */
public class SemaphoreUnInterrupt {


	private Semaphore semaphore = new Semaphore(1);


	public void testMethod() {
		// 许可使用过程中不允许被中断
			semaphore.acquireUninterruptibly();

			System.out.println(Thread.currentThread().getName() + " start：" + DateUtil.timeFormat(System.currentTimeMillis()));

			for (int i = 0; i < Integer.MAX_VALUE / 50; i++) {
				String s = new String();
				Math.random();
			}

			System.out.println(Thread.currentThread().getName() + " end：" + DateUtil.timeFormat(System.currentTimeMillis()));

			semaphore.release();

	}
}
