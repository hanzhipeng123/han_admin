package com.han.adminlogin.concurrent1.semaphore_exchange_2;

import java.util.concurrent.Exchanger;

/**
 *@author sunq
 *@date2019/11/22 15:34
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
			System.out.println(" 在线程 A 中得到线程 B 的值 = " + exchanger.exchange("中国人A"));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
