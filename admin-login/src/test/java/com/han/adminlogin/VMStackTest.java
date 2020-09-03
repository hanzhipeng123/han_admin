package com.han.adminlogin;

/**
 *@author sunq
 *@date2020/7/24 16:16
 *@Description
 */
public class VMStackTest {


	public int work(int x) throws InterruptedException {
		int z = (x + 5) * 10;
//		Thread.sleep(Integer.MAX_VALUE);
		return z;
	}

	public Person personWork(Person p, Person2 p2) throws InterruptedException {
		p.setName("李四");
		p.setAge(20);
		Thread.sleep(Integer.MAX_VALUE);
		return p;
	}


	public static void main(String[] args) throws InterruptedException {

		VMStackTest vm = new VMStackTest();

		vm.work(10);
		Person p = new Person();
		p.setName("张三");
		p.setAge(18);

		Person2 p2 = new Person2();
		p.setName("马六");
		p.setAge(20);
		vm.personWork(p, p2);



	}


}


class Person{

	private String name;


	private Integer age;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}


}


class Person2 {

	private String name2;


	private Integer age2;


	public String getName2() {
		return name2;
	}

	public void setName2(String name2) {
		this.name2 = name2;
	}

	public Integer getAge2() {
		return age2;
	}

	public void setAge2(Integer age2) {
		this.age2 = age2;
	}

}
