package com.han.adminlogin.concurrent1.semaphore_consume_producer;

/**
 *@author sunq
 *@date2019/11/22 15:20
 *@Description
 */
public class ProducerConsumerRun {

	public static void main(String[] args) throws InterruptedException {


		RepastService service = new RepastService();


		ThreadProducer[] producerArray = new ThreadProducer[60];
		ThreadConsumer[] consumerArray = new ThreadConsumer[60];

		for (int i = 0; i < 60; i++) {
			producerArray[i] = new ThreadProducer(service);
			consumerArray[i] = new ThreadConsumer(service);
		}
		Thread.sleep(2000);

		for (int i = 0; i < 60; i++) {
			producerArray[i].start();
			consumerArray[i].start();
		}



	}


	/**
	 * 部分结果如下：
	 * hread-49 消费了 数据
	 * Thread-45 消费了 数据
	 * Thread-62 生产了 数据
	 * Thread-54 生产了 数据
	 * Thread-34 生产了 数据
	 *  生产者在等待
	 *  生产者在等待
	 * Thread-31 消费了 数据
	 * Thread-30 生产了 数据
	 *  生产者在等待
	 * Thread-27 消费了 数据
	 * Thread-89 消费了 数据
	 * Thread-48 生产了 数据
	 * Thread-85 消费了 数据
	 * Thread-25 消费了 数据
	 * Thread-83 消费了 数据
	 *  消费者在等待
	 *  消费者在等待
	 *  消费者在等待
	 *  消费者在等待
	 *  消费者在等待
	 *  消费者在等待
	 *  消费者在等待
	 *  消费者在等待
	 *  消费者在等待
	 * Thread-40 生产了 数据
	 * Thread-36 生产了 数据
	 * Thread-38 生产了 数据
	 * Thread-100 生产了 数据
	 *  生产者在等待
	 *  生产者在等待
	 *  生产者在等待
	 *  生产者在等待
	 *  生产者在等待
	 * Thread-81 消费了 数据
	 * Thread-79 消费了 数据
	 * Thread-77 消费了 数据
	 * Thread-75 消费了 数据
	 *  消费者在等待
	 *  消费者在等待
	 *  消费者在等待
	 *  消费者在等待
	 *  消费者在等待
	 * Thread-98 生产了 数据
	 * Thread-52 生产了 数据
	 * Thread-32 生产了 数据
	 * Thread-28 生产了 数据
	 *  生产者在等待
	 * Thread-73 消费了 数据
	 * Thread-71 消费了 数据
	 *
	 *
	 *  类 Semaphore 提供了限制并发的线程数的功能，此功能在默认的 synchronized 中是不提供的
	 *
	 */
}
