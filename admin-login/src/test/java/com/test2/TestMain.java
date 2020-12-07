package com.test2;

import org.apache.commons.lang.ArrayUtils;
import org.springframework.core.ResolvableType;

import java.util.concurrent.TimeUnit;

/**
 *@author sunq
 *@date2020/11/10 15:12
 *@Description
 */
public class TestMain {


	public static void main(String[] args) throws InterruptedException {


		TypeTest1 t1 = new TypeTest1();
		t1.test(new User());

		TypeTest2 t2 = new TypeTest2();

		TimeUnit.SECONDS.sleep(2);




//		ResolvableType resolvableType = ;
//		ResolvableType[] generics = resolvableType.getGenerics();
//		System.out.println(ResolvableType.forInstance(t1).getType());
		System.out.println(ResolvableType.forInstance(t1).getGeneric(0));
		System.out.println(ArrayUtils.toString(ResolvableType.forInstance(t1).getGenerics()));
		System.out.println(ResolvableType.forInstance(t2).getGeneric(0));
		System.out.println(ResolvableType.forInstance(t1).getInterfaces()[0].getType().getTypeName().contains("ClassTypeTest"));
		System.out.println(ResolvableType.forInstance(t1).getInterfaces()[1].getType().getTypeName().contains("ClassTypeTest"));


	}


}
