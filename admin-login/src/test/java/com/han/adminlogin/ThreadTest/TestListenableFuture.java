package com.han.adminlogin.ThreadTest;

import com.google.common.util.concurrent.*;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *@author sunq
 *@date2019/11/9 11:47
 *@Description
 */
public class TestListenableFuture {

	final static ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newCachedThreadPool());


	public static void main(String[] args) throws InterruptedException, ExecutionException {


		Long t1 = System.currentTimeMillis();


		// 任务1
		ListenableFuture<Boolean> booleanFuture = service.submit(new Callable<Boolean>() {
			@Override
			public Boolean call() throws Exception {
				Thread.sleep(1000);
				return true;
			}
		});


		Futures.addCallback(booleanFuture, new FutureCallback<Boolean>() {
			@Override
			public void onSuccess(Boolean result) {
				System.out.println("BooleanTask：" + result);
			}

			@Override
			public void onFailure(Throwable throwable) {

			}
		});




		// 任务2
		ListenableFuture<String> stringFuture = service.submit(new Callable<String>() {
			@Override
			public String call() throws Exception {
				Thread.sleep(1000);
				return "Hello World";
			}
		});

		Futures.addCallback(stringFuture, new FutureCallback<String>() {
			@Override
			public void onSuccess(String result) {
				System.out.println("StringTask：" + result);
			}

			@Override
			public void onFailure(Throwable throwable) {

			}
		});




		// 任务3
		ListenableFuture<Integer> integerFuture = service.submit(new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				Thread.sleep(1000);
				return new Random().nextInt(100);
			}
		});


		Futures.addCallback(integerFuture, new FutureCallback<Integer>() {
			@Override
			public void onSuccess(Integer result) {
				System.out.println("IntegerTask：" + result);
			}

			@Override
			public void onFailure(Throwable throwable) {

			}
		});
		/*

		while (true){
			if (booleanFuture.isDone() && !booleanFuture.isCancelled() && stringFuture.isDone() && !stringFuture.isCancelled() && integerFuture.isDone() && !integerFuture.isCancelled()){

				// 模拟耗时
//				Thread.sleep(1500);
				Boolean booleanResult = booleanFuture.get();
				Integer integerResult = integerFuture.get();
				String stringResult = stringFuture.get();
				System.out.println("stringFuture: " + stringResult);
				System.out.println("booleanFuture: " + booleanResult);
				System.out.println("integerFuture: " + integerResult);

				break;

			}
		}*/





		System.out.println("执行时间：" + (System.currentTimeMillis() - t1));







	}



}
