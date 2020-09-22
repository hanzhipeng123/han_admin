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
public class TestBatchBasicLock {

	static Thread t1,t2;

	public static void main(String[] args) throws InterruptedException {




		List<CasLock> list = new LinkedList<>();
		List<CasLock> list2 = new LinkedList<>();


		System.out.println("t1 创建40个对象，对每个对象添加偏向锁===========");
		t1 = new Thread(){
			@Override
			public void run() {
				for (int i = 0; i < 40; i++) {
					CasLock lock = new CasLock();
					synchronized (lock){
						list.add(lock);
					}
					System.out.println("t1 添加完偏向锁后，对象的Mark word 中存的是：t1ID + 101");
					System.out.println( "t1-->>>--" + i + "-->>>--" + ClassLayout.parseInstance(lock).toPrintable());
				}

				list2.add(new CasLock());
				list2.add(new CasLock());
				list2.add(new CasLock());

				LockSupport.unpark(t2);
			}
		};



		t2 = new Thread(){
			@Override
			public void run() {
				LockSupport.park();
				System.out.println();
				System.out.println("=========分割线===========");
				System.out.println();
				System.out.println("t2 对前30个对象重新偏向===========");
				for (int i = 0; i < 30; i++) {
					CasLock lock = list.get(i);
					synchronized (lock){
					}
					System.out.println("t2 偏向锁后，升级到轻量锁，对象的Mark word 中存的是：0 + 001");
					System.out.println( "t2-->>>--" + i + "-->>>--" + ClassLayout.parseInstance(lock).toPrintable());
				}

				list2.add(new CasLock());
				list2.add(new CasLock());
				list2.add(new CasLock());
			}
		};



		t1.start();
		t2.start();

		t2.join();



		// t1 和 t2 都执行完后，看 list 中对象的偏向情况
		System.out.println();
		System.out.println("=========2分割线2====已经执行完t1 和 t2 的情况=======");
		System.out.println();


		for (int i = 0; i < list.size(); i++) {
			System.out.println( "res-->>>--" + i + "-->>>--" + ClassLayout.parseInstance(list.get(i)).toPrintable());
		}


		System.out.println();
		System.out.println("=========3分割线3====t1,t2两个线程执行完之后，每个线程创建五个对象，看看是怎么偏向的=======");
		System.out.println();

		for (int i = 0; i < list2.size(); i++) {
			System.out.println( "res2-->>>--" + i + "-->>>--" + ClassLayout.parseInstance(list2.get(i)).toPrintable());
		}


		/**
		 * t1 的 id：428251141
		 * t2 的 id：428253445
		 */






	}


}
