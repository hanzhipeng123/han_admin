package com.test;

import org.openjdk.jol.info.ClassLayout;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.LockSupport;

/**
 *@author sunq
 *@date2020/9/9 16:28
 *@Description 测试重新批量偏向
 */
public class TestWaitHaveryLock {

	static Thread t1,t2;

	public static void main(String[] args) throws InterruptedException {

		CasLock lock = new CasLock();

		new Thread(){
			@Override
			public void run() {
				System.out.println( "加锁前的 mark word -->>>-- " + ClassLayout.parseInstance(lock).toPrintable());
				synchronized (lock){
					// 没开偏向延迟，所以是轻量锁
					System.out.println( "加锁中的 mark word -->>>-- " + ClassLayout.parseInstance(lock).toPrintable());
					try {
						lock.wait(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println( "加锁后的 mark word -->>>-- " + ClassLayout.parseInstance(lock).toPrintable());
			}
		}.start();






	}


}
