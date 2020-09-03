package com.han.adminlogin.concurrent1.semaphore_try_acquire2;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 *@author sunq
 *@date2019/11/20 15:21
 *@Description
 */
public class TryAcquireTime {

	private Semaphore semaphore = new Semaphore(1);

	public void testMethod2(){
		try {
			if (semaphore.tryAcquire(3, TimeUnit.SECONDS)){
//				if (semaphore.tryAcquire()){
				System.out.println("ThreadName=" + Thread.currentThread().getName() + "首次进入！");

				for (int i = 0; i < Integer.MAX_VALUE; i++) {
//					String s = new String();
//					Math.random();
				}
				semaphore.release();
			}else {
				System.out.println("ThreadName=" + Thread.currentThread().getName() + "未成功进入！");
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}


}
