package com.test;

import com.mysql.cj.util.TimeUtil;
import lombok.extern.slf4j.Slf4j;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *@author sunq
 *@date2020/9/11 14:15
 *@Description
 */
public class TestLock {

	//
	public static void main(String[] args) throws InterruptedException {

		ReentrantLock lock = new ReentrantLock();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");


		Semaphore semaphore = new Semaphore(3);
		semaphore.acquire();

		CyclicBarrier cyclicBarrier = new CyclicBarrier(2);


/*
		Thread threadA = new Thread("threadA"){
			@Override
			public void run() {
					lock.lock();
					System.out.println("i got lock，sleep 5 second");
					try {
						TimeUnit.SECONDS.sleep(5);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("sleep end，release lock");
					lock.unlock();
			}
		};

		threadA.start();

		// 一秒后创建10个线程获取锁，并启动
		Thread.sleep(1000);

 		for (int i = 0; i < 10; i++) {
			new Thread("thread-" + i){
				@Override
				public void run() {
					lock.lock();
						System.out.println("i am : " + Thread.currentThread().getName() + ",i get lock");
					lock.unlock();
				}
			}.start();
		}

		threadA.join();*/


		/*Thread t1 = new Thread("t1"){
			@Override
			public void run() {
				lock.lock();
				System.out.println(format.format(new Date(System.currentTimeMillis())) + "：t1 has get lock, release after 5 s");
				try {
					TimeUnit.SECONDS.sleep(5);
				} catch (InterruptedException e) {
					System.out.println(format.format(new Date(System.currentTimeMillis())) + "：t1被打断");
					e.printStackTrace();
				}
				lock.unlock();
			}
		};

		lock.lock();
		t1.start();
		System.out.println(format.format(new Date(System.currentTimeMillis())) + "：main get lock, release after 2 s");
		TimeUnit.SECONDS.sleep(2);



		t1.interrupt();

		ReadWriteLock lock = new ReentrantReadWriteLock();
		Lock read = lock.readLock();
		Lock write = lock.writeLock();
		write.lock();
		read.lock();*/




	}



}
