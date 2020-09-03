package com.han.adminlogin.concurrent1.semaphore_exchange_3;

import java.util.concurrent.Exchanger;

/**
 *@author sunq
 *@date2019/11/22 15:49
 *@Description
 */
public class TestRun {


	public static void main(String[] args) {

		Exchanger<String> exchanger = new Exchanger<>();

		ThreadA a = new ThreadA(exchanger);

		a.start();

		System.out.println("main end !");
	}


	/**
	 *
	 * 运行结果：
	 *
	 * main end !
	 * java.util.concurrent.TimeoutException
	 * 	at java.util.concurrent.Exchanger.exchange(Exchanger.java:626)
	 * 	at com.han.adminlogin.concurrent1.semaphore_exchange_3.ThreadA.run(ThreadA.java:25)
	 *
	 *
	 *
	 * 	exchanger.exchange(V x, long timeout, TimeUnit unit)，方法在指定的时间内没有其他线程获取数据，则出现超时异常。
	 *
	 *
	 */


}
