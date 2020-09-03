package com.han.adminlogin.concurrent1.semaphore_more_to_one;

import com.han.adminlogin.utils.DateUtil;

import java.util.concurrent.Semaphore;

/**
 *@author sunq
 *@date2019/11/20 16:22
 *@Description
 */
public class MoreToOneService {

	private Semaphore semaphore = new Semaphore(3);


	public void testMethod(){

		try {
			semaphore.acquire();
			System.out.println("ThreadName = " + Thread.currentThread().getName() + " 准备 ");

			System.out.println("begin hello " + DateUtil.timeFormat(System.currentTimeMillis()));
			for (int i = 0; i < 5; i++) {
				System.out.println(Thread.currentThread().getName() + " 打印 " + (i + 1));
			}
			System.out.println("end hello " + DateUtil.timeFormat(System.currentTimeMillis()));
			semaphore.release();
			System.out.println("ThreadName = " + Thread.currentThread().getName() + " 结束 ");



		} catch (InterruptedException e) {
			e.printStackTrace();
		}


	}


}
