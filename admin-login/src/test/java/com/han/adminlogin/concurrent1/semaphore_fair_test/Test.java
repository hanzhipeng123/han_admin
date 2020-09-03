package com.han.adminlogin.concurrent1.semaphore_fair_test;

import java.util.ArrayList;
import java.util.List;

/**
 *@author sunq
 *@date2019/11/13 18:29
 *@Description
 */
public class Test {


	public static void main(String[] args) {

		List<Short> orderType = new ArrayList<>();

		orderType.add((short)1);

		orderType.add((short)2);
		orderType.add((short)7);
		orderType.add((short)5);
		orderType.add((short)6);

//		if (orderType.contains((short)5)) {
//			System.out.println(1);
//		} else if (orderType.contains(6)) {
//			System.out.println(2);
//		} else {
//			System.out.println(3);
//		}


		Short num = 5000;

		if (num.equals(5000)){
			System.out.println(1);
		}else {
			System.out.println(2);
		}








	}


}
