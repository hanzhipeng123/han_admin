package com.han.adminlogin;

import java.util.Random;
import java.util.Vector;

/**
 *@author sunq
 *@date2020/6/15 11:40
 *@Description
 */
public class TestVector {

	public static void main(String[] args){
		Vector<Long> vector = new Vector<>();
		new Thread(() -> {
			for (int i = 0; i < 100; i++) {
				long l = new Random().nextLong();
				vector.add(l);
				vector.indexOf(l);
				vector.remove(vector.indexOf(l));
			}
		}).start();
		new Thread(() -> {
			for (int i = 0; i < 100; i++) {
				long l = new Random().nextLong();
				vector.add(l);
				vector.indexOf(l);
				vector.remove(vector.indexOf(l));
			}
		}).start();
	}

}
