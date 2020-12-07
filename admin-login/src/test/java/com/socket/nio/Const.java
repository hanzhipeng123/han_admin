package com.socket.nio;

import java.util.Date;

/**
 *@author sunq
 *@date2020/10/29 16:19
 *@Description
 */
public class Const {

	public static int DEFAULT_PORT = 12345;
	public static String DEFAULT_SERVER_IP = "127.0.0.1";

	public static String response(String msg){
		return "Hello," + msg + ",Now is " + new Date(System.currentTimeMillis()).toString();
	}



}
