package com.han.adminlogin.ThreadTest;

import org.apache.commons.lang.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

/**
 *@author sunq
 *@date2019/11/11 16:20
 *@Description
 */
public class TestNumber {

	public static void main(String[] args) {

		List<Integer> aa = new ArrayList<>();

		aa.add(1);
		aa.add(2);
		aa.add(3);
		aa.add(4);
		aa.add(5);
		aa.add(6);
		aa.add(7);

		int toIndex = 2;
//		for (int i = 0; i < aa.size(); i+=2) {
//			toIndex = i + 2 > aa.size() ? aa.size() : i + 2;
//			printList(aa.subList(i,toIndex));
//		}
		printList(aa.subList(0,2));
	}


	static void printList(List<Integer> aa){
		for (Integer i : aa) {
			System.out.println(i);
		}
	}





}




