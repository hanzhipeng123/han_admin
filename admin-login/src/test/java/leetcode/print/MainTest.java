package leetcode.print;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *@author sunq
 *@date2021/1/27 16:41
 *@Description
 */
public class MainTest {

	public static void main(String[] args) throws InterruptedException {

		Foo foo = new Foo();

		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				foo.first();
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				foo.second();
			}
		});
		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				foo.third();
			}
		});
		ReentrantLock lock = new ReentrantLock();
		lock.lock();
		first(t1);
		lock.unlock();
		lock.lock();
		second(t2);
		lock.unlock();
		lock.lock();
		third(t3);
		lock.unlock();




	}

	public static void first(Runnable printFirst) throws InterruptedException {

		// printFirst.run() outputs "first". Do not change or remove this line.
		printFirst.run();
	}

	public static void second(Runnable printSecond) throws InterruptedException {

		// printSecond.run() outputs "second". Do not change or remove this line.
		printSecond.run();
	}

	public static void third(Runnable printThird) throws InterruptedException {

		// printThird.run() outputs "third". Do not change or remove this line.
		printThird.run();
	}
}
