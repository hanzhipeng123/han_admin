package com.han.adminlogin;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *@author sunq
 *@date2020/1/15 17:34
 *@Description
 */
public class CASTest implements Runnable{

	private static volatile int value = 0;

	public void add(){
		value++;
	}

	@Override
	public void run() {
		add();
	}


	public static void main(String[] args) throws InterruptedException {

		ExecutorService es = Executors.newCachedThreadPool();

		for (int i = 0; i < 1000000; i++) {
			es.submit(new CASTest());
		}

		Thread.sleep(1000);
		System.out.println(value);
		es.shutdown();
	}
}
