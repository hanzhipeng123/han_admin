package com.han.adminlogin.concurrent1.semaphore1;

import java.util.HashSet;
import java.util.Set;

/**
 *@author sunq
 *@date2019/11/13 14:52
 *@Description
 */
public class TestRun {


	public static void main(String[] args) {

		SemaphoreServiceTest1 serviceTest1 = new SemaphoreServiceTest1();

		// 分别创建 ABC三个线程，使用 SemaphoreServiceTest1中的方法，此时只有一个信号，所以三个线程是 顺序执行的
		ThreadA a = new ThreadA(serviceTest1);
		a.setName("Thread-AAAA");

		ThreadB b = new ThreadB(serviceTest1);
		b.setName("Thread-BBBB");

		ThreadC c = new ThreadC(serviceTest1);
		c.setName("Thread-CCCC");

		a.start();
		b.start();
		c.start();

		/**
		 * 运行结果：
		 * Thread-AAAA 开始时间：1573628535100
		 * Thread-AAAA 结束时间：1573628540138
		 * Thread-BBBB 开始时间：1573628540139
		 * Thread-BBBB 结束时间：1573628545140
		 * Thread-CCCC 开始时间：1573628545140
		 * Thread-CCCC 结束时间：1573628550229
		 */

//
//		Set<TestSet> set = new HashSet<>();
//		TestSet t1 = new TestSet();
//		TestSet t2 = new TestSet();
//		TestSet t3 = new TestSet();
//
//
//		set.add(t1);
//		set.add(t2);
//		set.add(t3);
//
//		set.forEach(v->{v.setValue1(1);v.setValue2(2);});

	}


}
