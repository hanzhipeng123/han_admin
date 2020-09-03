package com.han.adminlogin.test_tools;

import java.util.LinkedList;
import java.util.List;

/**
 *@author sunq
 *@date2020/8/7 14:56
 *@Description
 *
 * -XX:+PrintGCDetails
 *
 *
 */
public class StopTheWorld {


	public static class FilledListThread extends Thread{
		List<byte[]> list = new LinkedList<>();

		@Override
		public void run() {

			try{
				while (true){
					if (list.size()*512/1024/1024>=990){
						list.clear();
						System.out.println("list is clear");
					}

					byte[] bl;
					for (int i = 0; i < 100; i++) {
						bl = new byte[512];
						list.add(bl);
					}

				}
			}catch (Exception e){

			}


		}
	}

	public static class TimerThread extends Thread{
		public static final long startTime = System.currentTimeMillis();

		// 100ms打印
		@Override
		public void run() {
			try {
				while (true){
					long t = System.currentTimeMillis() - startTime;
					Thread.sleep(100);
				}
			}catch (Exception e){

			}
		}
	}


	public static void main(String[] args) {
		// 填充对象线程 和 打印线程同时启动

		FilledListThread filledThread = new FilledListThread();
		TimerThread timerThread = new TimerThread();

		filledThread.start();
		timerThread.start();


	}



}
