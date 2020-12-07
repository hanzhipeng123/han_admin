package com.test2;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *@author sunq
 *@date2020/11/10 15:11
 *@Description
 */
public class TypeTest1 implements ClassType2,ClassTypeTest<User>{

	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public void test(User u) {
		System.out.println("uuuuuuu");
	}
}
