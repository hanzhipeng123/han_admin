package com.han.adminlogin.test;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.TypeVariable;
import java.util.HashMap;

/**
 *@author sunq
 *@date2020/1/14 16:19
 *@Description
 */
public class TestType {


	SubClassA <Long> sa = new SubClassA<>();


	public static void main(String[] args) throws Exception {

		Field f = ClassA.class.getDeclaredField("map");

		System.out.println(f.getGenericType());
		System.out.println(f.getGenericType() instanceof ParameterizedType);
		System.out.println(f.getGenericType() instanceof TypeVariable);

//		HashMap





	}




}
