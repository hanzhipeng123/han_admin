package com.han.adminlogin.sort;

/**
 *@author sunq
 *@date2020/7/30 14:49
 *@Description
 */
public class Person implements Comparable<Person>{

	int a = 10;

	public Person(String name, Integer age, Integer saleQty) {
		this.name = name;
		this.age = age;
		this.saleQty = saleQty;
	}

	public Person() {
	}

	private String name;

	private Integer age;

	private Integer saleQty;

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

	public Integer getSaleQty() {
		return saleQty;
	}

	public void setSaleQty(Integer saleQty) {
		this.saleQty = saleQty;
	}

	@Override
	public int compareTo(Person o) {

		// 比较近30天销量，降序排列
		if (this.saleQty > o.saleQty){
			return -1;
		}else if (this.saleQty < o.saleQty){
			return 1;
		}else {
			return 0;
		}
	}

	@Override
	public String toString() {
		return "Person{" + "name='" + name + '\'' + ", age=" + age + ", saleQty=" + saleQty + '}';
	}
}
