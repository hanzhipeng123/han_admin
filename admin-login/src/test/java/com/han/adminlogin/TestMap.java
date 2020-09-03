package com.han.adminlogin;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 *@author sunq
 *@date2020/6/15 13:34
 *@Description
 */
public class TestMap {

	public static void main(String[] args) {

		HashMap<String, String> hashMap= new HashMap<>();

		LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap();

		hashMap.put("a", "a");
		hashMap.put("b", "a");
		hashMap.put("c", "a");
		hashMap.put("d", "a");
		hashMap.put("e", "a");

		System.out.println("hashMap----start---->");
		for (String s : hashMap.keySet()) {
			System.out.println(s + "===>" + hashMap.get(s));
		}
		System.out.println("hashMap----end---->");


		linkedHashMap.put("a", "a");
		linkedHashMap.put("b", "a");
		linkedHashMap.put("e", "a");
		linkedHashMap.put("d", "a");
		linkedHashMap.put("c", "a");


		linkedHashMap.put("d","ddd");


		System.out.println("linkedHashMap----start---->");
		for (String s : linkedHashMap.keySet()) {
			System.out.println(s + "===>" + linkedHashMap.get(s));
		}
		System.out.println("linkedHashMap----end---->");

	}




}
