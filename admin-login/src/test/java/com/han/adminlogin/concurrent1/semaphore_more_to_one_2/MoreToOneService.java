package com.han.adminlogin.concurrent1.semaphore_more_to_one_2;

import com.han.adminlogin.utils.DateUtil;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 *@author sunq
 *@date2019/11/20 16:22
 *@Description
 */
public class MoreToOneService {

	private Semaphore semaphore = new Semaphore(3);
	private ReentrantLock lock = new ReentrantLock();


	public void testMethod2(){

		try {
			semaphore.acquire();
			System.out.println("ThreadName = " + Thread.currentThread().getName() + " 准备 ");

			// 加锁
			lock.lock();

			System.out.println("begin hello " + DateUtil.timeFormat(System.currentTimeMillis()));
			for (int i = 0; i < 5; i++) {
				System.out.println(Thread.currentThread().getName() + " 打印 " + (i + 1));
			}
			System.out.println("end hello " + DateUtil.timeFormat(System.currentTimeMillis()));
			lock.unlock();
			semaphore.release();
			System.out.println("ThreadName = " + Thread.currentThread().getName() + " 结束 ");


		} catch (InterruptedException e) {
			e.printStackTrace();
		}


	}


}
