package com.han.adminlogin;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *@author sunq
 *@date2020/7/30 10:47
 *@Description
 */
public class ArrayTest {

	public static void main(String[] args) {
		System.out.println(1);
	}


	private int getValue(){

		int[] arr = {111, 222, 333, 444};

		return arr[8];
	}


	private int getLength(){
		int[] arr = {111, 222, 333, 444};

		return arr.length;
	}

	private void arrayForEach(){
		int[] arr = {111, 222, 333, 444};

		for (int i : arr) {
			System.out.println(i);
		}
	}


	private void listForEach(){

		List<Integer> list = new ArrayList<>();
		list.add(111);
		list.add(333);
		list.add(555);
		list.add(666);

		for (Integer i : list) {
			System.out.println(i);
		}

		List<Integer> list2 = new LinkedList<>();
		list.add(777);
		list.add(222);
		list.add(444);
		list.add(999);


		for (Integer i : list2) {
			System.out.println(i);
		}

	}




}
