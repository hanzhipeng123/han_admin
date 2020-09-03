package com.han.adminlogin.concurrent1.semaphore_try_acquire2;

/**
 *@author sunq
 *@date2019/11/20 15:13
 *@Description
 */
public class TryAcquireRun2 {


	public static void main(String[] args) {

		TryAcquireTime tryAcquireTime = new TryAcquireTime();

		ThreadA2 a2 = new ThreadA2(tryAcquireTime);

		a2.setName("A2");
		a2.start();

		ThreadB2 b2 = new ThreadB2(tryAcquireTime);
		b2.setName("B2");
		b2.start();

	}

	/**
	 *
	 * 方法 tryAcquire(long timeout, TimeUnit unit) 的作用是在 单位为uint的 timeout 的时间内，尝试获取 1个许可，获取到返回true，获取不到则返回false
	 *
	 * 运行结果
	 * ThreadName=A2首次进入！
	 * ThreadName=B2未成功进入！
	 *
	 * 方法 tryAcquire(int permits, long timeout, TimeUnit unit) 的作用是在 单位为uint的 timeout 的时间内，尝试获取 x个许可，获取到返回true，获取不到则返回false
	 *
	 * 注：
	 * 当下面代码被注释时，
	 * //					String s = new String();
	 * //					Math.random();
	 * 结果为：
	 * 	双双获取许可
	 * ThreadName=A2首次进入！
	 * ThreadName=B2首次进入！
	 *
	 *
	 *
	 */
}
