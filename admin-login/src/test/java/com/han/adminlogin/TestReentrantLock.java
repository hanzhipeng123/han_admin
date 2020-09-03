package com.han.adminlogin;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 *@author sunq
 *@date2020/6/18 14:16
 *@Description
 */
public class TestReentrantLock {


	public static void main(String[] args) {

		ReentrantLock lock = new ReentrantLock();


		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {

				lock.lock();
				System.out.println("线程1 加锁后睡眠10s");
				try {
					TimeUnit.SECONDS.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("线程1 睡眠结束，解锁");
				lock.unlock();
			}
		});


		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("线程2 尝试获取锁");
				boolean tryLock = lock.tryLock();
//				System.out.println("线程2 获取到锁");
//				try {
//					TimeUnit.SECONDS.sleep(10);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
				int i = 1;
				do {
					System.out.println("线程2 未获取到锁，休眠一秒继续获取：" + i);
					try {
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					i++;
				}while (!lock.tryLock());

				System.out.println("线程2 获取到了锁！！！");



				lock.unlock();
				System.out.println("线程2 解锁");

			}
		});


		thread.start();
		thread2.start();
	}



}
