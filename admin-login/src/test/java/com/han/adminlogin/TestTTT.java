package com.han.adminlogin;

import org.apache.commons.lang.ArrayUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *@author sunq
 *@date2020/1/6 16:11
 *@Description
 */
public class TestTTT {

	public static void main(String[] args) {


			/*SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String[] dates = new String[14];
			Calendar calendar = Calendar.getInstance();
//			calendar.set(2020,0,11);

			calendar.add(Calendar.DAY_OF_YEAR, -7);

			while (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY) {
				calendar.add(Calendar.DAY_OF_WEEK, -1);
			}

			for (int i = 0; i < 14; i++) {
				dates[i] = dateFormat.format(calendar.getTime());
				calendar.add(Calendar.DATE, 1);
			}

		System.out.println(ArrayUtils.toString(dates));*/


		/*for (int i = 0; i < 10; ++i) {
			;
			System.out.println(i);
			System.out.println(i);
		}
*/



		int[] arr = {111, 222, 333, 444, 555};

		System.out.println("---start---");
		A: for (int i : arr) {
			for (int j = 0; j < 2; j++){
				if (i > 500){
					break A;
				}
				System.out.println("---doing---> " + i);
			}
			System.out.println("---doing---> " + i);
		}

		System.out.println("---end---");




		}



}



