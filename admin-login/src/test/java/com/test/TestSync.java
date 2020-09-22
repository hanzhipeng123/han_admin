package com.test;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 *@author sunq
 *@date2020/9/11 14:15
 *@Description
 */
public class TestSync {

	//
	public static void main(String[] args) throws InterruptedException {

		CasLock lock = new CasLock();


		Thread threadA = new Thread("threadA"){
			@Override
			public void run() {
				synchronized (lock){
					System.out.println("i got lock，sleep 5 second");
					try {
						TimeUnit.SECONDS.sleep(5);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("sleep end，release lock");
				}
			}
		};

		threadA.start();

		// 一秒后创建10个线程获取锁，并启动
		Thread.sleep(1000);

 		for (int i = 0; i < 10; i++) {
			new Thread("thread-" + i){
				@Override
				public void run() {
					synchronized (lock){
						System.out.println("i am : " + Thread.currentThread().getName() + ",i get lock");
					}
				}
			}.start();
		}

		threadA.join();



	}



}
