package com.han.adminlogin.concurrent1.semaphore_exchange;

import java.util.concurrent.Exchanger;

/**
 *@author sunq
 *@date2019/11/22 15:30
 *@Description
 */
public class TestRun {


	public static void main(String[] args) {


		Exchanger<String> exchanger = new Exchanger<>();
		ThreadA threadA = new ThreadA(exchanger);
		threadA.start();
		System.out.println(" main end !");
	}

	/**
	 *  运行结果：
	 *
	 *  main end !
	 *
	 *  没有其他输出，exchanger.exchanger() 具有阻塞的特色，也就是此方法被调用以后等待其他线程来取得数据，如果没有其他线程取得数据，则一直阻塞等待
	 */
}
