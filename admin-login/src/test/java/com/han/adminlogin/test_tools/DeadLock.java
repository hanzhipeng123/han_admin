package com.han.adminlogin.test_tools;

/**
 *@author sunq
 *@date2020/8/7 15:18
 *@Description
 */
public class DeadLock {

	public static final Integer num13 = 13;
	public static final Integer num14 = 14;


	public static void main(String[] args) {

		Thread t1 = new Thread(){
			@Override
			public void run() {
				synchronized (num13){
					System.out.println("t1 has got [num13]");
					try{
						Thread.sleep(1000);
					}catch (Exception e){
					}
					synchronized (num14){
						System.out.println("t1 has got [num14]");
					}
				}
			}
		};


		Thread t2 = new Thread(){
			@Override
			public void run() {
				synchronized (num14){
					System.out.println("t2 has got [num14]");
					try{
						Thread.sleep(1000);
					}catch (Exception e){
					}
					synchronized (num13){
						System.out.println("t2 has got [num13]");
					}
				}
			}
		};


		t1.start();
		t2.start();




	}


}
