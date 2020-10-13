package com.pool;

import org.apache.commons.lang.time.DateUtils;

import java.util.concurrent.*;

/**
 *@author sunq
 *@date2020/9/24 14:08
 *@Description
 */
public class TestPool {


	public static void main(String[] args) {

		ExecutorService service = Executors.newCachedThreadPool();
		ExecutorService service1 = Executors.newFixedThreadPool(2);
		ExecutorService service2 = Executors.newSingleThreadExecutor();
		ExecutorService service3 = Executors.newScheduledThreadPool(2);


//		ThreadPoolExecutor executor = new ThreadPoolExecutor();

//		QQThreadPool pool = new QQThreadPool(2);
//
//		for (int i = 0; i < 5; i++) {
//			pool.submitTask(new MyTask("task- " + i));
//		}









		SynchronousQueue queue = new SynchronousQueue();

		new Thread(() -> {
			System.out.println("put aaa start...");
			try {
				queue.put("aaa");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("put aaa end...");

			System.out.println("put bbb start...");
			try {
				queue.put("bbb");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("put bbb end...");
		}).start();

		new Thread(() -> {
			System.out.println("poll start...");
			System.out.println();
			queue.poll();
			System.out.println("poll end...");
		}).start();





	}


}
