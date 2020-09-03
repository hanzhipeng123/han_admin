package com.han.adminlogin.concurrent1.semaphore_try_acquire;

import java.util.concurrent.Semaphore;

/**
 *@author sunq
 *@date2019/11/20 14:36
 *@Description
 */
public class TryAcquireService {


	private Semaphore semaphore = new Semaphore(1);


	public void testMethod(){
		if (semaphore.tryAcquire()){
			System.out.println("ThreadName=" + Thread.currentThread().getName() + "首次进入！");

			for (int i = 0; i < Integer.MAX_VALUE; i++) {
				String s = new String();
				Math.random();
			}
			semaphore.release();
		}else {
			System.out.println("ThreadName=" + Thread.currentThread().getName() + "未成功进入！");
		}
	}


}
