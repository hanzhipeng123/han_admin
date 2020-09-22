package com.test;

import java.util.ArrayList;
import java.util.List;

/**
 *@author sunq
 *@date2020/9/14 11:21
 *@Description
 */
public class QuestionListTest {


	public static void main(String[] args) throws InterruptedException {

		Container con = new Container();

		Thread t1 = new Thread("t1"){
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					synchronized (con){
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						con.add(new Object());
					}
					System.out.println("t1 添加第" + i + "个元素完成。");
				}
			}
		};

		Thread t2 = new Thread("t2"){
			@Override
			public void run() {
				while (true){
					if (con.size() >= 5){
						System.out.println("容器数量大于5，结束！");
						break;
					}
					System.out.println("容器数量不大于5，继续监控");
				}
			}
		};


		t1.start();
		t2.start();

		t1.join();
		t2.join();




	}



	static class Container{
		List<Object> obj = new ArrayList<>();


		public void add(Object o){obj.add(o);}
		public int size(){return obj.size();}


	}


}
