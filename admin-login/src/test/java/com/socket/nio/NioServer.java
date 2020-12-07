package com.socket.nio;

/**
 *@author sunq
 *@date2020/10/29 15:55
 *@Description
 */
public class NioServer {

	private static NioServerHandle nioServerHandle;

	public static void main(String[] args) {

		nioServerHandle = new NioServerHandle(Const.DEFAULT_PORT);
		new Thread(nioServerHandle, "Server").start();


	}




}
