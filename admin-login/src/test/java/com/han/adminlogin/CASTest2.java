package com.han.adminlogin;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *@author sunq
 *@date2020/1/15 17:34
 *@Description
 */
public class CASTest2 implements Runnable{


	private static volatile AtomicInteger value = new AtomicInteger(0);

	public void add(){
		value.incrementAndGet();
	}

	@Override
	public void run() {
		add();
	}


	public static void main(String[] args) throws InterruptedException {

		ExecutorService es = Executors.newCachedThreadPool();

		for (int i = 0; i < 1000000; i++) {
			es.submit(new CASTest2());
		}

		Thread.sleep(1000);
		System.out.println(value);
		es.shutdown();
	}
}
