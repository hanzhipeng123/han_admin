package com.han.adminlogin;

import com.alibaba.fastjson.JSON;
import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.TimeUnit;

/**
 *@author sunq
 *@date2020/6/17 18:09
 *@Description
 */
public class TestIntial {

	public static void main(String[] args) throws InterruptedException {

		TimeUnit.SECONDS.sleep(5);

		Object object = new Object();
//
		 // 打印对象头信息
		System.out.println("对象的初始信息");
		System.out.println(ClassLayout.parseInstance(object).toPrintable() + "\n");


		/**
		 *  step 1 偏向锁
		 */
		//		synchronized (object) {
//			System.out.println("1\n" + ClassLayout.parseInstance(object).toPrintable());
//		}
//		TimeUnit.SECONDS.sleep(1);
//		System.out.println("2\n" + ClassLayout.parseInstance(object).toPrintable());



		/**
		 *  step 2
		 *  如果 thread2执行的时候，出现了锁竞争，此时偏向锁膨胀为轻量锁
		 *  对象头中的锁标志位变化：101（偏向锁）-->000（轻量锁）-->（001无锁状态）
		 *
		 *  ps：有的时候，锁标志位不会发生变化，原因暂未发现：可能是由于jvm在执行的时候觉得thread2执行的时候是线程安全的，内核创建线程的时候 可能用一个线程id
		 */

//		System.out.println("获取当前主线程id：" + Thread.currentThread().getId());

		Thread thread1 = new Thread() {
			@Override
			public void run() {

				synchronized (object) {
					System.out.println("thread1 获取偏向锁成功");
//					System.out.println("线程1是否获取到对象锁：" + Thread.holdsLock(object));
					System.out.println(ClassLayout.parseInstance(object).toPrintable());
				}
			}
		};

//		System.out.println("线程1：" + JSON.toJSON(thread1));

		Thread thread2 = new Thread() {
			@Override
			public void run() {

				synchronized (object) {
					System.out.println("thread2 获取偏向锁失败，升级为轻量级锁，获取轻量级锁成功");
//					System.out.println("线程2是否获取到对象锁：" + Thread.holdsLock(object));
					System.out.println(ClassLayout.parseInstance(object).toPrintable());

				}
			}
		};
//		System.out.println("线程2：" + JSON.toJSON(thread2));

		thread1.start();



//		System.out.println("线程1是否还活着：" + thread1.isAlive());
		//让thread1死亡
		thread1.join();
		System.out.println("线程1是否还活着：" + thread1.isAlive());
		System.out.println("thread1 死亡后不释放偏向锁");
		System.out.println(ClassLayout.parseInstance(object).toPrintable());



		thread2.start();

		//thread2死亡
		thread2.join();
		System.out.println("thread2执行结束，释放轻量级锁");
		System.out.println(ClassLayout.parseInstance(object).toPrintable());


//
//		Thread thread1 = new Thread() {
//			@Override
//			public void run() {
//				synchronized (object) {
//					System.out.println("thread1 获得偏向锁");
//					System.out.println(ClassLayout.parseInstance(object).toPrintable());
//					try {
//						//让线程晚点儿死亡，造成锁的竞争
//						TimeUnit.SECONDS.sleep(6);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//					System.out.println("thread2 获取锁失败导致锁升级,此时thread1还在执行");
//					System.out.println(ClassLayout.parseInstance(object).toPrintable());
//				}
//			}
//		};
//		Thread thread2 = new Thread() {
//			@Override
//			public void run() {
//				synchronized (object) {
//					System.out.println("thread2 获取偏向锁失败，最终升级为重量级锁，等待thread1执行完毕，获取重量锁成功");
//					System.out.println(ClassLayout.parseInstance(object).toPrintable());
//					try {
//						TimeUnit.SECONDS.sleep(3);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
//			}
//		};
//		thread1.start();
//		//对象头打印需要时间,先让thread1获取偏向锁
//		TimeUnit.SECONDS.sleep(5);
//		thread2.start();
//


























	}

}
