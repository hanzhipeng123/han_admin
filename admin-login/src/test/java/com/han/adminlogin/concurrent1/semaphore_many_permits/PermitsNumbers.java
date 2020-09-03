package com.han.adminlogin.concurrent1.semaphore_many_permits;

import java.util.concurrent.Semaphore;

/**
 *@author sunq
 *@date2019/11/13 16:42
 *@Description 测试 availablePermits() 和 drainPermits() 方法
 */
public class PermitsNumbers {

	public static void main(String[] args) {

		TestPermitNumbers testPermitNumbers = new TestPermitNumbers();


		// availablePermits
		testPermitNumbers.testMethod1();

		// drainPermits
		testPermitNumbers.testMethod2();

		/**
		 * 执行结果：
		 * availablePermits：9
		 * availablePermits：9<--------------->drainPermits 9
		 * availablePermits：0<--------------->drainPermits 0
		 *
		 * availablePermits() 的作用是 返回可用的许可个数
		 * drainPermits() 的作用是 返回可用的许可个数，并且将许可 可用个数清零
		 *
		 *
		 */

	}



	public static class TestPermitNumbers{

		private Semaphore semaphore = new Semaphore(10);


		public void testMethod1(){

			try {
				semaphore.acquire();

				System.out.println("availablePermits：" + semaphore.availablePermits());

			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally {
				semaphore.release();
			}


		}


		public void testMethod2(){

			try {
				semaphore.acquire();

				System.out.println("availablePermits：" + semaphore.availablePermits() + "<--------------->drainPermits " + semaphore.drainPermits());
				System.out.println("availablePermits：" + semaphore.availablePermits() + "<--------------->drainPermits " + semaphore.drainPermits());



			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally {
				semaphore.release();
			}


		}


	}

}
