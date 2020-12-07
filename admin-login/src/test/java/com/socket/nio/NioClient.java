package com.socket.nio;

import java.io.IOException;
import java.util.Scanner;

/**
 *@author sunq
 *@date2020/10/29 15:55
 *@Description
 */
public class NioClient {

	private static NioClientHandle nioClientHandle;

	public static void start(){
		nioClientHandle = new NioClientHandle(Const.DEFAULT_SERVER_IP, Const.DEFAULT_PORT);
		new Thread(nioClientHandle, "client").start();
	}

	public static boolean send(String msg) throws IOException {
		nioClientHandle.sendMessage(msg);
		return true;
	}




	public static void main(String[] args) throws IOException {

		start();
		Scanner scanner = new Scanner(System.in);
		while (NioClient.send(scanner.next()));




	}



}
