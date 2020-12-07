package com.socket.nio;


import com.sun.management.OperatingSystemMXBean;

import java.lang.management.ManagementFactory;
import java.nio.ByteBuffer;

/**
 *@author sunq
 *@date2020/10/29 14:23
 *@Description
 */
public class BufferAllocat {

	public static void main(String[] args) {

		OperatingSystemMXBean osmxb = (OperatingSystemMXBean)ManagementFactory.getOperatingSystemMXBean();

		System.out.println("--------Test allocate--------------");
		System.out.println("----直接内存分配前：" + osmxb.getFreePhysicalMemorySize());

		// 堆上分配
		ByteBuffer buffer = ByteBuffer.allocate(200000);
		System.out.println("buffer = " + buffer);
		System.out.println("【堆上分配】分配后：" + osmxb.getFreePhysicalMemorySize());

		// 直接内存分配
		ByteBuffer directBuffer = ByteBuffer.allocateDirect(200000);
		System.out.println("directBuffer = " + directBuffer);
		System.out.println("【直接内存】分配后：" + osmxb.getFreePhysicalMemorySize());

		System.out.println("---------Test end---");


	}



}
