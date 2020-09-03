package com.han.adminlogin;

/**
 *@author sunq
 *@date2020/6/11 16:40
 *@Description
 */
public class TestStatic {

	private static int a = 10;


	static{
		System.out.println(a);
		// 不合法的超前引用  illegal forward reference
//		System.out.println(b);

	}


	private static int b = 20;

	static{
		System.out.println(a);
		System.out.println(b);
	}
}
