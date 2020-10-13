package com.pool;

/**
 *@author sunq
 *@date2020/9/24 15:36
 *@Description
 */
public class QQNode extends Thread {


	private MyTask task;
	private QQThreadPool qqThreadPool;
	private QQQueue queue;

	public QQNode(MyTask task, String tName, QQThreadPool qqThreadPool){

		setName(tName);
		this.task = task;
		this.qqThreadPool = qqThreadPool;
		this.queue = qqThreadPool.getQueue();
	}

	// 这里执行完了之后，不能直接结束
	// 1、任务是线程池给的
	// 2、任务是从阻塞队列中取的
	@Override
	public void run() {
		// 情况1 || 情况2
		while (task != null || (task = queue.poll()) != null){
			task.run();
			System.out.println("任务：" + task.getName() + "执行完毕，释放线程");
			task = null;
		}
		qqThreadPool.removeNode(this);
	}
}
