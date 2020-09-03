package com.han.adminlogin.concurrent1.semaphore_many_permits;

import java.util.concurrent.Semaphore;

/**
 *@author sunq
 *@date2019/11/13 15:40
 *@Description
 */
public class addPermitsCount {

	public static void main(String[] args) {

		Semaphore semaphore = new Semaphore(5);

		try {
			// 先消耗4个
			semaphore.acquire();
			semaphore.acquire();
			semaphore.acquire();
			semaphore.acquire();
			System.out.println("剩余可用许可数：" + semaphore.availablePermits());
			semaphore.acquire();
			System.out.println("剩余可用许可数：" + semaphore.availablePermits());

			// 在释放六个
			semaphore.release();
			semaphore.release();
			semaphore.release();
			semaphore.release();
			semaphore.release();
			semaphore.release();

			System.out.println("剩余可用许可数：" + semaphore.availablePermits());
			// 再释放4个
			semaphore.release(4);
			System.out.println("剩余可用许可数：" + semaphore.availablePermits());

		} catch (InterruptedException e) {
			e.printStackTrace();
		}


	}


	/**
	 *  结果：
	 * 剩余可用许可数：1
	 * 剩余可用许可数：0
	 * 剩余可用许可数：6
	 * 剩余可用许可数：10
	 *
	 *
	 * 结果可以看出：
	 * 1、许可的数量是可以动态修改的
	 * 2、Semaphore 的构造方法传入的 permits 数量，不并不是最终的许可的数量，仅仅只是初始的状态值
	 *
	 */



}
