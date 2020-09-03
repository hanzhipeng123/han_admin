package com.han.adminlogin.ThreadTest;

import java.util.Random;
import java.util.concurrent.*;

/**
 *@author sunq
 *@date2019/11/9 11:33
 *@Description
 */
public class TestFuture {

	final static ExecutorService service = Executors.newCachedThreadPool();


	public static void main(String[] args) throws InterruptedException, ExecutionException {

		Long t1 = System.currentTimeMillis();


		// 任务1
		Future<Boolean> booleanFuture = service.submit(new Callable<Boolean>() {
			@Override
			public Boolean call() throws Exception {
				return true;
			}
		});





		// 任务2
		Future<String> stringFuture = service.submit(new Callable<String>() {
			@Override
			public String call() throws Exception {
				return "Hello World";
			}
		});




		// 任务3
		Future<Integer> integerFuture = service.submit(new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				return new Random().nextInt(100);
			}
		});

		while (true){
			if (booleanFuture.isDone() && !booleanFuture.isCancelled()){

				// 模拟耗时

				Thread.sleep(1500);
				Boolean result = booleanFuture.get();

				System.out.println("booleanFuture: " + result);
				break;

			}
		}

		while (true){
			if (stringFuture.isDone() && !stringFuture.isCancelled()){
				// 模拟耗时
				Thread.sleep(1500);
				String result = stringFuture.get();
				System.out.println("stringFuture: " + result);
				break;

			}
		}

		while (true){
			if (integerFuture.isDone() && !integerFuture.isCancelled()){
				// 模拟耗时
				Thread.sleep(1500);
				Integer result = integerFuture.get();
				System.out.println("integerFuture: " + result);
				break;
			}
		}

		System.out.println("执行时间：" + (System.currentTimeMillis() - t1));






	}







}
