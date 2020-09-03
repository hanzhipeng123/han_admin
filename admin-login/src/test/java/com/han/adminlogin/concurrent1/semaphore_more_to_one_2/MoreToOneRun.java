package com.han.adminlogin.concurrent1.semaphore_more_to_one_2;

/**
 *@author sunq
 *@date2019/11/20 16:28
 *@Description 多路进，单处理，多路出
 */
public class MoreToOneRun {

	public static void main(String[] args) {

		MoreToOneService service = new MoreToOneService();

		MyThread[] threads = new MyThread[5];

		for (int i = 0; i < threads.length; i++) {
			threads[i] = new MyThread(service);
			threads[i].start();
		}

	}


	/**
	 *
	 *
	 * 运行结果：
	 * 每一块都是有序的。
	 *
	 * ThreadName = Thread-0 准备
	 * ThreadName = Thread-1 准备
	 * ThreadName = Thread-2 准备
	 * begin hello 2019-11-20 16:43:20
	 * Thread-0 打印 1
	 * Thread-0 打印 2
	 * Thread-0 打印 3
	 * Thread-0 打印 4
	 * Thread-0 打印 5
	 * end hello 2019-11-20 16:43:21
	 * ThreadName = Thread-3 准备
	 * ThreadName = Thread-0 结束
	 * begin hello 2019-11-20 16:43:21
	 * Thread-1 打印 1
	 * Thread-1 打印 2
	 * Thread-1 打印 3
	 * Thread-1 打印 4
	 * Thread-1 打印 5
	 * end hello 2019-11-20 16:43:21
	 * ThreadName = Thread-1 结束
	 * begin hello 2019-11-20 16:43:21
	 * Thread-2 打印 1
	 * Thread-2 打印 2
	 * Thread-2 打印 3
	 * Thread-2 打印 4
	 * Thread-2 打印 5
	 * end hello 2019-11-20 16:43:21
	 * ThreadName = Thread-2 结束
	 * ThreadName = Thread-4 准备
	 * begin hello 2019-11-20 16:43:21
	 * Thread-3 打印 1
	 * Thread-3 打印 2
	 * Thread-3 打印 3
	 * Thread-3 打印 4
	 * Thread-3 打印 5
	 * end hello 2019-11-20 16:43:21
	 * ThreadName = Thread-3 结束
	 * begin hello 2019-11-20 16:43:21
	 * Thread-4 打印 1
	 * Thread-4 打印 2
	 * Thread-4 打印 3
	 * Thread-4 打印 4
	 * Thread-4 打印 5
	 * end hello 2019-11-20 16:43:21
	 * ThreadName = Thread-4 结束
	 *
	 */


}
