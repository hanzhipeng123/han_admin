package com.han.adminlogin.concurrent1.semaphore_exchange_2;

import java.util.concurrent.Exchanger;

/**
 *@author sunq
 *@date2019/11/22 15:37
 *@Description
 */
public class TestRun {

	public static void main(String[] args) {

		Exchanger<String> exchanger = new Exchanger<>();

		ThreadA a = new ThreadA(exchanger);
		ThreadB b = new ThreadB(exchanger);

		a.start();
		b.start();


	}


	/**
	 *  运行结果：
	 *  在线程 B 中得到线程 A 的值 = 中国人A
	 *  在线程 A 中得到线程 B 的值 = 中国人B
	 *
	 *
	 * exchanger.exchanger() 用来交换两个线程的值
	 */


}
