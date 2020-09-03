package com.han.adminlogin;

import java.util.Vector;

/**
 *@author sunq
 *@date2020/6/15 16:52
 *@Description
 */
public  class TestStart {



	public static void main(String[] args) {

		System.out.println("main--start");

		new Thread(){
			@Override
			public void run() {
				System.out.println("sub_thread-run");
			}
		}.start();

		new Thread(){
			@Override
			public void run() {
				System.out.println("sub_thread-run");
			}
		}.start();


		System.out.println("main--end");


	}


	public void testSyncObj(){

		Vector<String> stringVector = new Vector<>();

		synchronized(this){
			for (int i = 0; i < 100; i++) {
				stringVector.add("aaa" + i);
			}
		}
	}

	public void testSyncMethod(){

		Vector<String> stringVector = new Vector<>();
			for (int i = 0; i < 100; i++) {
				synchronized(this){
					stringVector.add("aaa" + i);
				}
			}

	}


}
