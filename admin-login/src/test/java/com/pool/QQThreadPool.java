package com.pool;

import java.util.HashMap;
import java.util.HashSet;

/**
 *@author sunq
 *@date2020/9/24 15:35
 *@Description
 */
public class QQThreadPool {

	// 线程集合
	HashSet<QQNode> tSet;

	// 核心线程数
	int core;

	// 阻塞队列
	private QQQueue queue;


	// 初始化
	public QQThreadPool(int core){
		this.core = core;
		queue = new QQQueue(2);
		tSet = new HashSet<>();
	}


	// 提交任务
	public void submitTask(MyTask task){
		// 1、先看当前线程池中的核心线程数有没有达到上限
		if (tSet.size() < core){
			// 线程还没满，可以获取线程
			System.out.println("还有线程空闲，可以使用，直接 new 一个线程执行：" + task.getName());
			QQNode node = new QQNode(task, "t" + (tSet.size()), this);
			tSet.add(node);
			node.start();
		}else {
			// 没有空闲线程，task应该去排队
			System.out.println("没有空闲线程，" + task.getName() + " 应该去阻塞队列中！");
			queue.put(task);
		}

	}


	public QQQueue getQueue() {
		return queue;
	}

	public void removeNode(QQNode node){
		tSet.remove(node);
	}
}
