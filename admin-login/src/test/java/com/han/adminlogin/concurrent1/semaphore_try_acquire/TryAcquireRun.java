package com.han.adminlogin.concurrent1.semaphore_try_acquire;

/**
 *@author sunq
 *@date2019/11/20 15:13
 *@Description
 */
public class TryAcquireRun {


	public static void main(String[] args) {

		TryAcquireService service = new TryAcquireService();

		ThreadA a = new ThreadA(service);

		a.setName("A");
		a.start();

		ThreadB b = new ThreadB(service);
		b.setName("B");
		b.start();

	}

	/**
	 *
	 * 无参方法 tryAcquire() 的作用是尝试获取 1个许可，获取到返回true，获取不到则返回false
	 *
	 * 运行结果
	 * ThreadName=A首次进入！
	 * ThreadName=B未成功进入！
	 *
	 * 有参方法 tryAcquire(int permits) 的作用是 尝试地获取 x个许可，获取到就返回true，获取不到就返回false
	 *
	 *
	 */
}
