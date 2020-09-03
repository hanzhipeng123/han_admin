package com.han.adminlogin.concurrent1.semaphore_consume_producer;

/**
 *@author sunq
 *@date2019/11/22 15:18
 *@Description
 */
public class ThreadProducer extends Thread {


	private RepastService service;

	public ThreadProducer(RepastService service){
		super();
		this.service = service;
	}

	@Override
	public void run() {
		service.set();
	}
}
