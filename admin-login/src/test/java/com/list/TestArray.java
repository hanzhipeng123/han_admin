package com.list;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *@author sunq
 *@date2021/2/22 10:49
 *@Description
 */
public class TestArray implements Runnable {


//	private static List<String> list = new ArrayList<>();
	private static List<String> list2 = Collections.synchronizedList(new ArrayList<>());

	public static void main(String[] args) throws InterruptedException {

		Set<Integer> set = new HashSet();
		set.add(1);

		ReentrantLock lock = new ReentrantLock();
		lock.lock();

		System.out.println(list2.size());

		TestArray r = new TestArray();
		for (int i = 0; i < 100; i++) {
			Thread t = new Thread(r, String.valueOf(i));
			t.start();
		}

		Thread.sleep(2000);

		System.out.println("size：" + r.list2.size());

		System.out.println("----------------------------");
		for (String s : r.list2) {
			System.out.print(" ," + s);
		}







	}


	@Override
	public void run() {
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		list2.add(Thread.currentThread().getName());
	}



	public void test(){


		synchronized(this) {

			System.out.println("a");

			synchronized (this){

			}

		}


	}
}
