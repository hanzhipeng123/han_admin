package com.han.adminlogin;

import lombok.extern.slf4j.Slf4j;
import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.TimeUnit;

/**
 *@author sunq
 *@date2020/9/2 18:27
 *@Description 测试对象 mark word 中的锁标识
 */

public class TestMarkWord {

	public static void main(String[] args) throws InterruptedException {

		// jvm 默认偏向延迟是4秒，这里sleep 5秒，等待开启偏向锁
		// 可以设置参数  -XX:BiasedLockingStartupDelay=0，关闭偏向延迟
		TimeUnit.SECONDS.sleep(5);

		Object object = new Object();


		// =========================================== 状态1：start ==========================
		/**
		 * 状态1： 101，无锁可偏向，线程id为0、偏向锁线程id不为0
		 */
//		System.out.println(ClassLayout.parseInstance(object).toPrintable());

		/**
		 * 控制台输出：
		 *  OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
		 *       0     4        (object header)                           05 00 00 00 (00000101 00000000 00000000 00000000) (5)
		 *       4     4        (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
		 *       8     4        (object header)                           e5 01 00 20 (11100101 00000001 00000000 00100000) (536871397)
		 *      12     4        (loss due to the next object alignment)
		 * Instance size: 16 bytes
		 * Space losses: 0 bytes internal + 4 bytes external = 4 bytes total
		 */


		// =========================================== 状态1：end ==========================




		// =========================================== 状态2：start ==========================
		/**
		 * 状态2： 001，无锁不可偏向，调用了hashcode方法
		 */
//		object.hashCode();
//		System.out.println(ClassLayout.parseInstance(object).toPrintable());

		/**
		 * OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
		 *       0     4        (object header)                           01 b1 ab 0b (00000001 10110001 10101011 00001011) (195801345)
		 *       4     4        (object header)                           7e 00 00 00 (01111110 00000000 00000000 00000000) (126)
		 *       8     4        (object header)                           e5 01 00 20 (11100101 00000001 00000000 00100000) (536871397)
		 *      12     4        (loss due to the next object alignment)
		 * Instance size: 16 bytes
		 * Space losses: 0 bytes internal + 4 bytes external = 4 bytes total
		 */


		// =========================================== 状态2：end ==========================


		// =========================================== 状态3：start ==========================
		/**
		 * 状态3： 000，轻量锁
		 *
		 *  ps：有的时候，锁标志位不会发生变化，原因暂未发现：可能是由于jvm在执行的时候觉得thread2执行的时候是线程安全的，内核创建线程的时候 可能用一个线程id，
		 *  大白话就是：就是两个线程在内核中的线程id是一个，所以jvm看来觉得还是一个线程，不会升级到轻量锁
		 *
		 */

		/*System.out.println("t1 加锁前的 mark word：\n" + ClassLayout.parseInstance(object).toPrintable());
		Thread t1 = new Thread() {
			@Override
			public void run() {
				synchronized (object) {
					System.out.println("t1 获取偏向锁成功！");
				}
			}
		};
		t1.start();

		System.out.println("t1 加锁后的 mark word：\n" + ClassLayout.parseInstance(object).toPrintable());

		Thread t2 = new Thread() {
			@Override
			public void run() {
				synchronized (object) {
					System.out.println("t2 加锁时的 mark word，升级到轻量锁");
					System.out.println(ClassLayout.parseInstance(object).toPrintable());
				}
			}
		};
		t2.start();
		t2.join();
		System.out.println("t2 加锁后的 mark word: \n" + ClassLayout.parseInstance(object).toPrintable());
*/
		/**
		 * 控制台输出：
		 * t1 加锁前的 mark word：
		 *  OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
		 *       0     4        (object header)                           05 00 00 00 (00000101 00000000 00000000 00000000) (5)
		 *       4     4        (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
		 *       8     4        (object header)                           e5 01 00 20 (11100101 00000001 00000000 00100000) (536871397)
		 *      12     4        (loss due to the next object alignment)
		 * Instance size: 16 bytes
		 * Space losses: 0 bytes internal + 4 bytes external = 4 bytes total
		 *
		 * t1 获取偏向锁成功！
		 * t1 加锁后的 mark word：
		 *  OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
		 *       0     4        (object header)                           05 a0 b1 18 (00000101 10100000 10110001 00011000) (414294021)
		 *       4     4        (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
		 *       8     4        (object header)                           e5 01 00 20 (11100101 00000001 00000000 00100000) (536871397)
		 *      12     4        (loss due to the next object alignment)
		 * Instance size: 16 bytes
		 * Space losses: 0 bytes internal + 4 bytes external = 4 bytes total
		 *
		 * t2 加锁时的 mark word，升级到轻量锁
		 *  OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
		 *       0     4        (object header)                           60 f3 41 1a (01100000 11110011 01000001 00011010) (440529760)
		 *       4     4        (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
		 *       8     4        (object header)                           e5 01 00 20 (11100101 00000001 00000000 00100000) (536871397)
		 *      12     4        (loss due to the next object alignment)
		 * Instance size: 16 bytes
		 * Space losses: 0 bytes internal + 4 bytes external = 4 bytes total
		 *
		 * t2 加锁后的 mark word:
		 *  OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
		 *       0     4        (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
		 *       4     4        (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
		 *       8     4        (object header)                           e5 01 00 20 (11100101 00000001 00000000 00100000) (536871397)
		 *      12     4        (loss due to the next object alignment)
		 * Instance size: 16 bytes
		 * Space losses: 0 bytes internal + 4 bytes external = 4 bytes total
		 */


		// =========================================== 状态3：end ==========================



		// =========================================== 状态4：start ==========================
		/**
		 * 状态4： 010，重量锁量锁
		 */


		Thread t1 = new Thread() {
			@Override
			public void run() {
				System.out.println("t1 加锁前的 mark word：\n" + ClassLayout.parseInstance(object).toPrintable());
				synchronized (object) {
					System.out.println("t1 加锁后的 mark word：\n" + ClassLayout.parseInstance(object).toPrintable());
					try {
						// 线程睡眠 6秒，让 t2 去竞争
						TimeUnit.SECONDS.sleep(6);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};

		Thread t2 = new Thread() {
			@Override
			public void run() {
				System.out.println("t2 加锁前的 mark word: \n" + ClassLayout.parseInstance(object).toPrintable());
				synchronized (object) {
					try {
						TimeUnit.SECONDS.sleep(3);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("t2 加锁后的 mark word，膨胀到重量锁");
					System.out.println(ClassLayout.parseInstance(object).toPrintable());
				}
			}
		};
		t1.start();

		Thread.sleep(100);

		t2.start();
		t2.join();


		Thread t3 = new Thread() {
			@Override
			public void run() {
				System.out.println("t3 加锁前的 mark word: \n" + ClassLayout.parseInstance(object).toPrintable());
				synchronized (object) {
					try {
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("t3 加锁后的 mark word，");
					System.out.println(ClassLayout.parseInstance(object).toPrintable());
				}
			}
		};
		t3.start();
		t3.join();

		/**
		 * 控制台输出：
		 *t1 加锁前的 mark word：默认是匿名偏向锁（偏向线程的id 为0）
		 *  OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
		 *       0     4        (object header)                           05 00 00 00 (00000101 00000000 00000000 00000000) (5)
		 *       4     4        (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
		 *       8     4        (object header)                           e5 01 00 20 (11100101 00000001 00000000 00100000) (536871397)
		 *      12     4        (loss due to the next object alignment)
		 * Instance size: 16 bytes
		 * Space losses: 0 bytes internal + 4 bytes external = 4 bytes total
		 *
		 * t1 加锁后的 mark word：指向 t1 的线程id
		 *  OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
		 *       0     4        (object header)                           05 50 28 19 (00000101 01010000 00101000 00011001) (422072325)
		 *       4     4        (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
		 *       8     4        (object header)                           e5 01 00 20 (11100101 00000001 00000000 00100000) (536871397)
		 *      12     4        (loss due to the next object alignment)
		 * Instance size: 16 bytes
		 * Space losses: 0 bytes internal + 4 bytes external = 4 bytes total
		 *
		 * t2 加锁前的 mark word：线程id还是指向到 t1的线程id
		 *  OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
		 *       0     4        (object header)                           05 50 28 19 (00000101 01010000 00101000 00011001) (422072325)
		 *       4     4        (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
		 *       8     4        (object header)                           e5 01 00 20 (11100101 00000001 00000000 00100000) (536871397)
		 *      12     4        (loss due to the next object alignment)
		 * Instance size: 16 bytes
		 * Space losses: 0 bytes internal + 4 bytes external = 4 bytes total
		 *
		 * t2 加锁后的 mark word，膨胀到重量锁，重量锁执行完成不会释放，锁标识还是重量锁，后面再来加锁会怎么样
		 *  OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
		 *       0     4        (object header)                           ea cd 8d 17 (11101010 11001101 10001101 00010111) (395169258)
		 *       4     4        (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
		 *       8     4        (object header)                           e5 01 00 20 (11100101 00000001 00000000 00100000) (536871397)
		 *      12     4        (loss due to the next object alignment)
		 * Instance size: 16 bytes
		 * Space losses: 0 bytes internal + 4 bytes external = 4 bytes total
		 */


		// =========================================== 状态4：end ==========================






















	}


}
