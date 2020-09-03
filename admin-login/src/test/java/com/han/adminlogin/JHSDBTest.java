package com.han.adminlogin;

/**
 *@author sunq
 *@date2020/7/24 15:05
 *@Description VM 参数：-Xms30m -Xmx30m -Xss1m  -XX:+UseConcMarkSweepGC  -XX:-UseCompressedOops
 */
public class JHSDBTest {

	public final static String ROLE_CAT_TYPE = "CAT";
	public static String ROLE_MOUSE_TYPE = "mouse";

	public static void main(String[] args) throws InterruptedException {

		Role tom = new Role("tom", ROLE_CAT_TYPE, 10);

		// 进行15次垃圾回收
		for (int i = 0; i < 15; i++) {
			System.gc();
		}

		Role jerry = new Role();
		jerry.setName("jerry");
		jerry.setRoleType(ROLE_MOUSE_TYPE);
		jerry.setAge(2);

		Thread.sleep(Integer.MAX_VALUE);


	}


}

class Role{

	public Role(String name, String roleType, Integer age) {
		this.name = name;
		this.roleType = roleType;
		this.age = age;
	}

	public Role() {
	}

	private String name;

	private String roleType;

	private Integer age;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}
