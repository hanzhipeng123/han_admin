package com.han.adminlogin.concurrent1.semaphore_exchange_3;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 *@author sunq
 *@date2019/11/22 15:45
 *@Description
 */
public class ThreadA extends Thread {

	private Exchanger<String> exchanger;

	public ThreadA(Exchanger<String> exchanger){
		super();
		this.exchanger = exchanger;
	}

	@Override
	public void run() {

		try {
			System.out.println(" 在线程A 中得到线程 B 的值 = " + exchanger.exchange(" 中国人A", 5, TimeUnit.SECONDS));
			System.out.println("A end ！");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
	}
}
