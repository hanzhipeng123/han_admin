package com.aop;

import com.han.adminlogin.aop.AopTest;
import com.han.adminlogin.aop.ScanBean;
import com.han.adminlogin.aop.Student;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *@author sunq
 *@date2021/1/21 17:15
 *@Description
 */
public class TestAop {


	@Test
	public void test1(){

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScanBean.class);
		AopTest aopTest = context.getBean(AopTest.class);
		aopTest.test("Hello");
	}

	@Test
	public void test2(){

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScanBean.class);
		Student student = context.getBean(Student.class);
		System.out.println();
		System.out.println(student);
	}


}
