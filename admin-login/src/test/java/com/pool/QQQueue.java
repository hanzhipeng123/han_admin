package com.pool;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *@author sunq
 *@date2020/9/24 15:44
 *@Description
 */
public class QQQueue {

	private int queueSize;

	// 线程不能执行，双向队列
	Deque<MyTask> deque = new ArrayDeque();

	Lock lock = new ReentrantLock();
	// 队列已经满了，阻塞
	Condition busyQueue = lock.newCondition();
	// 队列为空，线程阻塞，不结束
	Condition emptyQueue = lock.newCondition();


	public QQQueue(int queueSize) {
		this.queueSize = queueSize;
	}

	public void put(MyTask task){

		lock.lock();
		try {
			// 1、判断队列是否达到上限
			while (deque.size() == queueSize){
				// 队列已经满了，不能加入
				System.out.println("执行 put 操作，队列已经满了，不能加入！需要排队：" + task.getName());
				try {
					busyQueue.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			System.out.println("队列可以存放：" + task.getName());
			// 可以存放
			deque.addLast(task);
			emptyQueue.signal();
		}finally {
			lock.unlock();
		}

	}


	public MyTask poll(){
		System.out.println("poll 一个 task");
		// 先判断队列中有没有 task
		lock.lock();
		MyTask task = null;
		try {
			while (deque.isEmpty()){
				// 阻塞操作队列是空的
				System.out.println("阻塞队列中没有线程，所有任务都执行完了。");
				emptyQueue.await();
			}
			task = deque.removeFirst();
			System.out.println("能够获取一个正常的 task：" + task.getName());
			busyQueue.signal();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}

		return task;

	}



}
