package com.socket.nio;

import org.apache.commons.lang.ArrayUtils;

import java.nio.ByteBuffer;

/**
 *@author sunq
 *@date2020/10/29 14:43
 *@Description Buffer 实际就是一个数组，可以往数组里面 put，也可以get，可以前后移动，转换模式
 * 核心属性：【读模式】pos：当前位置、lim：最大可读的位置、 cap：总容量
 * 			 【写模式】pos：下一个可写位置、lim：等于cap、 cap：总容量
 */
public class BufferMethod {

	public static void main(String[] args) {

		System.out.println("-------Test buffer method ------");
		ByteBuffer buffer = ByteBuffer.allocate(32);
		buffer.put((byte) 'a')
				.put((byte) 'b')
				.put((byte) 'c')
				.put((byte) 'd')
				.put((byte) 'e')
				.put((byte) 'f')
				.put((byte) 'g')
				.put((byte) 'h');
		System.out.println("写模式：" + buffer);
		// 转换 读/写 模式
		// limit = position; position = 0;
		buffer.flip();
		System.out.println("读模式：" + buffer);

		// 一个一个获取
		System.out.println("读之前：" + buffer);
		System.out.println("从 position 读取了一个元素：" + (char)buffer.get());
		System.out.println("读之后：" + buffer);

		// 批量读取
		byte[] dst = new byte[10];
		buffer.get(dst, 1, 2);
//		buffer.get(dst);
//		System.out.println("读取所有：" + ArrayUtils.toString(dst));
		System.out.println("读取部分：" + ArrayUtils.toString(dst));

		/*System.out.println("-------------------------------------------------");
		ByteBuffer buff = ByteBuffer.allocate(16);
		buff.put((byte)'a');
		buff.put((byte)'b');
		System.out.println(buff);
		buff.flip();
		System.out.println((char) buff.get());
		System.out.println(buff);
		buff.flip();
		System.out.println(buff);
		buff.put((byte)'c');
		buff.flip();
		while (buff.hasRemaining()){
			System.out.println((char) buff.get());
		}
		System.out.println(buff);
*/


	}









}
