package com.han.adminlogin.sort;

import org.openjdk.jol.info.ClassLayout;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *@author sunq
 *@date2020/7/30 14:50
 *@Description
 */
public class TestMain {

	public static void main(String[] args) {


		List<Person> list = new ArrayList<>();

		list.add(new Person("张三", 18, 10));
		list.add(new Person("李四", 19, 67));
		list.add(new Person("王五", 20, 52));
		list.add(new Person("马六", 21, 1));
		list.add(new Person("田七", 22, 97));

		System.out.println("排序前：");
		list.forEach(p -> System.out.println(p));

		Collections.sort(list);
		System.out.println();

		System.out.println("排序后：");
		list.forEach(p -> System.out.println(p));


		Person p = new Person();
		//
		// 打印对象头信息
		System.out.println("对象的初始信息");
		System.out.println(ClassLayout.parseInstance(p).toPrintable() + "\n");


	}
}
