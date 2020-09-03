package com.han.adminlogin.concurrent1.semaphore_consume_producer;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 *@author sunq
 *@date2019/11/21 14:36
 *@Description
 */
public class RepastService {

	volatile private Semaphore setSemaphore = new Semaphore(10);		// 厨师
	volatile private Semaphore getSemaphore = new Semaphore(20);		// 就餐者

	volatile private ReentrantLock lock = new ReentrantLock();
	volatile private Condition setCondition = lock.newCondition();
	volatile private Condition getCondition = lock.newCondition();

	// 定义 4 个盘子存放菜品
	volatile private Object[] producePosition = new Object[4];


	private boolean isEmpty(){
		boolean isEmpty = true;
		for (int i = 0; i < producePosition.length; i++) {
			if (producePosition[i] != null){
				isEmpty = false;
				break;
			}
		}

		if (isEmpty){
			return true;
		}else {
			return false;
		}
	}


	private boolean isFull(){
		boolean isFull = true;
		for (int i = 0; i < producePosition.length; i++) {
			if (producePosition[i] == null){
				isFull = false;
				break;
			}
		}
		return isFull;
	}

	public void set(){
		try {
			setSemaphore.acquire();			// 允许同时最多有 10个初始进行生产
			lock.lock();
			while (isFull()){
				System.out.println(" 生产者在等待 ");
				setCondition.await();
			}

			for (int i = 0; i < producePosition.length; i++) {

				if (producePosition[i] == null){
					producePosition[i] = "数据";
					System.out.println(Thread.currentThread().getName() + " 生产了 " + producePosition[i]);
					break;
				}
			}
			getCondition.signalAll();
			lock.unlock();

		}catch (InterruptedException e){
			e.printStackTrace();
		}finally {
			setSemaphore.release();
		}
	}

	public void get(){

		try {
			getSemaphore.acquire();

			lock.lock();
			while (isEmpty()){
				System.out.println(" 消费者在等待 ");
				getCondition.await();
			}
			for (int i = 0; i < producePosition.length; i++) {
				if (producePosition[i] != null){
					System.out.println(Thread.currentThread().getName() + " 消费了 " + producePosition[i]);
					producePosition[i] = null;
					break;
				}
			}

			setCondition.signalAll();
			lock.unlock();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			getSemaphore.release();
		}
	}






}
