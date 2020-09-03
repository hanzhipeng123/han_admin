package com.han.adminlogin;

import java.util.concurrent.*;

/**
 *@author sunq
 *@date2020/6/18 11:55
 *@Description
 */
public class TestCallable {


	public static void main(String[] args) throws ExecutionException, InterruptedException {


		ExecutorService pool = Executors.newFixedThreadPool(2);

//		Callable<String> c1 = new Callable() {
//			@Override
//			public String call() throws Exception {
//				return "线程1返回内容";
//			}
//		};
//
//		Callable<String> c2 = new Callable<String>() {
//			@Override
//			public String call() throws Exception {
//				return "线程2返回内容";
//			}
//		};
//
//
//		Future<String> f1 = pool.submit(c1);
//
//		System.out.println(f1.get());
//
//		Future<String> f2 = pool.submit(c2);
//		System.out.println(f2.get());
//
//		pool.shutdown();


		Future<String> f = pool.submit(new Callable<String>() {
			@Override
			public String call() throws Exception {
				return "线程执行完的返回值";
			}
		});

		pool.shutdown();

		System.out.println(f.get());


	}
}
