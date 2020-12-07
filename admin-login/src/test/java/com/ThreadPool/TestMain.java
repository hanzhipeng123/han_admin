package com.ThreadPool;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 *@author sunq
 *@date2020/9/27 14:07
 *@Description
 */
public class TestMain {


	public static void main(String[] args) {

		/*Integer a = 1;
		EnumTest b = EnumTest.A;

		switch (b){
			case A:
				System.out.println(EnumTest.A.getName());
				break;
			case B:
				System.out.println(EnumTest.A.getName());
				break;
			default:
				System.out.println("啊啊啊");
				break;
		}*/


		// 获取现在的时间
//		Date todayStaticsTime = new Date(System.currentTimeMillis());
		Date todayStaticsTime = new Date("2020/09/02 17:22:15");
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(todayStaticsTime.getTime());

		// 定时任务跑的是前一天的数据，天数减 1
		calendar.add(Calendar.DATE, -1);
		// 最终的统计日期
		todayStaticsTime = calendar.getTime();

		// 判断是否是当月的第一天
		if (calendar.get(Calendar.DAY_OF_MONTH) == 1){
			// 当月第一天
			System.out.println("是第一天");
		}else {
			System.out.println("不是第一天");
		}
		calendar.setTimeInMillis(todayStaticsTime.getTime());
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);

		System.out.println("日期：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime()));

//		ScheduledExecutorService executorService = Executors.newScheduledThreadPool();


//		executorService.scheduleAtFixedRate();
//
//		executorService.scheduleWithFixedDelay();


	}


}
