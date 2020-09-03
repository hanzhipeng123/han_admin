package com.han.adminlogin.concurrent1.semaphore_string_pool;

/**
 *@author sunq
 *@date2019/11/20 16:59
 *@Description
 */
public class MyThread extends Thread {

	private StringPool stringPool;

	public MyThread(StringPool stringPool){
		super();
		this.stringPool = stringPool;
	}

	@Override
	public void run() {
		for (int i = 0; i < Integer.MAX_VALUE; i++) {

			String getString = stringPool.get();
			System.out.println(Thread.currentThread().getName() + " 取得值 : " + getString);
			stringPool.put(getString);
		}
	}
}
