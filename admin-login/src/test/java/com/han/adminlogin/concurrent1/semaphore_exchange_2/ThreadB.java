package com.han.adminlogin.concurrent1.semaphore_exchange_2;

import java.util.concurrent.Exchanger;

/**
 *@author sunq
 *@date2019/11/22 15:34
 *@Description
 */
public class ThreadB extends Thread {

	private Exchanger<String> exchanger;


	public ThreadB(Exchanger<String> exchanger){
		super();
		this.exchanger = exchanger;
	}

	@Override
	public void run() {

		try {
			System.out.println(" 在线程 B 中得到线程 A 的值 = " + exchanger.exchange("中国人B"));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
